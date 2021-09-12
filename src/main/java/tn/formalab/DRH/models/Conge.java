package tn.formalab.DRH.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "conges")

public class Conge {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "nomprenom", nullable = false)
    public String nomprenom;

    @Column(name = "poste", nullable = false)
    public String poste;

    @Column(name = "datedebut", nullable = false)
    public String datedebut;

    @Column(name = "datefin", nullable = false)
    public String datefin;

    @Column(name = "cause", nullable = false)
    public String cause;


}
