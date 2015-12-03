package Metier.Level;

import Metier.Type;
import Metier.Entite.Entite;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PAYS on 03/12/2015.
 */
public class Level {
    ArrayList<Entite> listEntite = new ArrayList<>();

    public void addEntite(Entite e, Point2D p)
    {
        e.setPosition(p);
        listEntite.add(e);
    }

    public ArrayList<Entite> getListEntiteSpe(Type t)
    {
        ArrayList<Entite> entites = new ArrayList<>();
        switch (t)
        {
            case Item:
                for (Entite entite:listEntite) {
                    if(entite.getClass().getName() == "Metier.Item.Item")
                        entites.add(entite);
                }
                break;
            case Monstre:
                for (Entite entite:listEntite) {
                    if(entite.getClass().getName() == "Metier.Monstre.Monstre")
                        entites.add(entite);
                }
                break;
            case Tile:
                for (Entite entite:listEntite) {
                    if(entite.getClass().getName() == "Metier.Tile.Tile")
                        entites.add(entite);
                }
                break;
        }
        return entites;
    }
}
