package Metier;

import Metier.Entite.Entite;

/**
 * Created by PAYS on 27/12/2015.
 */
public class  Collisions {
    public static boolean deuxEntite(Entite e1,Entite e2){
        if ((e1.getPosition().getX() < e2.getPosition().getX() + e2.getWidth())
                && (e1.getPosition().getX() + e1.getWidth() > e2.getPosition().getX())
                && (e1.getPosition().getY() < e2.getPosition().getY() + e2.getHeight())
                && (e1.getPosition().getY() + e1.getHeight() > e2.getPosition().getY())
                ) {
            return true;
        }
        return false;
    }
}
