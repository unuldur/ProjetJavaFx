package Metier.Entite;

import Metier.Item.Item;
import javafx.geometry.Point2D;

/**
 * Created by PAYS on 26/11/2015.
 */
public abstract class CreateurEntite {

    public Entite CreateurEntite(){
        Entite entite=this.fabriqueEntite();
        return entite;
    }

    public abstract Entite fabriqueEntite();
    public abstract Entite fabriqueEntite(Entite e);
    public abstract Entite fabriqueEntite(String nom, CategorieEntite categorie, Point2D pos);
}
