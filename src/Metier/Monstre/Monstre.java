package Metier.Monstre;

import Metier.Entite.Entite;
import javafx.geometry.Point2D;
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

    public Monstre(StringProperty name, Point2D position, Categorie categorie) {
        super(name, position);
        this.categorie = categorie;
    }

    public Monstre(Monstre m)
    {
        super(m);
        this.categorie= m.getCategorie();
    }

    @Override
    public String toString() {
        return super.toString()+categorie.toString();
    }
}
