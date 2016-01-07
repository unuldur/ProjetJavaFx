package Metier.Entite;

import java.util.ArrayList;

/**
 * Created by PAYS on 21/12/2015.
 */
public class CreateurCategorie {

    ArrayList<CategorieEntite> listCategorie = new ArrayList<>();

    public CategorieEntite createurCategorie(String classe)
    {
        try {

            CategorieEntite categorie = (CategorieEntite) Class.forName(classe).newInstance();
            if(!listCategorie.contains(categorie))
            {
                listCategorie.add(categorie);
            }
            else
            {
                categorie = listCategorie.get(listCategorie.indexOf(categorie));
            }
            return categorie;
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
