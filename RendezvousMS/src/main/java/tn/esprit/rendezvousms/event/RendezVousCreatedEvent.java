package tn.esprit.rendezvousms.event;

import java.time.LocalDateTime;

public class RendezVousCreatedEvent {

    private Long id;
    private LocalDateTime date;
    private String lieu;
    private String patientId;
    private String medecin;
    // Constructors, Getters, Setters


    public RendezVousCreatedEvent() {
    }

    public RendezVousCreatedEvent(Long id, LocalDateTime date, String lieu, String patientId, String medecin) {
        this.id = id;
        this.date = date;
        this.lieu = lieu;
        this.patientId = patientId;
        this.medecin = medecin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getMedecin() {
        return medecin;
    }

    public void setMedecin(String medecin) {
        this.medecin = medecin;
    }
}
