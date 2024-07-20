package tn.esprit.msmatierequery.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.msmatierequery.services.IRendezVousService;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
@RequiredArgsConstructor
public class MatiereRestControllerQuery {

    private final IRendezVousService matiereService;

    @GetMapping
    public List<RendezVousDto> getMatieres(){
        return matiereService.getMatieres();
    }

    @GetMapping("{id}")
    public RendezVousDto getMatiere(@PathVariable long id){
        return matiereService.getMatiere(id);
    }

    @GetMapping("name/{name}")
    public RendezVousDto getMatiere(@PathVariable String name){
        return matiereService.getMatiereByName(name);
    }







}
