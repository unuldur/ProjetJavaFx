package Metier.Observateur;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by PAYS on 29/12/2015.
 */
public class Sujet {
    private LinkedList<Observateur> obs = new LinkedList<>();

    public void ajouterObservateur(Observateur observateur)
    {
        obs.add(observateur);
    }

    public void supprimerObservateur(Observateur observateur)
    {
        obs.remove(observateur);
    }

    public void notifier()
    {
        Iterator<Observateur> it = obs.iterator();
        // Notifier tous les observers
        while(it.hasNext()){
            Observateur obs = it.next();
            obs.update();
        }
    }


}
