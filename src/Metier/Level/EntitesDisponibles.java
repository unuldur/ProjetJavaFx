package Metier.Level;

import Metier.Entite.Entite;
import Metier.Observateur.Sujet;
import java.util.ArrayList;


public class EntitesDisponibles extends Sujet{
    
    private ArrayList<Entite> liste;
    
    public EntitesDisponibles()
    {
        this.liste = new ArrayList<>();
    }
    
    public EntitesDisponibles(ArrayList<Entite> liste)
    {
        this.liste = liste;
    }
    public ArrayList<Entite> getEntites()
    {
        return this.liste;
    }

    public void addEntite(Entite entite)
    {
        this.liste.add(entite);
        notifier();
    }

    public boolean findEntite(Entite e)
    {
        return liste.contains(e);
    }

    public void delEntite(Entite entite) {
        liste.remove(entite);
        notifier();
    }

    public void setListe(ArrayList<Entite> liste) {
        this.liste = liste;
        notifier();
    }
}
