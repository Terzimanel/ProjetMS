package tn.esprit.rendezvousms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rendezvousms.Service.RendezVousServiceInt;
import tn.esprit.dto.RendezVousDto;

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
    public List<RendezVousDto> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RendezVousDto> getRendezVousById(@PathVariable Long id) {
        RendezVousDto rendezVousDto = rendezVousService.getRendezVousById(id);
        if (rendezVousDto != null) {
            return ResponseEntity.ok(rendezVousDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RendezVousDto> createRendezVous(@RequestBody RendezVousDto rendezVousDto) {
        RendezVousDto createdRendezVous = rendezVousService.createRendezVous(rendezVousDto);
        return ResponseEntity.ok(createdRendezVous);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVousDto> updateRendezVous(@PathVariable Long id, @RequestBody RendezVousDto rendezVousDto) {
        RendezVousDto updatedRendezVous = rendezVousService.updateRendezVous(id, rendezVousDto);
        if (updatedRendezVous != null) {
            return ResponseEntity.ok(updatedRendezVous);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
        return ResponseEntity.noContent().build();
    }
}
