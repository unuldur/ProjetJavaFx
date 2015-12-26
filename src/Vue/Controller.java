package Vue;

import Metier.Entite.CategorieEntite;
import Metier.Entite.CreateurEntite;
import Metier.Entite.CreateurEntite2;
import Metier.Entite.Entite;
import Metier.Item.Arme;
import Metier.Item.CreateurItem;
import Metier.Item.Item;
import Metier.Level.Level;
import Metier.Level.LevelCanvas;
import Metier.Level.TreeViewLevel;
import Metier.Monstre.Categorie;
import Metier.Monstre.CreateurMonstre;
import Metier.Monstre.Monstre;
import Metier.Monstre.Normal;
import Metier.Tile.CreateurTiles;
import Metier.Tile.Sol;
import Metier.Tile.Tile;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    Pane PaneAffichage;

    @FXML
    Pane PanetreeView;

    @FXML
    public void initialize()
    {
        CreateurEntite ci = new CreateurItem();
        CreateurEntite cm = new CreateurMonstre();
        CreateurEntite ct = new CreateurTiles();

        CreateurEntite2 creat = new CreateurEntite2();
        Level level = new Level();
        TreeViewLevel trl = new TreeViewLevel();

        LevelCanvas levelCanvas = new LevelCanvas(level, new ArrayList<>(Arrays.asList("Tile", "Item", "Monstre")));
        Entite ei = ci.fabriqueEntite();
        Entite em = cm.fabriqueEntite();
        Entite et = ct.fabriqueEntite();
        em.setSprite("Image/Gluant.png");
        em.setName("Gluant");
        ei.setSprite("Image/Epée de bois.png");
        ei.setName("Epee de bois");
        et.setSprite("Image/tiletest.png");
        et.setName("tiletest");
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(10,10));

        level.addEntite(cm.fabriqueEntite(em),new Point2D(0,0));
        level.addEntite(cm.fabriqueEntite(em),new Point2D(10,16));

        level.addEntite(ct.fabriqueEntite(et),new Point2D(0,0));
        level.addEntite(ct.fabriqueEntite(et),new Point2D(20,0));
        level.addEntite(ct.fabriqueEntite(et),new Point2D(0,20));
        level.addEntite(ct.fabriqueEntite(et),new Point2D(20,20));

        trl.addEntite(creat.createurEntite(Tile.class.getName(),"tiletest",new Sol()));
        trl.addEntite(creat.createurEntite(Monstre.class.getName(),"Gluant",new Normal()));
        trl.addEntite(creat.createurEntite(Item.class.getName(),"Epee de bois",new Arme()));
        trl.maj();

        PaneAffichage.getChildren().add(levelCanvas);
        PanetreeView.getChildren().add(trl);

        levelCanvas.heightProperty().bind(PaneAffichage.heightProperty());
        levelCanvas.widthProperty().bind(PaneAffichage.widthProperty());
        levelCanvas.setOnMousePressed(event-> {
            if(trl.getSelectionModel().getSelectedItem().isLeaf())
            {
                String cat = trl.getSelectionModel().getSelectedItem().getParent().getValue();
                String type = trl.getSelectionModel().getSelectedItem().getParent().getParent().getValue();
                level.addEntite(creat.createurEntiteComplete(new StringBuilder().append("Metier.").append(type).append(".").append(type).toString(),trl.getSelectionModel().getSelectedItem().getValue()
                        ,new StringBuilder().append("Metier.").append(type).append(".").append(cat).toString(),new Point2D(event.getX(),event.getY())),new Point2D(event.getX(),event.getY()));
                levelCanvas.draw();
        }
        });

    }


}
