package Metier.Tile;

import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.Item;
import com.sun.javafx.geom.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class CreateurTiles extends CreateurEntite {

    @Override
    public Entite fabriqueEntite() {
        return new Tile(new SimpleStringProperty(), new Point2D(), Tile.enumTile.Sol); //par défaut, la tile sera un sol
    }
}
