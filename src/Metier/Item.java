package Metier;

import com.sun.javafx.geom.Point2D;
import javafx.beans.property.StringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Item extends Entite {
    public Item(StringProperty name, StringProperty sprite, Point2D position) {
        super(name, sprite, position);
    }
}
