package tn.esprit.patientms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tn.esprit.dto.PatientDto;
import tn.esprit.patientms.entity.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDto PatientToPatientDto(Patient patient);

    Patient PatientDtoToPatient(PatientDto patientDto);
}
