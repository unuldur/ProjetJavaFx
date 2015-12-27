package Vue;

import Metier.Entite.CategorieEntite;
import Metier.Entite.CreateurEntite;
import Metier.Entite.CreateurEntite2;
import Metier.Entite.Entite;
import Metier.Item.Arme;
import Metier.Item.CreateurItem;
import Metier.Item.Item;
import Metier.Level.EntitesDisponibles;
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

    private TreeViewLevel trl;
    private EntitesDisponibles entitesDisponibles;
    private CreateurEntite2 creat;
    @FXML
    Pane PaneAffichage;

    @FXML
    Pane PanetreeView;

    @FXML
    public void initialize()
    {
        creat = new CreateurEntite2();
        Level level = new Level();
        entitesDisponibles= new EntitesDisponibles();
        trl = new TreeViewLevel(entitesDisponibles);
        LevelCanvas levelCanvas = new LevelCanvas(level, new ArrayList<>(Arrays.asList("Tile", "Item", "Monstre")));


        entitesDisponibles.addEntite(creat.createurEntite(Tile.class.getName(),"tiletest","Metier.Tile.Sol"));
        entitesDisponibles.addEntite(creat.createurEntite(Monstre.class.getName(),"Gluant","Metier.Monstre.Normal"));
        entitesDisponibles.addEntite(creat.createurEntite(Item.class.getName(),"Epée de bois","Metier.Item.Arme"));
        trl.maj();

        PaneAffichage.getChildren().add(levelCanvas);
        PanetreeView.getChildren().add(trl);

        levelCanvas.heightProperty().bind(PaneAffichage.heightProperty());
        levelCanvas.widthProperty().bind(PaneAffichage.widthProperty());
        levelCanvas.setOnMousePressed(event-> {
            if(event.isPrimaryButtonDown())
                if(trl.getSelectionModel().getSelectedItem().isLeaf())
                {
                    String cat = trl.getSelectionModel().getSelectedItem().getParent().getValue();
                    String type = trl.getSelectionModel().getSelectedItem().getParent().getParent().getValue();
                    level.addEntite(creat.createurEntiteComplete("Metier." + type + "." + type,trl.getSelectionModel().getSelectedItem().getValue()
                            , "Metier." + type + "." + cat,new Point2D(event.getX(),event.getY())),new Point2D(event.getX(),event.getY()));
                    levelCanvas.draw();
                }
            if (event.isSecondaryButtonDown())
            {
                level.delEntiteByPos(new Point2D(event.getX(),event.getY()));
                levelCanvas.draw();
            }

        });

    }

    @FXML
    public void SuprimerEntiteTreeView()
    {
        if(trl.getSelectionModel().getSelectedItem().isLeaf())
        {
            String cat = trl.getSelectionModel().getSelectedItem().getParent().getValue();
            String type = trl.getSelectionModel().getSelectedItem().getParent().getParent().getValue();
            entitesDisponibles.delEntite(creat.createurEntite("Metier." + type + "." + type,trl.getSelectionModel().getSelectedItem().getValue()
                    ,"Metier." + type + "." + cat ));
            trl.maj();
        }
    }


}
