package Metier.Monstre;

import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.Item;
import com.sun.javafx.geom.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class CreateurMonstre extends CreateurEntite {

    @Override
    public Entite fabriqueEntite() {
        return new Monstre(new SimpleStringProperty(), new Point2D(), Monstre.Categorie.Normal); //Par défaut, notre monstre sera un monstre normal
    }
}
