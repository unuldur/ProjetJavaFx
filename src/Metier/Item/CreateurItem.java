package Metier.Item;

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
        return new Item(new SimpleStringProperty(), new Point2D(0,0),new SimpleStringProperty());
    }

    @Override
    public Entite fabriqueEntite(Entite e) {
        return new Item((Item)e);
    }
}
