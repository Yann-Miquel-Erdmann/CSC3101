package TP7.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Server {
    private FilmDB db;
    private Socket socket;
    private BufferedReader reader;
    private PrintStream out;

    public Server(FilmDB db, Socket socket) throws IOException {
        this.db = db;
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintStream(socket.getOutputStream());
    }

    public void handle() throws IOException {
        String line = reader.readLine();

        String location = line.split(" ")[1];
        location = location.replace("%20", " ");
        String[] tokens = location.split("/");
        System.out.println("Request " + location + " => " + tokens.length + " tokens");

        out.println("HTTP/1.1 200 OK");
        out.println("");

        try {
            if ((tokens.length != 0) && (tokens.length != 3) && (tokens.length != 2)) {
                throw new BadRequestException("Le lien n'est pas valide.");
            }

            if (tokens.length == 0) {
                out.println("<html><body>");
                out.println("<link rel=\"stylesheet\" href=\"/style.css\">");
                out.println(db.asHTML());
                out.println("</body></html>");
            }

            if (tokens.length == 3) {
                out.println("<html><body>");
                out.println("<link rel=\"stylesheet\" href=\"/style.css\">");
                Film f = new Film(tokens[1], Integer.parseInt(tokens[2]));
                Recommendations rec = db.lookup(tokens[1], Integer.parseInt(tokens[2]));
                out.println("Recommandations pour le film " + f.asHTML() + " :" + System.lineSeparator());
                out.println(rec.asHTML());
                out.println("<a href='/'>Back</a>");
                out.println("</body></html>");
            }

            if (tokens.length == 2) {
                if (tokens[1].equals("style.css")) {
                out.println("ul {  list-style: none;  padding: 0;  margin: 0; font-family: \"Inter\", sans-serif;}ul li {  padding-left: 1rem; margin: 8px 0;} a { text-decoration: none; color: #2a2a2a; font-weight: 500; } a:hover {  color: #007BFF;} ");
                }
            }

        } catch (BadRequestException e) {

            out.println(e.getMessage());

        } catch (FilmDoesNotExistsException e) {
            out.println(e.getMessage());
        }

        socket.close();
    }

}
