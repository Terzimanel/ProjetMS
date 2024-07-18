package tn.esprit.patientms.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tn.esprit.dto.RendezVousDtokafka;
import tn.esprit.patientms.Service.PatientService;

@Service
public class RendezVousConsumer {

    private final PatientService patientService;

    public RendezVousConsumer(PatientService patientService) {
        this.patientService = patientService;
    }

   /* @KafkaListener(topics = "rendezvous_topic", groupId = "group_id")
    public void consume(RendezVousDtokafka rendezVous) {
        // Logic to handle the received event
        // ...
    }*/
}
