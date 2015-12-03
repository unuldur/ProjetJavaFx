package Metier.Entite;

import Metier.Item.Item;

/**
 * Created by PAYS on 26/11/2015.
 */
public abstract class CreateurEntite {

    public Entite CreateurEntite(){
        Entite entite=this.fabriqueEntite();
        return entite;
    }

    public abstract Entite fabriqueEntite();

}
