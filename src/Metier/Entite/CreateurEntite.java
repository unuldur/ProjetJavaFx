package Metier.Entite;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;


/**
 * Created by PAYS on 21/12/2015.
 */

public class CreateurEntite {

    CreateurCategorie createurCategorie = new CreateurCategorie();
    CreateurRule createurRule = new CreateurRule();
    public Entite createurEntite(String classe,String name,String cat)
    {
        try {

            Entite e = (Entite)Class.forName(classe).newInstance();
            e.setName(name);
            e.setCategorie(createurCategorie.createurCategorie(cat));
            e.setRule(createurRule.createurRule("Metier."+e.getClass().getSimpleName()+".Rule"+e.getClass().getSimpleName()));

            return e;
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.toString());
            System.out.println(e.getClass().getSimpleName());
            return null;
        }
        catch(InstantiationException e)
        {
            System.out.println(e.toString());
            System.out.println(e.getClass().getSimpleName());
            return null;
        }
        catch (IllegalAccessException e)
        {
            System.out.println(e.toString());
            System.out.println(e.getClass().getSimpleName());
            return null;
        }
    }
    public Entite createurEntiteComplete(String classe, String name, String cat, Point2D pos) {
        Entite e = createurEntite(classe,name,cat);
        e.setSprite(new StringBuilder().append("Image/").append(name).toString());
        e.setPosition(pos);
        try{

            Image im = new Image(e.getSprite());
            e.setWidth((int)im.getWidth());
            e.setHeight((int)im.getHeight());
        }catch (Exception ex)
        {
            System.out.println(e.getSprite());
            System.out.println(ex.getMessage());
        }
        return e;
    }

}
