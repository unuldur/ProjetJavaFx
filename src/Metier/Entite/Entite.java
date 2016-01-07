package Metier.Entite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * Created by PAYS on 26/11/2015.
 */
public abstract class Entite implements Serializable{

    private RuleEntite rule;

    public RuleEntite getRule() {
        return rule;
    }

    public void setRule(RuleEntite rule) {
        this.rule = rule;
    }

    /**
     * @param name nom de l'entité
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param sprite chemin vers le sprite de l'entité;
     */

    private String sprite;

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
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
    private int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height taille y de l'Entite
     */

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    @Override
    public String toString() {
        return getClass().toString()+" "+getPosition().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) return false;
        Entite e = (Entite)obj;
        if(!e.getCategorie().equals(getCategorie())) return false;
        if(!e.getPosition().equals(getPosition())) return false;
        return e.getName().equals(getName());

    }
}
