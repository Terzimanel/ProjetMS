package tn.esprit.dto;


import tn.esprit.msmatierequery.entities.RendezVous;

import java.time.LocalDateTime;

public record RendezVousDto(  Long id,
                              LocalDateTime date,
                              String lieu,
                              String patientId,
                              String medecin
,PatientDTO patientDTO) {
    public static RendezVous mapToMatiere(RendezVousDto rendezVousDto) {
        return new RendezVous(rendezVousDto.id(),rendezVousDto.date(),rendezVousDto.lieu(), rendezVousDto.patientId(), rendezVousDto.medecin());

    }

    public static RendezVousDto mapToMatiereDto(RendezVous rendezVous) {
        PatientDTO patientDTO = null;
        // Here you should fetch the moduleDTO based on matiere.getModuleId() if needed
        // For example: moduleDTO = moduleService.findModuleById(matiere.getModuleId());

        return new RendezVousDto(rendezVous.getId(),rendezVous.getDate(), rendezVous.getLieu(), rendezVous.getPatientId(), rendezVous.getMedecin(),patientDTO);
    }
}
