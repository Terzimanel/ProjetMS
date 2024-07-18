package tn.esprit.rendezvousms.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.dto.RendezVousDtokafka;

@Service
public class RendezVousProducer {

    private final KafkaTemplate<String, RendezVousDtokafka> kafkaTemplate;

    public RendezVousProducer(KafkaTemplate<String, RendezVousDtokafka> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(RendezVousDtokafka rendezVous) {
        this.kafkaTemplate.send("rendezvous_topic", rendezVous);
    }
}