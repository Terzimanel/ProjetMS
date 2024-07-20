package tn.esprit.patientms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dto.PatientDto;
import tn.esprit.patientms.entity.Patient;
import tn.esprit.patientms.mapper.PatientMapper;
import tn.esprit.patientms.repository.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements PatientServiceInt {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patientMapper::PatientToPatientDto)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(String id) {
        return patientRepository.findById(id)
                .map(patientMapper::PatientToPatientDto)
                .orElse(null);
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = patientMapper.PatientDtoToPatient(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.PatientToPatientDto(savedPatient);
    }

    @Override
    public PatientDto updatePatient(String id, PatientDto patientDto) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientMapper.PatientDtoToPatient(patientDto);
            patient.setId(id);
            Patient updatedPatient = patientRepository.save(patient);
            return patientMapper.PatientToPatientDto(updatedPatient);
        } else {
            return null;
        }
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
