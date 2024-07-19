package tn.esprit.patientms.event;

public class PatientCreatedEvent {

    private String id;
    private String nom;
    private int age;
    private String sexe;
    private String historiqueMedical;
    // Constructors, Getters, Setters


    public PatientCreatedEvent() {
    }

    public PatientCreatedEvent(String id, String nom, int age, String sexe, String historiqueMedical) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.historiqueMedical = historiqueMedical;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getHistoriqueMedical() {
        return historiqueMedical;
    }

    public void setHistoriqueMedical(String historiqueMedical) {
        this.historiqueMedical = historiqueMedical;
    }
}
