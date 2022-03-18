package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tache extends Model {

    @Id
    @GeneratedValue
    public Long id;
    public String nom;
    public String description;

    public Tache(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }


}
