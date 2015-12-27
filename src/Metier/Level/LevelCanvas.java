package Metier.Level;

import Metier.Entite.Entite;
import Metier.Visiteur.Visiteur;
import Metier.Visiteur.VisiteurAffichageItem;
import Metier.Visiteur.VisiteurAffichageMonstre;
import Metier.Visiteur.VisiteurAffichageTile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PAYS on 10/12/2015.
 */
public class LevelCanvas extends Canvas{
    private Level level;
    VisiteurAffichageItem vi;
    VisiteurAffichageMonstre vm;
    VisiteurAffichageTile vt;

    private ArrayList<String> Ordre;

    public LevelCanvas(Level l,ArrayList<String> ordre)
    {
        level=l;
        vi =new VisiteurAffichageItem(getGraphicsContext2D());
        vm =new VisiteurAffichageMonstre(getGraphicsContext2D());
        vt =new VisiteurAffichageTile(getGraphicsContext2D());

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
}
