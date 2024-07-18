package tn.esprit.rendezvousms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rendezvousms.Service.RendezVousServiceInt;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.rendezvousms.entity.RendezVous;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
    @Autowired
    private RendezVousServiceInt rendezVousService;



    @GetMapping("rdv/{rdvid}")
    public ResponseEntity<RendezVousDto> getPatientRdv(@PathVariable long rdvid) {
        RendezVousDto rendezVousDto = rendezVousService.getPatientRdv(rdvid);
        return ResponseEntity.ok(rendezVousDto);
    }
    @GetMapping
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GetMapping("/{id}")
    public RendezVous getRendezVousById(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id);
    }

    @PostMapping
    public RendezVous createRendezVous(@RequestBody RendezVous rendezVous) {



        return rendezVousService.createRendezVous(rendezVous);
    }

    @PutMapping("/{id}")
    public RendezVous updateRendezVous(@PathVariable Long id, @RequestBody RendezVous rendezVous) {
        return rendezVousService.updateRendezVous(id, rendezVous);
    }

    @DeleteMapping("/{id}")
    public void deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
    }
}
