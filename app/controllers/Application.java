package controllers;

import models.Tache;
import play.mvc.Controller;
import play.mvc.Router;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application extends Controller {

    // Affiche toutes les tâches (voir variable taches) dans le template views/listTache.html
    public static void listTache() {
        List<Tache> taches = Tache.findAll();
        render(taches);
    }

    // Affiche le template views/ajouterTacheForm.html (formulaire d'ajout d'une tâche)
    public static void ajouterTacheForm() {
        render();
    }

    // Ajoute une nouvelle tâche en base de données et affiche le template views/ajouterTache.html
    public static void ajouterTache(String nom, String message) {
        Tache tache = new Tache(nom, message);
        tache.save();
        render();
    }

    // Change le statut d'une tâche en base de données
    public static void validerTache(Long id) {
        Tache tache = Tache.findById(id);
        tache.isDone = !tache.isDone;
        tache.save();
    }

    // Supprime une tâche en base de données
    public static void supprimerTache(Long id) {
        Tache tache = Tache.findById(id);
        tache.delete();
    }

    // Modifie une tâche en base de données
    public static void editTache(Long id, String title) {
        Tache tache = Tache.findById(id);
        tache.nom = title;
        tache.save();
    }

    public static void editDateTache(Long id, String date) throws ParseException {

        if(!date.isEmpty()) {
            date = date.replace("T", " ");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date newDate = dateFormat.parse(date);

            Tache tache = Tache.findById(id);
            tache.dateTime = newDate;
            tache.save();
        }else {
            Tache tache = Tache.findById(id);
            tache.dateTime = null;
            tache.save();
        }
    }

}