package tn.esprit.msmatierecommand.services;

import tn.esprit.dto.RendezVousDto;


import java.util.Map;

public interface IRendezVousService {

    RendezVousDto add(RendezVousDto rendezVousDto);

    RendezVousDto update(long idPAtient, Map<Object,Object> fields);

    boolean delete(long idPatient);


}
