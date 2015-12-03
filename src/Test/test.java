package Test;

import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.CreateurItem;
import Metier.Item.Item;
import Metier.Monstre.CreateurMonstre;
import Metier.Tile.CreateurTiles;

/**
 * Created by maxime on 12/03/2015.
 */
public class test {

    public static void main(String args[]) {
        CreateurEntite ci = new CreateurItem();
        CreateurEntite cm = new CreateurMonstre();
        CreateurEntite ct = new CreateurTiles();

        Entite ei = ci.fabriqueEntite();
        Entite em = cm.fabriqueEntite();
        Entite et = ct.fabriqueEntite();

        System.out.println(ei.toString());
        System.out.println(em.toString());
        System.out.println(et.toString());
    }
}
