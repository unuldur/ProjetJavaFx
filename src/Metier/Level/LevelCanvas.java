package Metier.Level;

import Metier.Entite.Entite;
import Metier.Observateur.Observateur;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PAYS on 10/12/2015.
 */
public class LevelCanvas extends Canvas implements Observateur{
    private Level level;

    private ArrayList<String> Ordre;

    public LevelCanvas(Level l,ArrayList<String> ordre)
    {
        level=l;

        Ordre = ordre;
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    public void draw()
    {
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,getWidth(),getHeight());
         for (String classe: Ordre) {

            for (Entite e:level.getListEntite()) {
                if(e.getClass().getSimpleName().equals(classe))
                {
                    gc.drawImage(new Image(e.getSprite()),e.getPosition().getX(),e.getPosition().getY());
                }
            }
        }

    }

    @Override
    public void update() {
        draw();
    }
}
