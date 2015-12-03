package Metier.Tile;

import com.sun.javafx.geom.Point2D;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by maxime on 12/03/2015.
 */
public class TileVisuel extends Tile {

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

    public TileVisuel(StringProperty name, Point2D position, enumTile type, StringProperty sprite) {
        super(name, position, type);
        this.sprite=sprite;
    }
}
