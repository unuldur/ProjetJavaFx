package Metier.Item;

        import Metier.Entite.Entite;
        import com.sun.javafx.geom.Point2D;
        import javafx.beans.property.StringProperty;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Item extends Entite {
    public Item(StringProperty name, Point2D position) {
        super(name, position);
    }
}
