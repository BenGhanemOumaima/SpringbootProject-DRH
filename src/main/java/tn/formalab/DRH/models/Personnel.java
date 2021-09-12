package tn.formalab.DRH.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personnels")

public class Personnel {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "code" , unique = true, nullable = false)
    public String code;

    @Column(name = "photo", nullable = true)
    public String photo;

    @Column(name = "nom", nullable = false)
    public String nom;

    @Column(name = "prenom", nullable = false)
    public String prenom;

    @Column(name = "poste", nullable = false)
    public String poste;

    @Column(name = "datedebut", nullable = false)
    public String datedebut;

    @Column(name = "datenaissance", nullable = false)
    public String datenaissance;

    @Column(name = "salaire", nullable = false)
    public Double salaire;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @Column(name = "telephone", nullable = false)
    public String telephone;

    @Column(name = "statut", nullable = false)
    public Boolean statut = true;
}
