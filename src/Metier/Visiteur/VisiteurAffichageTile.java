package Metier.Visiteur;

import Metier.Item.Item;
import Metier.Monstre.Monstre;
import Metier.Tile.Tile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VisiteurAffichageTile extends VisiteurAffichage {

    public VisiteurAffichageTile(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void visit(Item i) {

    }

    @Override
    public void visit(Monstre m) {

    }

    @Override
    public void visit(Tile t) {
        getGraphicsContext().drawImage(new Image(t.getSprite()),t.getPosition().getX(),t.getPosition().getY());
    }
}
