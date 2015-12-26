package Metier.Entite;

import Metier.Monstre.Categorie;

/**
 * Created by PAYS on 21/12/2015.
 */
public class CreateurCategorie {
    public CategorieEntite createurCategorie(String classe)
    {
        try {

            CategorieEntite cat = (CategorieEntite) Class.forName(classe).newInstance();
            return cat;
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.toString());
            return null;
        }
        catch(InstantiationException e)
        {
            System.out.println(e.toString());
            return null;
        }
        catch (IllegalAccessException e)
        {
            System.out.println(e.toString());
            return null;
        }
    }
}
