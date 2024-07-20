package tn.esprit.msmatierecommand.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tn.esprit.dto.Event;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {


    private final KafkaTemplate<String, Event> kafkaTemplate;
    private String topic = "rendezvous-event-topic";

    public void produceEvent(Event rendezvousEvent) {
        kafkaTemplate.send(this.topic, rendezvousEvent.type().toString() , rendezvousEvent);
    }

}
