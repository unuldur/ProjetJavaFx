package Metier.Level;

import Metier.Collisions;
import Metier.Entite.RuleEntite;
import Metier.Item.RuleItem;
import Metier.Monstre.Categorie;
import Metier.Monstre.Monstre;
import Metier.Monstre.RuleMonstre;
import Metier.Observateur.Sujet;
import Metier.Tile.RuleTile;
import Metier.Type;
import Metier.Entite.Entite;
import Metier.Visiteur.Visiteur;
import javafx.geometry.Point2D;
import sun.security.ssl.SunJSSE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PAYS on 03/12/2015.
 */

public class Level extends Sujet {
    ArrayList<Entite> listEntite = new ArrayList<>();

    public void addEntite(Entite e, Point2D p)
    {
        e.setPosition(p); //???????
        if(isOk(e)) {
            e.setPosition(p);
            listEntite.add(e);
            notifier();
        }
        else System.out.println("Erreur à l'ajout. Vérifiez les arguments de votre entité.");
    }

    public void delEntite(Entite e)
    {
        if(!listEntite.remove(e))
            System.err.println("Erreur lors de la suppression : entité absente du niveau. Veuillez revérifier vos arguments.");
        notifier();
    }

    public void delEntiteByPos(Point2D pos)
    {
        Entite entite = new Monstre();
        for (Entite e:listEntite) {
            if(Collisions.pointEntite((int)pos.getX(),(int)pos.getY(),e))
                entite = e;
        }
        listEntite.remove(entite);
        notifier();
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
       String s = e.getClass().getName();
        switch (s)
        {
            case "Metier.Monstre.Monstre":
                return isOkRule(new RuleMonstre(), e);
            case "Metier.Item.Item":
                return isOkRule(new RuleItem(), e);
            case "Metier.Tile.Tile":
                return isOkRule(new RuleTile(), e);
        }
        return false;
    }


    private boolean isOkRule(RuleEntite re, Entite e) //Monstre, Item et Level auront chacun une regle
    {
        if(re.validerEntite(e, this))
            return true;
        else return false;
    }

    public ArrayList<Entite> getListEntite()
    {
        return listEntite;
    }

    @Override
    public String toString() {
        String str="Détail du niveau : \n";
        for(Entite e : listEntite)
            if(e.getCategorie() != null)
            str+="Nom : "+e.getName()+" --- Type : "+e.getClass().getName()+" --- Position x : "+e.getPosition().getX()+" --- Position y : "+e.getPosition().getY()+"  --Categorie : "+e.getCategorie().getCategorie()+"\n";
        return str;
    }
}
