package Metier.Level;

import Metier.Entite.Entite;
import Metier.Type;
import java.util.ArrayList;


public class EntitesDisponibles {
    
    private ArrayList<Entite> liste;
    
    public EntitesDisponibles()
    {
        this.liste = new ArrayList<>();
    }
    
    public EntitesDisponibles(ArrayList<Entite> liste)
    {
        this.liste = liste;
    }
    
    public void addEntite(Entite entite)
    {
        this.liste.add(entite);
    }
    
    public ArrayList<Entite> getEntites()
    {
        return this.liste;
    }
    
    public ArrayList<Entite> getEntites(Type type)
    {        
        ArrayList<Entite> retour = new ArrayList<>();
        for(Entite e : liste)
        {
            if(e.getClass().toString().endsWith("."+type.toString()))
            {
                retour.add(e);
            }
        }
        
        return retour;
    }
}
