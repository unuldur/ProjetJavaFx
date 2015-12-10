package Metier.Tile;

import Metier.Entite.Entite;
import Metier.Visiteur.Visiteur;
import javafx.geometry.Point2D;
import javafx.beans.property.StringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Tile extends Entite {



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

    public Tile(StringProperty name, Point2D position, enumTile type,StringProperty sprite) {
        super(name, position,sprite);
        this.type = type;
    }
    public Tile(Tile t)
    {
        super(t);
        this.type = t.type;
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return super.toString()+type.toString();
    }
}
