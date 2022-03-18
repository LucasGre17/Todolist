package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tache extends Model {

    @Id
    public Long id;
    public String nom;
    public String description;

    public Tache(Long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }
}
