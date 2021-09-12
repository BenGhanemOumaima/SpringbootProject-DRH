package tn.formalab.DRH.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.DRH.models.Conge;
import tn.formalab.DRH.models.Personnel;
import tn.formalab.DRH.repositories.CongeRepository;
import tn.formalab.DRH.repositories.PersonelRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("conges")

public class CongeController {
    private CongeRepository congeRepository;

    @Autowired
    public CongeController(CongeRepository congeRepository) {this.congeRepository = congeRepository;}

    @PostMapping(path = "add")
    public ResponseEntity<Conge> addConge(@RequestBody Conge conge){
        Conge savedConge = this.congeRepository.save(conge);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConge);
    }
    @GetMapping(path = "all")
    public ResponseEntity<List<Conge>> getAllConges(){
        List<Conge> conges = this.congeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(conges);
    }
}
