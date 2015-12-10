package Metier.Visiteur;

import Metier.Item.Item;
import Metier.Monstre.Monstre;
import Metier.Tile.Tile;

/**
 * Created by PAYS on 10/12/2015.
 */
public abstract class Visiteur {
    public abstract void visit(Item i);
    public abstract void visit(Monstre m);
    public abstract void visit(Tile t);
}
