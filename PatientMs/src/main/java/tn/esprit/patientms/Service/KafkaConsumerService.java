package tn.esprit.patientms.Service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tn.esprit.dto.RendezVousDtokafka;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "rendezvous_topic", groupId = "patient_group")
    public void consumeMessage(RendezVousDtokafka message) {
        System.out.println("Message reçu : " + message);
        // Logique pour traiter le message
    }
}
