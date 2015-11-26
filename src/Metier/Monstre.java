package Metier;

import com.sun.javafx.geom.Point2D;
import javafx.beans.property.StringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Monstre extends Entite {

    public enum Categorie
    {
        Normal,
        Boss // Un seul par niveau
    }

    private Categorie categorie;
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Monstre(StringProperty name, StringProperty sprite, Point2D position, Categorie categorie) {
        super(name, sprite, position);
        this.categorie = categorie;
    }
}
