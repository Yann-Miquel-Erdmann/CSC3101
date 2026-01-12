package TP7.webserver;

import java.util.HashMap;
import java.util.Map;

public class FilmDB {
    private Map<Film, Recommendations> db;

    public FilmDB() {
        db = new HashMap<Film, Recommendations>();
    }

    public void create(String title, int year) throws FilmAlreadyExistsException {
        Film f = new Film(title, year);
        if (db.containsKey(f)) {
            throw new FilmAlreadyExistsException("Le film " + f + " existe déjà dans la base de données.");
        }

        db.put(f, new Recommendations());
    }

    @Override
    public String toString() {
        String res = "";
        for (Film f: db.keySet()){
            res += f + System.lineSeparator();
        }
        return res;
    }


    public Recommendations lookup(String title, int year) throws FilmDoesNotExistsException {
        Film f = new Film(title, year);
        if ( ! db.containsKey(f)){
            throw new FilmDoesNotExistsException("Le film " + f + " n'existe pas dans la base de données.");
        }
        return db.get(f);
    }

    public String asHTML(){
        String res = "Liste des films :" +  System.lineSeparator() + "<ul>";
        for (Film f : db.keySet()) {
            res += "<li>" + f.asHTML() + "</li>" + System.lineSeparator();
        }
        return res + "</ul>";
    }
}
