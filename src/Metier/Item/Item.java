package Metier.Item;

        import Metier.Entite.Entite;
        import Metier.Visiteur.Visiteur;
        import javafx.beans.property.StringProperty;
        import javafx.geometry.Point2D;

/**
 * Created by PAYS on 26/11/2015.
 */
public class Item extends Entite {
    public Item(StringProperty name, Point2D position,StringProperty sprite) {
        super(name, position,sprite);
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }

    public Item(Item m){super(m);}

    @Override
    public String toString() {
        return super.toString();
    }
}
