package Metier.Entite;

import java.io.Serializable;

/**
 * Created by PAYS on 17/12/2015.
 */
public abstract class CategorieEntite implements Serializable{
    public abstract String getCategorie();

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != getClass()) return false;
        return true;
    }
}
