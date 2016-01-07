package Metier.Monstre;

import Metier.Entite.Entite;
import Metier.Entite.RuleEntite;
import Metier.Level.Level;

import java.util.ArrayList;

/**
 * Created by maxime on 12/10/2015.
 */
public class RuleMonstre extends RuleEntite {

    @Override
    public boolean validerEntite(Entite e, Level l) {
        if(!super.validerEntite(e,l)) return false;
        Entite TileDessous;
        if( !super.validerEntite(e,l)) return false;
        TileDessous = l.findEntite(e.getPosition(),"Tile");
        if(TileDessous != null && TileDessous.getCategorie().getClass().getSimpleName().equals("Sol")) {
            if(e.getCategorie().getCategorie() == "Boss")
            {
                for (Entite ent:l.getListEntite()) {
                    if (ent.getCategorie().getCategorie() == "Boss")
                        return false;
                }
            }
            return true;
        }
        return false;
    }
}
