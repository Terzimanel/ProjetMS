package tn.esprit.rendezvousms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rendezvousms.client.PaientClient;
import tn.esprit.dto.PatientDto;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.dto.RendezVousDtokafka;
import tn.esprit.rendezvousms.entity.RendezVous;
import tn.esprit.rendezvousms.kafka.RendezVousProducer;
import tn.esprit.rendezvousms.mapper.RendezVousDtokafkaMapper;
import tn.esprit.rendezvousms.mapper.RendezVousMapper;
import tn.esprit.rendezvousms.repository.RendezVousRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RendezVousService implements RendezVousServiceInt {
    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Autowired
    private PaientClient paientClient;

    @Autowired
    private RendezVousMapper rendezVousMapper;

    @Autowired
    private RendezVousDtokafkaMapper rendezVousDtokafkaMapper;

    @Autowired
    private RendezVousProducer kafkaSenderService;

    @Override
    public List<RendezVousDto> getAllRendezVous() {
        return rendezVousRepository.findAll().stream()
                .map(rendezVousMapper::RendezVousToRendezVousDto)
                .collect(Collectors.toList());
    }

    @Override
    public RendezVousDto getRendezVousById(Long id) {
        return rendezVousRepository.findById(id)
                .map(rendezVousMapper::RendezVousToRendezVousDto)
                .orElse(null);
    }

    @Override
    public RendezVousDto createRendezVous(RendezVousDto rendezVousDto) {
        RendezVous rendezVous = rendezVousMapper.RendezVousDtoToRendezVous(rendezVousDto);
        RendezVousDtokafka rendezVousDtokafka = rendezVousDtokafkaMapper.rendezVousToRendezVousDtoKafka(rendezVous);
        kafkaSenderService.sendMessage("rendezvous-events", "Rendez-vous créé: " + rendezVousDtokafka.getId());

        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        return rendezVousMapper.RendezVousToRendezVousDto(savedRendezVous);
    }

    @Override
    public RendezVousDto updateRendezVous(Long id, RendezVousDto rendezVousDto) {
        if (rendezVousRepository.existsById(id)) {
            RendezVous rendezVous = rendezVousMapper.RendezVousDtoToRendezVous(rendezVousDto);
            rendezVous.setId(id);
            RendezVous updatedRendezVous = rendezVousRepository.save(rendezVous);
            return rendezVousMapper.RendezVousToRendezVousDto(updatedRendezVous);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public RendezVousDto getPatientRdv(long rdvid) {
        RendezVous rendezVous = rendezVousRepository.findById(rdvid)
                .orElseThrow(() -> new RuntimeException("rdv not found"));

        RendezVousDto rendezVousDto = rendezVousMapper.RendezVousToRendezVousDto(rendezVous);

        PatientDto patientDto = paientClient.getPatientById(rendezVous.getPatientId());

        rendezVousDto.setPatient(patientDto);

        return rendezVousDto;
    }
}
