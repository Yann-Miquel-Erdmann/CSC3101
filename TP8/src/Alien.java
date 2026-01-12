package TP8.src;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import TP8.src.Sprite;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class Alien extends Application {
    private int score = 0; 
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("Alien vs Pinapples");

        Group group = new Group();
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setResizable(false);

        Random rand = new Random();

        Canvas canvas = new Canvas(694, 520);
        group.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image im = new Image("TP8/src/space.jpg", 694, 520, false, false);
        

        Sprite alien = new Sprite("TP8/src/alien.png", 62.0, 36.0);
        Sprite pinapple = new Sprite("TP8/src/pinapple.png", 19.0, 36.0);
        alien.setSpeed(1,1);
        pinapple.setSpeed(1,1);
        pinapple.setPosition(100,100);
        
        ArrayList<Sprite> pinapples = new ArrayList<Sprite>(15);
        for (int i = 0; i< 15; i++){
            Sprite s = new Sprite("TP8/src/pinapple.png", 19.0, 36.0);

            s.setPosition(rand.nextInt(694-19), rand.nextInt(520 - 36));
            s.setSpeed(rand.nextInt(11)-6, rand.nextInt(11) - 6);
            pinapples.add(s);
        }

        gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 24));
        gc.setFill(Color.BISQUE);
        gc.setStroke(Color.RED);
        gc.setLineWidth(1);
        gc.fillText("Score: 42", 540, 36);
       



        AnimationTimer at = new AnimationTimer() {
            public void handle(long t) {
                gc.drawImage(im, 0, 0);
                gc.fillText("Score: "+score, 540, 36);

                alien.update();
                alien.render(gc);
                Iterator<Sprite> pinappleIterator = pinapples.iterator();

                while (pinappleIterator.hasNext())    {            
                    Sprite s = pinappleIterator.next();
                    s.update();
                    s.render(gc);

                    if (alien.intersects(s)){
                        pinappleIterator.remove();
                        score += 100;
                    }
                    
                }
                    
                
                
            };
        };
        at.start();


        scene.setOnKeyPressed((keyEvent) -> {
            switch (keyEvent.getCode()) {
                case KeyCode.LEFT:
                    alien.incrementSpeed(-1, 0);
                    break;
                case KeyCode.RIGHT:
                    alien.incrementSpeed(1, 0);
                    break;
                case KeyCode.UP:
                    alien.incrementSpeed(0, -1);
                    break;
                case KeyCode.DOWN:
                    alien.incrementSpeed(0, 1);
                    break;
                default:
                    break;
            }
        });




        stage.show();
    }
}
