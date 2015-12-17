package Metier.Item;

import Metier.Entite.Entite;
import Metier.Entite.RuleEntite;
import Metier.Level.Level;

import java.util.ArrayList;

/**
 * Created by maxime on 12/10/2015.
 */
public class RuleItem extends RuleEntite {

    @Override
    public boolean validerEntite(Entite e, Level l) {
        ArrayList<Entite> listEntite = l.getListEntite();
        int i=0;
        for(Entite el : listEntite) {
            if (el.getClass().getName() == "Metier.Item.Item") {
                if(el.getPosition().getX()==e.getPosition().getX() && el.getPosition().getY() == e.getPosition().getY()) {
                    i++;
                }
            }
        }
        if(i==0)
            return true;
        return false;
    }

}