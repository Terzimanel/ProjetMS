package tn.esprit.rendezvousms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rendezvousms.client.PaientClient;
import tn.esprit.dto.PatientDto;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.dto.RendezVousDtokafka;
import tn.esprit.rendezvousms.entity.RendezVous;
import tn.esprit.rendezvousms.kafka.KafkaProducerService;
import tn.esprit.rendezvousms.kafka.RendezVousProducer;
import tn.esprit.rendezvousms.mapper.RendezVousDtokafkaMapper;
import tn.esprit.rendezvousms.mapper.RendezVousMapper;
import tn.esprit.rendezvousms.repository.RendezVousRepository;

import java.util.List;

@Service
public class RendezVousService implements RendezVousServiceInt{
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private RendezVousProducer producer;
    @Autowired
    private PaientClient paientClient;
    @Autowired
    private RendezVousMapper rendezVousMapper;
    @Autowired
    private RendezVousDtokafkaMapper rendezVousDtokafkaMapper;
    @Autowired
    private KafkaProducerService kafkaProducerService;
   /* public void createRDV(RendezVous rendezVous) {
        // Save RendezVous to the database
        rendezVousRepository.save(rendezVous);
        // Send event to Kafka
        kafkaProducer.sendMessage( rendezVous);
    }*/
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    public RendezVous getRendezVousById(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    public RendezVous createRendezVous(RendezVous rendezVous) {
        RendezVousDtokafka rendezVousDtokafka = rendezVousDtokafkaMapper.rendezVousToRendezVousDtoKafka(rendezVous);
        //kafkaProducerService.sendMessage(rendezVousDtokafka);
     //   producer.sendMessage(rendezVousDtokafka);
        return rendezVousRepository.save(rendezVous);
    }

    public RendezVous updateRendezVous(Long id, RendezVous rendezVous) {
        if (rendezVousRepository.existsById(id)) {
            rendezVous.setId(id);
            return rendezVousRepository.save(rendezVous);
        } else {
            return null;
        }
    }

    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    //OpenFeign
   /* public PatientDto getPatientRdv(long rdvid) {
        RendezVous rendezVous = rendezVousRepository.findById(rdvid).orElseThrow(() -> new RuntimeException("rdv not found"));
        PatientDto patientDto = paientClient.getPatientById(rendezVous.getPatientId());
        return patientDto;
    }*/

    public RendezVousDto getPatientRdv(long rdvid) {
        RendezVous rendezVous = rendezVousRepository.findById(rdvid)
                .orElseThrow(() -> new RuntimeException("rdv not found"));

        // Utilisation du mapper pour convertir l'entité RendezVous en RendezVousDto
        RendezVousDto rendezVousDto = rendezVousMapper.RendezVousToRendezVousDto(rendezVous);

        // Récupération des informations du patient
        PatientDto patientDto = paientClient.getPatientById(rendezVous.getPatientId());

        // Ajout des informations du patient au DTO du rendez-vous
        rendezVousDto.setPatient(patientDto);

        return rendezVousDto;
    }

    @Override
    public void createRDV(RendezVous rendezVous) {

    }
}

