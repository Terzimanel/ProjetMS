package tn.esprit.patientms.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "rendezvous", url = "http://localhost:9091")

public interface RendezVousClient {

}
