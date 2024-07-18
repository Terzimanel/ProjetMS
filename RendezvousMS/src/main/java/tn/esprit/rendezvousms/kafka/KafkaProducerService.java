package tn.esprit.rendezvousms.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.dto.RendezVousDtokafka;

@Service
public class KafkaProducerService {
/*
    private static final String TOPIC = "rendezvous_topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(RendezVousDtokafka message) {
        kafkaTemplate.send(TOPIC, message);
    }*/
}
