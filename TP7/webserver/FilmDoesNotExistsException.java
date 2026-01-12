package TP7.webserver;

public class FilmDoesNotExistsException extends Exception{
    public FilmDoesNotExistsException(String description){
        super(description);
    }
}
