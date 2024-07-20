package tn.esprit.msmatierequery.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.dto.PatientDTO;
import tn.esprit.msmatierequery.entities.RendezVous;
import tn.esprit.msmatierequery.repositories.RendezVousRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IRendezVousServiceImp implements IRendezVousService {

    private final RendezVousRepository rendezVousRepository;
    private final RestTemplate restTemplate;

    private final String MODULE_MS_URL = "http://localhost:9090/rendezvous/get"; // Change to the actual module-ms URL

    private PatientDTO getModuleById(Long moduleId) {
        if (moduleId == null) {
            return null; // Or handle appropriately
        }
        return restTemplate.getForObject(MODULE_MS_URL + "/" + moduleId, PatientDTO.class);
    }

    @Override
    public RendezVous add(RendezVous matiere) {
        matiere.setDate(LocalDateTime.now());
        return rendezVousRepository.save(matiere);
    }

    @Override
    public RendezVous update(RendezVous matiere) {
        return rendezVousRepository.save(matiere);
    }

    @Override
    public boolean delete(long id) {
        rendezVousRepository.deleteById(id);
        return !rendezVousRepository.existsById(id);
    }

    @Override
    public List<RendezVousDto> getMatieres() {
        return rendezVousRepository.findAll().stream()
                .map(matiere -> {
                    RendezVousDto matiereDto = RendezVousDto.mapToMatiereDto(matiere);
                    PatientDTO patientDTO = getModuleById(matiereDto.id());
                    return new RendezVousDto(matiereDto.id(), matiereDto.date(), matiereDto.lieu(), matiereDto.patientId(), matiereDto.medecin(),patientDTO);
                })
                .collect(Collectors.toList());
    }

    @Override
    public RendezVousDto getMatiere(long id) {
        RendezVous matiere = rendezVousRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matiere not found: " + id));
        RendezVousDto matiereDto = RendezVousDto.mapToMatiereDto(matiere);
        PatientDTO patientDTO = getModuleById(matiereDto.id());
        return new RendezVousDto(matiereDto.id(), matiereDto.date(), matiereDto.lieu(), matiereDto.patientId(), matiereDto.medecin(),patientDTO);
    }

    @Override
    public RendezVousDto getMatiereByName(String name) {
        RendezVous matiere = rendezVousRepository.findByLieu(name)
                .orElseThrow(() -> new IllegalArgumentException("rendez vous not found with name: " + name));
        RendezVousDto matiereDto = RendezVousDto.mapToMatiereDto(matiere);
        PatientDTO patientDTO = getModuleById(matiereDto.id());
        return new RendezVousDto(matiereDto.id(), matiereDto.date(), matiereDto.lieu(), matiereDto.patientId(), matiereDto.medecin(),patientDTO);
    }
}
