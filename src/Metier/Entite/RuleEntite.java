package Metier.Entite;

import Metier.Collisions;
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
                if (Collisions.deuxEntite(e,el)) {
                            return false;
                        }
            }
        }
        return true;
    }

}
