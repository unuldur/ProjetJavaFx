package Metier.Item;

import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by maxime on 12/03/2015.
 */
public class ItemVisuel extends Item {

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

    public ItemVisuel(StringProperty name, Point2D position, StringProperty sprite) {
        super(name, position);
        this.sprite=sprite;
    }
}
