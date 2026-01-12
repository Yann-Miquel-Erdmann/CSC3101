package TP8.src;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
public class Sprite {
    private Image img;
    private double largeur;
    private double hauteur;
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;
    
    Sprite(String nom, Double largeur, Double hauteur ){
        this.img = new Image(nom, largeur, hauteur, false, false);
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public void setPosition(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void render(	GraphicsContext gc){
        gc.drawImage(img, x, y);
    }

    public void setSpeed(double xSpeed, double ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void incrementSpeed(double xSpeedIncrement,double ySpeedIncrement){
        this.xSpeed += xSpeedIncrement;
        this.ySpeed += ySpeedIncrement;
    }

    public void update(){

        if (x + xSpeed < 0){
            xSpeed = Math.abs(xSpeed);
        }
        if (y + ySpeed < 0){
            ySpeed = Math.abs(ySpeed);
        }
        if (x + largeur + xSpeed > 694) {
            xSpeed = -Math.abs(xSpeed);
        }
  
        if (y + hauteur + ySpeed > 520) {
            ySpeed = -Math.abs(ySpeed);
        }

        x += xSpeed;
        y += ySpeed;
    }

    public boolean intersects(Sprite s){
        return (this.x <= s.x  && s.x<= (this.x + this.largeur) && this.y <= s.y && s.y <= (this.y + this.hauteur)) || (this.x <= s.x + s.largeur
                && s.x + s.largeur <= (this.x + this.largeur) && this.y <= s.y + s.largeur && s.y + s.largeur <= (this.y + this.hauteur));
    }

}
