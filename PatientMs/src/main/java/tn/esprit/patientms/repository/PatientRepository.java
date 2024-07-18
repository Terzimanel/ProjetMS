package tn.esprit.patientms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.patientms.entity.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
