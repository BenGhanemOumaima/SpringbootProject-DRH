package tn.formalab.DRH.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.formalab.DRH.models.Recrutement;
import tn.formalab.DRH.repositories.RecrutementRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("recrutements")

public class RecrutementController {
    private RecrutementRepository recrutementRepository;

    @Autowired
    public RecrutementController(RecrutementRepository recrutementRepository) {this.recrutementRepository = recrutementRepository;}

    @PostMapping(path = "add")
    public ResponseEntity<Recrutement> addRecrutement(@RequestBody Recrutement recrutement){
        Recrutement savedRecrutement = this.recrutementRepository.save(recrutement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecrutement);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Recrutement>> getAllRecrutements(){
        List<Recrutement> recrutements = this.recrutementRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(recrutements);
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Map<String,String>> deleteRecrute(@PathVariable Integer id){
        this.recrutementRepository.deleteById(id);

        HashMap<String,String> obj = new HashMap<>();
        obj.put("message","Recruté(e) supprimé(e) avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

}
