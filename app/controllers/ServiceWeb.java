package controllers;

import models.Tache;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Http.Header;

import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ServiceWeb extends Controller {

    // Ajoute une tâche en base de données (CREATE => POST)
    // Test (curl) : curl --data "nomTache=task-from-curl" localhost:9000/api/tache
    public static void ajouterTache() {
        Map<String, Header> headers = request.headers;
        for (Entry<String, Header> entry : headers.entrySet()) {
            if(entry.getKey().equals("content-type")) {
                System.out.println("Content type is '" + entry.getValue() + "'");
            }
        }

        Request request = Request.current();
        InputStream content = request.body;
        String str = "";
        String headerStr = "";
        try {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int length;
            while ((length = content.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            str = result.toString();
            System.out.println("Body send data is this form :\n" + str);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Map<String, String> datas = new HashMap<>();

        String[] attrs = str.split("&"); //Si il y a plusieurs parametres

        for(int i = 0; i < attrs.length; i++) {
            String[] tmp = attrs[i].split("=");

            for(int j = 0; j < tmp.length; j += 2) {
                datas.put(tmp[j], tmp[j+1]);
            }
        }

        String nom = datas.get("nom") != null ? datas.get("nom") : "";
        String description = datas.get("description") != null ? datas.get("description") : "";

        Tache tache = new Tache(nom, description);
        tache.save();
        renderJSON(tache);
    }

    // Retourne au format JSON la liste des tâches (READ => GET)
    // Test (curl) : curl localhost:9000/api/taches.json
    public static void listTache() {
        List<Tache> tacheList = Tache.findAll();
        renderJSON(tacheList);
    }

    // Retourne au format JSON une tâche (READ => GET)
    // Test (curl) : curl localhost:9000/api/tache/1.json
    public static void getTache(Long id) {
        Tache tache = Tache.findById(id);
        renderJSON(tache);
    }

    // Modifie le titre d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/1
    public static void editTitleTache(Long id, String title) {
        Tache tache = Tache.findById(id);
        tache.nom = title;
        tache.save();
        renderJSON(tache);
    }

    // Change le statut d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/1
    public static void changeStatutTache(Long id) {
        Tache tache = Tache.findById(id);
        tache.isDone = !tache.isDone;
        tache.save();
        renderJSON(tache);
    }

    // Supprime une tâche (DELETE => DELETE)
    // Test (curl) : curl -X DELETE localhost:9000/api/tache/1
    public static void supprimeTache(Long id) {
        Tache tache = Tache.findById(id);
        tache.delete();
    }

    public static void editDateTache(Long id, String date) throws ParseException {
        date = date.replace("T"," ");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date newDate = dateFormat.parse(date);

        Tache tache = Tache.findById(id);
        tache.dateTime = newDate;
        tache.save();
    	renderJSON(tache);
    }

}
