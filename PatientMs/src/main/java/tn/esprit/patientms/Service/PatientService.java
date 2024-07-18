package tn.esprit.patientms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.patientms.entity.Patient;
import tn.esprit.patientms.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService implements PatientServiceInt{
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(String id, Patient patient) {
        if (patientRepository.existsById(id)) {
            patient.setId(id);
            return patientRepository.save(patient);
        } else {
            return null;
        }
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}

