package Metier.Tile;

import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Tile.enumTile;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class CreateurTiles extends CreateurEntite {

    @Override
    public Entite fabriqueEntite() {
        return new Tile(new SimpleStringProperty(), new Point2D(0,0), enumTile.Sol); //par défaut, la tile sera un sol
    }

    @Override
    public Entite fabriqueEntite(Entite e) {
        return new Tile((Tile)e);
    }
}
