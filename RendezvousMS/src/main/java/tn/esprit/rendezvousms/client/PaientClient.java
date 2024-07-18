package tn.esprit.rendezvousms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.dto.PatientDto;

@FeignClient(name = "patients", url = "http://localhost:9091")
public interface PaientClient {
    @GetMapping("/patients/{id}")
    PatientDto getPatientById(@PathVariable String id);
}
