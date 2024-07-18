package tn.esprit.rendezvousms.Service;

import tn.esprit.dto.RendezVousDto;
import tn.esprit.rendezvousms.entity.RendezVous;

import java.util.List;

public interface RendezVousServiceInt {

    public List<RendezVous> getAllRendezVous() ;

    public RendezVous getRendezVousById(Long id) ;

    public RendezVous createRendezVous(RendezVous rendezVous) ;

    public RendezVous updateRendezVous(Long id, RendezVous rendezVous) ;

    public void deleteRendezVous(Long id) ;
   // public PatientDto getPatientRdv(long rdvid);
   public RendezVousDto getPatientRdv(long rdvid);
    public void createRDV(RendezVous rendezVous);
}
