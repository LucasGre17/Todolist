package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Tache extends Model {

    public String nom;
    public String description;
    public boolean isDone;
    public Date dateTime;

    public Tache(String nom, String description) {
        super();
        this.nom = nom;
        this.description = description;
        this.isDone = false;
        this.dateTime = null;
    }
}
