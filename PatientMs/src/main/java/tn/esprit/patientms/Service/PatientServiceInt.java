package tn.esprit.patientms.Service;

import tn.esprit.patientms.entity.Patient;

import java.util.List;

public interface PatientServiceInt {
    public List<Patient> getAllPatients() ;

    public Patient getPatientById(String id) ;

    public Patient createPatient(Patient patient) ;

    public Patient updatePatient(String id, Patient patient) ;

    public void deletePatient(String id) ;
}
