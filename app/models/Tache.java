package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

import java.util.Date;

@Entity
public class Tache extends Model {

    public String nom;
    public String description;
    public boolean isDone;
    public Date dateTime;

    public Tache(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.isDone = false;
        this.dateTime = null;
    }
}
