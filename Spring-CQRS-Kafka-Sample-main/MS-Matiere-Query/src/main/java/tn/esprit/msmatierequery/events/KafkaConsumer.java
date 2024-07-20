package tn.esprit.msmatierequery.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tn.esprit.dto.Event;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final RendezVousEventHandler rendezVousEventHandler;
    private final String topic = "rendezvous-event-topic";

    @KafkaListener(topics = topic, groupId = "my-group")
    public void consume(ConsumerRecord<String, Event> consumerRecord) {

        Event event = consumerRecord.value();

        log.info("\n Consumed Event of type : {} \n published on topic at : {} \n Data value is : {}", event.type(), event.eventCreatedAt(), event.rendezVousDto() );

        switch (consumerRecord.key()) {
            case "CREATED_RENDEZVOUS_EVENT":
                rendezVousEventHandler.handleMatiereCreatedEvent(event.rendezVousDto());
                break;
            case "UPDATED_RENDEZVOUS_EVENT":
                rendezVousEventHandler.handleMatiereUpdatedEvent(event.rendezVousDto());
                break;
            case "DELETED_RENDEZVOUS_EVENT":
                rendezVousEventHandler.handleMatiereDeletedEvent(event.rendezVousDto().id());
                break;
            default:
                log.info("Event ignored");
                break;
        }

    }
}
