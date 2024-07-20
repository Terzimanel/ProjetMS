package tn.esprit.msmatierequery.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.msmatierequery.entities.RendezVous;

import java.util.Optional;

public interface RendezVousRepository extends MongoRepository<RendezVous, Long> {

    Optional<RendezVous> findByLieu(String name);
}
