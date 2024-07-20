package tn.esprit.rendezvousms.Service;

import tn.esprit.dto.RendezVousDto;
import tn.esprit.rendezvousms.entity.RendezVous;

import java.util.List;

public interface RendezVousServiceInt {

    public List<RendezVousDto> getAllRendezVous() ;

    public RendezVousDto getRendezVousById(Long id) ;

    public RendezVousDto createRendezVous(RendezVousDto rendezVousDto) ;

    public RendezVousDto updateRendezVous(Long id, RendezVousDto rendezVousDto);

    public void deleteRendezVous(Long id) ;
   // public PatientDto getPatientRdv(long rdvid);
   public RendezVousDto getPatientRdv(long rdvid);

}
