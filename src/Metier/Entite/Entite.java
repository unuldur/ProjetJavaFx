package Metier.Entite;

import Metier.Visiteur.Visiteur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

    public void setPosition(Point2D position) {
        this.position=position;
    }


    /**
     * @param width taille x de l'Entite
     */
    private IntegerProperty width = new SimpleIntegerProperty();

    public int getWidth() {
        return width.get();
    }

    public IntegerProperty widthProperty() {
        return width;
    }

    public void setWidth(int width) {
        this.width.set(width);
    }

    /**
     * @param height taille y de l'Entite
     */

    private IntegerProperty height = new SimpleIntegerProperty();

    public int getHeight() {
        return height.get();
    }

    public IntegerProperty heightProperty() {
        return height;
    }

    public void setHeight(int height) {
        this.height.set(height);
    }

    /**
     * @param categorie la categorie de l'entite
     */
    private CategorieEntite categorie;

    public CategorieEntite getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEntite categorie) {
        this.categorie = categorie;
    }



    public Entite(String name, Point2D position,String sprite,CategorieEntite cat) {
        setName(name);
        setSprite(sprite);
        this.position = position;
        this.categorie = cat;
    }

    public Entite(Entite e) {
        this.name = e.name;
        this.position = e.position;
        this.sprite = e.sprite;
        this.categorie = e.getCategorie();
    }

    public Entite(){}
    public abstract void accept(Visiteur v);

    @Override
    public String toString() {
        return getClass().toString()+" "+getPosition().toString();
    }
}
