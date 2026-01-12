package TP7.webserver;

public class BadRequestException extends Exception{
    public BadRequestException(String description){
        super(description);
    }
}
