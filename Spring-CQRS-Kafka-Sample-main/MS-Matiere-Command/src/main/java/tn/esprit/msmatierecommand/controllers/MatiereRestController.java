package tn.esprit.msmatierecommand.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dto.RendezVousDto;
import tn.esprit.msmatierecommand.services.IRendezVousService;

import java.util.Map;

@RestController
@RequestMapping("/rendezvous")
@RequiredArgsConstructor
public class MatiereRestController {
    private final IRendezVousService productService;

    @PostMapping
    public RendezVousDto add(@RequestBody RendezVousDto rendezVousDto) {
        return productService.add(rendezVousDto);
    }

    @PatchMapping("{id}")
    public RendezVousDto patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable long id){
        return productService.update(id,fields);
    }

    @DeleteMapping("{id}")
    public boolean delete( @PathVariable long id){
        return productService.delete(id);
    }







}
