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
        int i=0;
        //int j=0; //var pour debug
        ArrayList<Entite> listEntite = l.getListEntite();
        for(Entite el : listEntite) {
            if (el.getClass().getName() == "Metier.Monstre.Monstre") {
                if(el.getPosition().getX()==e.getPosition().getX() && el.getPosition().getY() == e.getPosition().getY()) {
                    i++;
                }
                //System.out.println(el.getClass().toString()+" "+el.getPosition().toString() + " " +j+ " " +i+" "+el.getPosition().toString() + " " +e.getPosition().toString()); //debugging
            }
            //j++; //var pour debug
        }
        if(i==0)
            return true;
        return false;
    }
}
