package Metier.Monstre;

import Metier.Entite.CategorieEntite;
import Metier.Entite.Entite;
import javafx.geometry.Point2D;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Monstre extends Entite {

    public Monstre(String name, Point2D position,String sprite,CategorieEntite m) {
        super(name, position,sprite,m);
    }

    public Monstre(Monstre m)
    {
        super(m);
    }

    public Monstre(){super();}

    @Override
    public String toString() {
        return super.toString()+getCategorie().getCategorie();
    }
}
