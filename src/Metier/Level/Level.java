package Metier.Level;

import Metier.Collisions;
import Metier.Entite.RuleEntite;
import Metier.Item.RuleItem;
import Metier.Monstre.Monstre;
import Metier.Monstre.RuleMonstre;
import Metier.Observateur.Sujet;
import Metier.Tile.RuleTile;
import Metier.Entite.Entite;
import javafx.geometry.Point2D;

import java.util.ArrayList;

/**
 * Created by PAYS on 03/12/2015.
 */

public class Level extends Sujet {
    ArrayList<Entite> listEntite = new ArrayList<>();



    public void addEntite(Entite e)
    {
        if(isOk(e)) {
            listEntite.add(e);
            notifier();
        }
    }

    public void delEntite(Entite e)
    {
        if(!listEntite.remove(e))
            System.err.println("Erreur lors de la suppression : entité absente du niveau. Veuillez revérifier vos arguments.");
        notifier();
    }

    public Entite getEntiteByPos(Point2D pos)
    {
        Entite entite = null;
        for (Entite e:listEntite) {
            if(Collisions.pointEntite((int)pos.getX(),(int)pos.getY(),e))
                entite = e;
        }
        return entite;
    }

    public void delAll()
    {
        listEntite.clear();
        notifier();
    }

    public void setListEntite(ArrayList<Entite> listEntite) {
        this.listEntite = listEntite;
        notifier();
    }

    public Entite findEntite(Point2D pos, String classe)
    {
        for (Entite e:listEntite) {
            if(e.getClass().getSimpleName().equals(classe) && Collisions.pointEntite((int)pos.getX(),(int)pos.getY(),e))
                return e;
        }
        return null;
    }

    public boolean isOk(Entite e) { //isOk va servir à appeler isOkRule, après avoir déterminer quel regle utiliser
       return isOkRule(e.getRule(),e);
    }


    private boolean isOkRule(RuleEntite re, Entite e) //Monstre, Item et Level auront chacun une regle
    {
        return re.validerEntite(e, this);
    }

    public ArrayList<Entite> getListEntite()
    {
        return listEntite;
    }


}
