package Metier.Tile;

import Metier.Entite.Entite;
import Metier.Entite.RuleEntite;
import Metier.Level.Level;

import java.util.ArrayList;

/**
 * Created by maxime on 12/10/2015.
 */
public class RuleTile extends RuleEntite {

    @Override
    public boolean validerEntite(Entite e, Level l) {
        if(!super.validerEntite(e,l)) return false;
        if(e.getCategorie().getCategorie()=="Porte")
        {
            for (Entite ent:l.getListEntite()) {
                if (ent.getCategorie().getCategorie() == "Porte")
                    return false;
            }
        }
        return true;
    }
}