package Metier.Monstre;

import Metier.Entite.CategorieEntite;
import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.Item;
import Metier.Monstre.Categorie;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class CreateurMonstre extends CreateurEntite {

    @Override
    public Entite fabriqueEntite() {
        return new Monstre("", new Point2D(0,0), "",new Normal()); //Par défaut, notre monstre sera un monstre normal
    }

    @Override
    public Entite fabriqueEntite(Entite e) {
        return new Monstre((Monstre)e);
    }

    @Override
    public Entite fabriqueEntite(String nom, CategorieEntite categorie, Point2D pos) {
        String nomSansExtension = nom.substring(0, nom.lastIndexOf("."));
        return new Monstre(nomSansExtension, pos, new StringBuilder().append("Image/").append(nom).toString(), categorie);
    }
}
