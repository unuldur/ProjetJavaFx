package Test;

import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.CreateurItem;
import Metier.Level.Level;
import Metier.Level.LevelCanvas;
import Metier.Monstre.CreateurMonstre;
import Metier.Tile.CreateurTiles;
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
        LevelCanvas levelCanvas = new LevelCanvas(level);
        Entite ei = ci.fabriqueEntite();
        Entite em = cm.fabriqueEntite();
        Entite et = ct.fabriqueEntite();

        level.addEntite(ci.fabriqueEntite(ei),new Point2D(10,15));
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(12,15));
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(18,15));
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(10,16));

        level.addEntite(cm.fabriqueEntite(em),new Point2D(12,16));
        level.addEntite(cm.fabriqueEntite(em),new Point2D(10,16));

        level.addEntite(ct.fabriqueEntite(et),new Point2D(12,16));

        levelCanvas.draw();
    }
}
