package tn.esprit.patientms.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class KafkaReceiverService {
    @KafkaListener(topics = "rendezvous-events", groupId = "patient_group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        // Traitement du message reçu
    }
}
