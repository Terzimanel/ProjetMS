package tn.esprit.dto;

public record PatientDTO(String id,
                         String nom,
                         int age,
                         String sexe,
                         String historiqueMedical) {

}
