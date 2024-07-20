package tn.esprit.msmatierequery.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.msmatierequery.services.IRendezVousService;

@Service
@RequiredArgsConstructor
public class RendezVousEventHandler {
    private final IRendezVousService matiereService;

    public void handleMatiereCreatedEvent(RendezVousDto matiereDto) {
        matiereService.add(RendezVousDto.mapToMatiere(matiereDto));
    }

    public void handleMatiereUpdatedEvent(RendezVousDto matiereDto) {
        matiereService.update(RendezVousDto.mapToMatiere(matiereDto));
    }

    public void handleMatiereDeletedEvent(long id) {
        matiereService.delete(id);
    }
}
