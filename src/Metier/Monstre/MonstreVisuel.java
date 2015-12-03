package Metier.Monstre;

import com.sun.javafx.geom.Point2D;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by maxime on 12/03/2015.
 */
public class MonstreVisuel extends Monstre {

    private StringProperty sprite = new SimpleStringProperty();

    public void setSprite(String sprite) {
        this.sprite.set(sprite);
    }

    public String getSprite() {
        return sprite.get();
    }

    public StringProperty spriteProperty() {
        return sprite;
    }

    public MonstreVisuel(StringProperty name, Point2D position, Categorie categorie, StringProperty sprite) {
        super(name, position, categorie);
        this.sprite=sprite;
    }
}
