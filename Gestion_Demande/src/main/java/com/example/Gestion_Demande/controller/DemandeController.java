package com.example.Gestion_Demande.controller;

import com.example.Gestion_Demande.entity.Demande;
import com.example.Gestion_Demande.entity.User;
import com.example.Gestion_Demande.services.DemandeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/demande")
public class DemandeController {
    @Autowired
    DemandeService demandeService;
    @GetMapping(path = "/getAll")
    List<Demande> getAllUsers() {
        return demandeService.findAll();
    }
    @PostMapping()
    public ResponseEntity<Demande> saveVoiture(@RequestBody Demande
                                                       demande){
        return new
                ResponseEntity<Demande>(demandeService.save(demande),
                HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<Demande> getDemandeById(@PathVariable("id")
                                                  long id){
        return new
                ResponseEntity<Demande>(demandeService.findById(id),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Demande updateDemande(@PathVariable("id") Long id, @RequestBody Demande demande) {
        return demandeService.updatedemande(demande, id);
    }


    // build delete employee REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteproduit(@PathVariable("id") long
                                                        id){
        demandeService.delete(id);
        return new ResponseEntity<String>("demande deleted successfully!.", HttpStatus.OK);
    }
}
