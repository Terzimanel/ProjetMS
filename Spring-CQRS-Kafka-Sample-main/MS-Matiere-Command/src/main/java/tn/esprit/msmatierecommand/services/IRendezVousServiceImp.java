package tn.esprit.msmatierecommand.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;
import tn.esprit.dto.Event;
import tn.esprit.dto.EventType;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.dto.PatientDTO;
import tn.esprit.msmatierecommand.entities.RendezVous;
import tn.esprit.msmatierecommand.events.KafkaProducer;
import tn.esprit.msmatierecommand.repositories.RendezVousRepository;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IRendezVousServiceImp implements IRendezVousService {
    private final RendezVousRepository rendezVousRepository;
    private final KafkaProducer kafkaProducer;
    private final RestTemplate restTemplate;

    private final String RENDEZVOUS_MS_URL = "http://localhost:9090/rendezvous/get"; // Change to the actual module-ms URL

    public PatientDTO getModuleById(String patientid) {
        return restTemplate.getForObject(RENDEZVOUS_MS_URL + "/" + patientid, PatientDTO.class);
    }

    @Override
    public RendezVousDto add(RendezVousDto rendezVousDto) {
        RendezVous matiere = RendezVousDto.mapToMatiere(rendezVousDto);
        matiere.setDate(LocalDateTime.now());
        rendezVousDto = RendezVousDto.mapToMatiereDto(rendezVousRepository.save(matiere));

        // Fetch the ModuleDTO using RestTemplate if moduleId is not null
        if (rendezVousDto.patientId() != null) {
            PatientDTO patientDTO = getModuleById(rendezVousDto.patientId());
            rendezVousDto = new RendezVousDto(rendezVousDto.id(),rendezVousDto.date(),rendezVousDto.lieu(), rendezVousDto.patientId(), rendezVousDto.medecin());
        }

        kafkaProducer.produceEvent(new Event(EventType.CREATED_RENDEZVOUS_EVENT, rendezVousDto, LocalDateTime.now()));
        return rendezVousDto;
    }

    @Override
    public RendezVousDto update(long id, Map<Object, Object> fields) {
        RendezVous matiere = rendezVousRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matiere not found: " + id));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(RendezVous.class, (String) key);
            field.setAccessible(true);

            if (field.getType().equals(LocalDate.class)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, matiere, localDate);
            } else {
                ReflectionUtils.setField(field, matiere, value);
            }
        });

        matiere.setDate(LocalDateTime.now());
        RendezVousDto rendezVousDto = RendezVousDto.mapToMatiereDto(rendezVousRepository.save(matiere));

        // Fetch the ModuleDTO using RestTemplate if moduleId is not null
        if (rendezVousDto.patientId() != null) {
            PatientDTO patientDTO = getModuleById(rendezVousDto.patientId());
            rendezVousDto = new RendezVousDto(rendezVousDto.id(),rendezVousDto.date(),rendezVousDto.lieu(), rendezVousDto.patientId(), rendezVousDto.medecin());
        }

        kafkaProducer.produceEvent(new Event(EventType.UPDATED_RENDEZVOUS_EVENT, rendezVousDto, LocalDateTime.now()));
        return rendezVousDto;
    }

    @Override
    public boolean delete(long id) {
        RendezVousDto rendezVousDto = RendezVousDto.mapToMatiereDto(rendezVousRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matiere not found: " + id)));

        rendezVousRepository.deleteById(id);
        kafkaProducer.produceEvent(new Event(EventType. DELETED_RENDEZVOUS_EVENT, rendezVousDto, LocalDateTime.now()));

        return !rendezVousRepository.existsById(id);
    }

}
