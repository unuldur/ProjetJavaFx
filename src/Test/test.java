package Test;

import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.CreateurItem;
import Metier.Item.Item;
import Metier.Level.Level;
import Metier.Level.LevelCanvas;
import Metier.Monstre.CreateurMonstre;
import Metier.Monstre.Monstre;
import Metier.Tile.CreateurTiles;
import Metier.Tile.Tile;
import javafx.geometry.Point2D;

/**
 * Created by maxime on 12/03/2015.
 */

public class test {

    public static void main(String args[]) {
        CreateurEntite ci = new CreateurItem();
        CreateurEntite cm = new CreateurMonstre();
        CreateurEntite ct = new CreateurTiles();
        Level level = new Level();
        //LevelCanvas levelCanvas = new LevelCanvas(level);
        Entite ei = ci.fabriqueEntite();
        Entite em = cm.fabriqueEntite();
        Entite et = ct.fabriqueEntite();

        level.addEntite(ci.fabriqueEntite(ei),new Point2D(0,20));
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(0,0));
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(0,20)); //fera une erreur
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(35,15));

        level.addEntite(cm.fabriqueEntite(em),new Point2D(0,20));
        level.addEntite(cm.fabriqueEntite(em),new Point2D(0,20)); //erreur
        level.addEntite(cm.fabriqueEntite(em),new Point2D(40,60));

        level.addEntite(ct.fabriqueEntite(et),new Point2D(45,0));

        System.out.println(level.toString());

        //levelCanvas.draw();
    }
}
