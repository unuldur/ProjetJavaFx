package Metier;

import Metier.Entite.Entite;

/**
 * Created by PAYS on 27/12/2015.
 */
public class  Collisions {
    public static boolean deuxEntite(Entite e1,Entite e2){
        return (e1.getPosition().getX() < e2.getPosition().getX() + e2.getWidth())
                && (e1.getPosition().getX() + e1.getWidth() > e2.getPosition().getX())
                && (e1.getPosition().getY() < e2.getPosition().getY() + e2.getHeight())
                && (e1.getPosition().getY() + e1.getHeight() > e2.getPosition().getY());
    }

    public static boolean pointEntite(int curseur_x,int curseur_y,Entite e)
    {
        return curseur_x >= e.getPosition().getX()
                && curseur_x < e.getPosition().getX() + e.getWidth()
                && curseur_y >= e.getPosition().getY()
                && curseur_y < e.getPosition().getY() + e.getHeight();
    }
}
