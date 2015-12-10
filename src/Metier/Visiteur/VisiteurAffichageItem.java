package Metier.Visiteur;

import Metier.Item.Item;
import Metier.Monstre.Monstre;
import Metier.Tile.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by PAYS on 10/12/2015.
 */
public class VisiteurAffichageItem extends VisiteurAffichage {
    public VisiteurAffichageItem(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void visit(Item i) {
        getGraphicsContext().drawImage(new Image(i.getSprite()),i.getPosition().getX(),i.getPosition().getY());
    }

    @Override
    public void visit(Monstre m) {

    }

    @Override
    public void visit(Tile t) {

    }
}
