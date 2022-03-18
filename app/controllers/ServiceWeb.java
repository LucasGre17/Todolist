package controllers;

import com.google.gson.Gson;
import models.Tache;
import play.mvc.Controller;

import java.io.InputStreamReader;
import java.util.List;

public class ServiceWeb extends Controller {

    // Ajoute une tâche en base de données (CREATE => POST)
    // Test (curl) : curl --data "nomTache=task-from-curl" localhost:9000/api/tache
    public static void ajouterTache() {
        // A COMPLETER
        // ...
    }

    // Retourne au format JSON la liste des tâches (READ => GET)
    // Test (curl) : curl localhost:9000/api/taches.json
    public static void listTache() {
        // A COMPLETER
        // ...
    }

    // Retourne au format JSON une tâche (READ => GET)
    // Test (curl) : curl localhost:9000/api/tache/1.json
    public static void getTache(Long id) {
        // A COMPLETER
        // ...
    }

    // Modifie le titre d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/1
    public static void editTitleTache(Long id, String title) {
        // A COMPLETER
        // ...
    }

    // Change le statut d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/1
    public static void changeStatutTache(Long id) {
        // A COMPLETER
        // ...
    }

    // Supprime une tâche (DELETE => DELETE)
    // Test (curl) : curl -X DELETE localhost:9000/api/tache/1
    public static void supprimeTache(Long id) {
        // A COMPLETER
        // ...
    }
    
}
