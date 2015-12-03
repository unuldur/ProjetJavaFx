package Metier.Tile;

import Metier.Entite.Entite;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 03/12/2015.
 */
public class CreateurTileVisuel extends CreateurTiles{

    @Override
    public Entite fabriqueEntite() {
        return new TileVisuel(new SimpleStringProperty(), new Point2D(0,0), Tile.enumTile.Sol,new SimpleStringProperty());
    }
}
