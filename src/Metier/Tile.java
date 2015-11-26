package Metier;

import com.sun.javafx.geom.Point2D;
import javafx.beans.property.StringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Tile extends Entite {


    public enum enumTile
    {
        Sol,
        Vide,
        Mur,
        Porte
    }

    /**
     * @param type le type de la tile
     */
    private enumTile type;
    public enumTile getType() {
        return type;
    }

    public void setType(enumTile type) {
        this.type = type;
    }

    public Tile(StringProperty name, StringProperty sprite, Point2D position, enumTile type) {
        super(name, sprite, position);
        this.type = type;
    }
}
