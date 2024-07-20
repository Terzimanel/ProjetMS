package tn.esprit.msmatierequery.services;

import tn.esprit.dto.RendezVousDto;
import tn.esprit.msmatierequery.entities.RendezVous;

import java.util.List;

public interface IRendezVousService {

    RendezVous add(RendezVous matiere);
    RendezVous update(RendezVous matiere);
    boolean delete(long id);


    List<RendezVousDto> getMatieres();

    RendezVousDto getMatiere(long id);

    RendezVousDto getMatiereByName(String name);
}
