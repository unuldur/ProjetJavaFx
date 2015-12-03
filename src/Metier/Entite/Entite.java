package Metier.Entite;

import com.sun.javafx.geom.Point2D;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by PAYS on 26/11/2015.
 */
public abstract class Entite {

    /**
     * @param name nom de l'entité
     */
    private StringProperty name = new SimpleStringProperty();
    public String getName(){return name.get();}
    public void setName(String name) {this.name.set(name);}
    public StringProperty nameProperty() {return name;}


    /**
     * @param sprite chemin vers le sprite de l'entité;
     */

    /** SERA IMPLEMENTE DANS LES CLASSES VISUELLES
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

    */

    /**
     * @param position  position de l'entité
     */
    private Point2D position = new Point2D();

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Entite(StringProperty name, Point2D position) {
        this.name = name;
        //this.sprite = sprite;
        this.position = position;
    }
}
