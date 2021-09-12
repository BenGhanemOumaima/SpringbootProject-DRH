package tn.formalab.DRH.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recrutements")

public class Recrutement {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "nom", nullable = false)
    public String nom;

    @Column(name = "prenom", nullable = false)
    public String prenom;

    @Column(name = "ville", nullable = false)
    public String ville;

    @Column(name = "datenaissance", nullable = false)
    public String datenaissance;

    @Column(name = "nationnalite", nullable = false)
    public String nationnalite;

    @Column(name = "telephone", nullable = false)
    public String telephone;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "poste", nullable = false)
    public String poste;

    @Column(name = "secteur", nullable = false)
    public String secteur;

    @Column(name = "dispo", nullable = false)
    public String dispo;

    @Column(name = "cv", nullable = false)
    public String cv;

    @Column(name = "motivation", nullable = false)
    public String motivation;

    @Column(name = "situation", nullable = false)
    public String situation;

    @Column(name = "diplome", nullable = false)
    public String diplome;
}
