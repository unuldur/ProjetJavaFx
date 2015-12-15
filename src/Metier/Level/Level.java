package Metier.Level;

import Metier.Entite.RuleEntite;
import Metier.Item.RuleItem;
import Metier.Monstre.RuleMonstre;
import Metier.Tile.RuleTile;
import Metier.Type;
import Metier.Entite.Entite;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PAYS on 03/12/2015.
 */

public class Level {
    ArrayList<Entite> listEntite = new ArrayList<>();

    public void addEntite(Entite e, Point2D p)
    {
        if(isOk(e)) {
            e.setPosition(p);
            listEntite.add(e);
        }
        else System.out.println("Erreur à l'ajout. Vérifiez les arguments de votre entité.");
    }

    public void delEntite(Entite e)
    {
        if(!listEntite.remove(e))
            System.err.println("Erreur lors de la suppression : entité absente du niveau. Veuillez revérifier vos arguments.");
    }

    public boolean isOk(Entite e) { //isOk va servir à appeler isOkRule, après avoir déterminer quel regle utiliser
        String s = e.getClass().getName();
        switch (s)
        {
            case "Metier.Monstre.Monstre":
                return isOkRule(new RuleMonstre(e));
            case "Metier.Item.Item":
                return isOkRule(new RuleItem(e));
            case "Metier.Tile.Tile":
                return isOkRule(new RuleTile(e));
        }
        return false;
    }


    private boolean isOkRule(RuleEntite re) //Monstre, Item et Level auront chacun une regle
    {
        return true; //A modifier, ajouter les rules dans RuleMonstre/Item/Tile et faire les vérifs.
    }

    public ArrayList<Entite> getListEntite()
    {
        return listEntite;
        /*
        ArrayList<Entite> entites = new ArrayList<>();
        switch (t)
        {
            case Item:
                for (Entite entite:listEntite) {
                    if(entite.getClass().getName() == "Metier.Item.Item")
                        entites.add(entite);
                }
                break;
            case Monstre:
                for (Entite entite:listEntite) {
                    if(entite.getClass().getName() == "Metier.Monstre.Monstre")
                        entites.add(entite);
                }
                break;
            case Tile:
                for (Entite entite:listEntite) {
                    if(entite.getClass().getName() == "Metier.Tile.Tile")
                        entites.add(entite);
                }
                break;
        }
        return entites;
        */
    }
}
