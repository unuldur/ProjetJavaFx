package Metier.Entite;

/**
 * Created by PAYS on 17/12/2015.
 */
public abstract class CategorieEntite {
    public abstract String getCategorie();

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != getClass()) return false;
        return true;
    }
}
