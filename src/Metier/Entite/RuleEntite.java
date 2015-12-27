package Metier.Entite;

import Metier.Level.Level;

import java.util.ArrayList;

/**
 * Created by maxime on 12/10/2015.
 */
public abstract class RuleEntite {

    public boolean validerEntite(Entite e, Level l)
    {
        ArrayList<Entite> listEntite = l.getListEntite();
        for(Entite el : listEntite) {
            if (el.getClass() == e.getClass()) {
                if ((e.getPosition().getX() < el.getPosition().getX() + el.getWidth())
                        && (e.getPosition().getX() + e.getWidth() > el.getPosition().getX())
                        && (e.getPosition().getY() < el.getPosition().getY() + el.getHeight())
                        && (e.getPosition().getY() + e.getHeight() > el.getPosition().getY())
                        ) {
                            return false;
                        }
            }
        }
        return true;
    }

}
