package tn.esprit.patientms.Service;

import tn.esprit.dto.PatientDto;
import tn.esprit.patientms.entity.Patient;

import java.util.List;

public interface PatientServiceInt {
    public List<PatientDto> getAllPatients() ;

    public PatientDto getPatientById(String id) ;

    public PatientDto createPatient(PatientDto patient) ;

    public PatientDto updatePatient(String id, PatientDto patient) ;

    public void deletePatient(String id) ;
}
