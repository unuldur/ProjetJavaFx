package Metier.Entite;

import Metier.Tile.Sol;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;


/**
 * Created by PAYS on 21/12/2015.
 */

public class CreateurEntite2 {

    CreateurCategorie createurCategorie = new CreateurCategorie();
    public Entite createurEntite(String classe,String name,String cat)
    {
        try {

            Entite e = (Entite)Class.forName(classe).newInstance();
            e.setName(name);
            e.setCategorie(createurCategorie.createurCategorie(cat));
            return e;
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
    public Entite createurEntiteComplete(String classe, String name, String cat, Point2D pos) {
        Entite e = createurEntite(classe,name,cat);
        e.setSprite(new StringBuilder().append("Image/").append(name).append(".png").toString());
        e.setPosition(pos);
        Image im = new Image(e.getSprite());
        e.setWidth((int)im.getWidth());
        e.setHeight((int)im.getHeight());
        return e;
    }
}
