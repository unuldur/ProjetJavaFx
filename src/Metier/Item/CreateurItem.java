package Metier.Item;

import Metier.Entite.CategorieEntite;
import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class CreateurItem extends CreateurEntite {

    @Override
    public Entite fabriqueEntite() {
        return new Item("", new Point2D(0, 0), "", null);
    }

    @Override
    public Entite fabriqueEntite(Entite e) {
        return new Item((Item)e);
    }

    @Override
    public Entite fabriqueEntite(String nom, CategorieEntite categorie, Point2D pos) {
        String nomSansExtension = nom.substring(0, nom.lastIndexOf("."));
        return new Item(nomSansExtension, pos, new StringBuilder().append("Image/").append(nom).toString(), categorie);
    }
}
