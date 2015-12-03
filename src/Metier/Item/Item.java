package Metier.Item;

        import Metier.Entite.Entite;
        import javafx.beans.property.StringProperty;
        import javafx.geometry.Point2D;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Item extends Entite {
    public Item(StringProperty name, Point2D position) {
        super(name, position);
    }
    public Item(Item m){super(m);}

    @Override
    public String toString() {
        return super.toString();
    }
}
