package TP7.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws FilmAlreadyExistsException, FilmDoesNotExistsException, IOException {
        Recommendations recs = new Recommendations();

        recs.addRecommendation("rec1");
        recs.addRecommendation("rec2");
        recs.addRecommendation("rec3");

        System.out.println(recs);

        Film BlackSheep2008 = new Film("Black Sheep", 2008);
        Film EvilDead1981 = new Film("Evil Dead", 1981);
        Film EvilDead2013 = new Film("Evil Dead", 2013);

        System.out.println(BlackSheep2008.equals(BlackSheep2008));
        System.out.println(BlackSheep2008.equals(EvilDead1981));
        System.out.println(EvilDead2013.equals(EvilDead1981));
        System.out.println(BlackSheep2008.equals("Black Sheep"));

        System.out.println(System.lineSeparator());

        System.out.println(BlackSheep2008.hashCode());
        System.out.println(EvilDead1981.hashCode());
        System.out.println(EvilDead2013.hashCode());
        System.out.println(System.lineSeparator());

        FilmDB db = new FilmDB();

        db.create("Evil Dead", 1981);
        db.create("Evil Dead", 2013);
        db.create("Fanfan la Tulipe", 1952);
        db.create("Fanfan la Tulipe", 2003);
        db.create("Mary a tout prix", 1998);
        db.create("Black Sheep", 2008);
        // db.create("Black Sheep", 2008);

        db.lookup("Black Sheep", 2008);
        // db.lookup("Star Wars", 1977);

        db.lookup("Evil Dead", 1981).addRecommendation("Ouh ! Mais ca fait peur !");
        db.lookup("Evil Dead", 2013).addRecommendation("Meme pas peur !");
        db.lookup("Evil Dead", 2013).addRecommendation("Insipide et sans saveur");
        db.lookup("Fanfan la Tulipe", 1952).addRecommendation("Manque de couleurs");
        db.lookup("Fanfan la Tulipe", 1952).addRecommendation("Supers scenes de combat");
        db.lookup("Fanfan la Tulipe", 2003).addRecommendation("Mais pourquoi ???");
        db.lookup("Mary a tout prix", 1998).addRecommendation("Le meilleur film de tous les temps");
        db.lookup("Black Sheep", 2008).addRecommendation("Un scenario de genie");
        db.lookup("Black Sheep", 2008).addRecommendation("Une realisation parfaite");
        db.lookup("Black Sheep", 2008).addRecommendation("A quand Black Goat ?");

        ServerSocket serverSocket = new ServerSocket(4123);
        while (true) {

            try {
                Socket com = serverSocket.accept();
                Server s = new Server(db, com);
                s.handle();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
        }
    }
}
