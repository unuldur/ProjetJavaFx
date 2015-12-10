package Metier.Visiteur;

import Metier.Item.Item;
import Metier.Monstre.Monstre;
import Metier.Tile.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created by PAYS on 10/12/2015.
 */
public class VisiteurAffichageMonstre extends VisiteurAffichage {
    public VisiteurAffichageMonstre(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void visit(Item i) {

    }

    @Override
    public void visit(Monstre m) {
        getGraphicsContext().drawImage(new Image(m.getSprite()),m.getPosition().getX(),m.getPosition().getY());
    }

    @Override
    public void visit(Tile t) {

    }
}
