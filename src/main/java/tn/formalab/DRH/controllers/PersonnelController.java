package tn.formalab.DRH.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.formalab.DRH.models.Personnel;
import tn.formalab.DRH.repositories.PersonelRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("personnels")
public class PersonnelController {
    private PersonelRepository personelRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public PersonnelController(PersonelRepository personelRepository) {this.personelRepository = personelRepository;}

    @PostMapping(path = "add")
    public ResponseEntity<Personnel> addPersonnel(@RequestBody Personnel personnel){
        Personnel savedPersonnel = this.personelRepository.save(personnel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonnel);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Personnel>> getAllPersonnels(){
        List<Personnel> personnels = this.personelRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(personnels);
    }

    @GetMapping(path = "one/{id}")
    public ResponseEntity<Personnel> getPersonnelByID(@PathVariable Integer id){
        try{
            Personnel personnel = personelRepository.findById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(personnel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Personnel());
        }
    }

    @PatchMapping(path = "update")
    public ResponseEntity<Personnel> updatePersonnel(@RequestBody Personnel personnel){
        Personnel updatedPersonnel = this.personelRepository.save(personnel);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedPersonnel);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Map<String,String>> deletePersonnel(@PathVariable Integer id){
        this.personelRepository.deleteById(id);

        HashMap<String,String> obj = new HashMap<>();
        obj.put("message","Employé(e) supprimé(e) avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Personnel personnel) {

        HashMap<String, Object> response = new HashMap<>();

        Personnel persoFromDB = personelRepository.findByEmail(personnel.email);

        if (persoFromDB == null) {
            response.put("message", "user not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
/*
            Boolean compare = this.bCryptPasswordEncoder.matches(personnel.code, persoFromDB.code);

            if (!compare) {
                response.put("message", "user not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {*/

                if (!persoFromDB.statut) {
                    response.put("message", "user not allowed !");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                } else {
                    String token = Jwts.builder()
                            .claim("data", persoFromDB)
                            .signWith(SignatureAlgorithm.HS256, "SECRET")
                            .compact();

                    response.put("token", token);

                    return ResponseEntity.status(HttpStatus.OK).body(response);
                }
            //}
        }
    }
}
