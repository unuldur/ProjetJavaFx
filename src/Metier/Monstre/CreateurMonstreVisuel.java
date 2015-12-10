package Metier.Monstre;

import Metier.Entite.Entite;
import Metier.Monstre.Categorie;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 03/12/2015.
 */
public class CreateurMonstreVisuel extends CreateurMonstre {
    @Override
    public Entite fabriqueEntite() {
        return new MonstreVisuel(new SimpleStringProperty(),new Point2D(0,0), Categorie.Normal,new SimpleStringProperty());
    }
}
