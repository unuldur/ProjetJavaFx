package Metier.Entite;

import Metier.Visiteur.Visiteur;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

    /**
     * @param position  position de l'entité
     */
    private Point2D position = new Point2D(0,0);

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) { //avoir une image tous les 20pixel, BUG : toutes les positions sont à 0,0 TODO
        /*
        double x, y;
        int i;

        x=(position.getX()+1)/20;
        i=(int) x;
        x=i*20;

        y=(position.getY()+1)/20;
        i=(int) y;
        y=i*20;
        */
        this.position=position;
    }

    public Entite(StringProperty name, Point2D position,StringProperty sprite) {
        this.name = name;
        this.sprite = sprite;
        this.position = position;
    }

    public Entite(Entite e) {
        this.name = e.name;
        this.position = e.position;
        this.sprite = e.sprite;
    }

    public abstract void accept(Visiteur v);

    @Override
    public String toString() {
        return getClass().toString()+" "+getPosition().toString();
    }
}
