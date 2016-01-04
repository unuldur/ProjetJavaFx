package Test;

import Metier.Entite.CreateurEntite;
import Metier.Entite.CreateurEntite2;
import Metier.Entite.Entite;
import Metier.Item.CreateurItem;
import Metier.Item.Item;
import Metier.Level.Level;
import Metier.Level.LevelCanvas;
import Metier.ModulesLoader;
import Metier.Monstre.CreateurMonstre;
import Metier.Monstre.Monstre;
import Metier.Tile.CreateurTiles;
import Metier.Tile.Sol;
import Metier.Tile.Tile;
import javafx.geometry.Point2D;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by maxime on 12/03/2015.
 */

public class test {

    public static void main(String args[]) {
        try {
            ModulesLoader.addModulesPackage("Metier");
            Collection<Class> list = ModulesLoader.getPlugins(Entite.class);
            for (Class t:list
                 ) {
                System.out.println(t.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //levelCanvas.draw();
    }
}
