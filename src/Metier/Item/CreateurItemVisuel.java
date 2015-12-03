package Metier.Item;

import Metier.Entite.Entite;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by PAYS on 03/12/2015.
 */
public class CreateurItemVisuel extends CreateurItem{
    @Override
    public Entite fabriqueEntite() {
        return new ItemVisuel(new SimpleStringProperty(),new Point2D(0,0),new SimpleStringProperty());
    }
}
