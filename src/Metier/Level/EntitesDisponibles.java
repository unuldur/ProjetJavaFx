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

    public ArrayList<Entite> getEntites()
    {
        return this.liste;
    }

    public void addEntite(Entite entite)
    {
        this.liste.add(entite);
        notifier();
    }

    public void modEntite(String nomVielleEntite,Entite nouvelle)
    {
        Entite aModifier = null;
        for (Entite e:liste) {
            if(e.getName().equals(nomVielleEntite))
            {
                aModifier = e;
            }
        }
        if(aModifier != null){
            delEntite(aModifier);
            addEntite(nouvelle);
        }
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
