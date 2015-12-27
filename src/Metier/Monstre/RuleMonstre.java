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
        if(TileDessous != null && TileDessous.getCategorie().getClass().getSimpleName().equals("Sol"))
            return true;
        return false;
    }
}
