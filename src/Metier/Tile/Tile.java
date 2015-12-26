package Metier.Tile;

import Metier.Entite.CategorieEntite;
import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.CreateurItem;
import Metier.Visiteur.Visiteur;
import javafx.geometry.Point2D;
import javafx.beans.property.StringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Tile extends Entite {

    public Tile(){super();}
    public Tile(String name, Point2D position,String sprite,CategorieEntite t) {
        super(name, position,sprite,t);
    }

    public Tile(Tile t)
    {
        super(t);
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }

    @Override
    public void setPosition(Point2D position)
    {
        Point2D posFinal = new Point2D((int)(position.getX()/20) * 20,(int)(position.getY()/20) *20);
        super.setPosition(posFinal);
    }

    @Override
    public String toString() {
        return super.toString()+getCategorie();
    }
}
