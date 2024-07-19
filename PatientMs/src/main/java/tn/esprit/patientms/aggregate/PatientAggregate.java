package tn.esprit.patientms.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import tn.esprit.patientms.command.CreatePatientCommand;
import tn.esprit.patientms.event.PatientCreatedEvent;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PatientAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private int age;
    private String sexe;
    private String historiqueMedical;

    @CommandHandler
    public PatientAggregate(CreatePatientCommand command) {
        apply(new PatientCreatedEvent(
                command.getId(), command.getNom(), command.getAge(), command.getSexe(), command.getHistoriqueMedical()));
    }

    @EventSourcingHandler
    protected void on(PatientCreatedEvent event) {
        this.id = event.getId();
        this.nom = event.getNom();
        this.age = event.getAge();
        this.sexe = event.getSexe();
        this.historiqueMedical = event.getHistoriqueMedical();
    }
}