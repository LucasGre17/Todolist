package controllers;

import models.Tache;
import play.jobs.Every;
import play.jobs.Job;
import play.libs.WS;


import java.io.IOException;
import java.util.List;


@Every("1mn")
public class PushOver extends Job {

    private static final String userKey = "uiixybgk652hqnvbvcnbv1gotmg852";
    private static final String ApiToken = "aajrvfkv2i8avbx3cfhkr7jjnisyp8";

    public void doJob() throws IOException {

        List<Tache> tacheList = Tache.findAll();
        for (Tache tache : tacheList) {
            if (tache.dateTime != null) {
                //Si la minute de la tache est à la même minute que l'heure actuelle (dépendant du jour)
                if (java.time.Duration.between(tache.dateTime.toInstant(), java.time.Instant.now()).toMinutes() == 0) {

                    //POST REQUEST
                    WS.url("https://api.pushover.net/1/messages.json?token="+ApiToken+"&user="+userKey+"&message="+tache.nom)
                            .post();
                }
            }
        }
    }
}
