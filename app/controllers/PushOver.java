package controllers;

import models.Tache;
import play.jobs.Every;
import play.jobs.Job;

import java.util.List;

@Every("1mn")
public class PushOver extends Job {
    public void doJob() {

        List<Tache> tacheList = Tache.findAll();
        for (Tache tache : tacheList) {
            if (tache.dateTime != null) {
                //Si la minute de la tache est à la même minute que l'heure actuelle (dépendant du jour)
                if (java.time.Duration.between(tache.dateTime.toInstant(), java.time.Instant.now()).toMinutes() == 0) {
                    System.out.println("Tache notification: " + tache.nom + " " + tache.dateTime);
                }
            }
        }
    }
}
