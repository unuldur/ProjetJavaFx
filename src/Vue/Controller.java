package Vue;

import Metier.Entite.CreateurEntite;
import Metier.Entite.Entite;
import Metier.Item.CreateurItem;
import Metier.Level.Level;
import Metier.Level.LevelCanvas;
import Metier.Monstre.Categorie;
import Metier.Monstre.CreateurMonstre;
import Metier.Monstre.Monstre;
import Metier.Tile.CreateurTiles;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

import java.util.List;

public class Controller {

    @FXML
    Pane PaneAffichage;

    @FXML
    TreeView<String> treeView;

    @FXML
    public void initialize()
    {
        CreateurEntite ci = new CreateurItem();
        CreateurEntite cm = new CreateurMonstre();
        CreateurEntite ct = new CreateurTiles();
        Level level = new Level();
        LevelCanvas levelCanvas = new LevelCanvas(level);
        Entite ei = ci.fabriqueEntite();
        Entite em = cm.fabriqueEntite();
        Entite et = ct.fabriqueEntite();
        ei.setSprite("Image/Blop !.png");
        em.setSprite("Image/Epée de bois Item.png");
        et.setSprite("Image/tiletest.png");
        level.addEntite(ci.fabriqueEntite(ei),new Point2D(10,10));

        level.addEntite(cm.fabriqueEntite(em),new Point2D(0,0));
        level.addEntite(cm.fabriqueEntite(em),new Point2D(10,16));

        level.addEntite(ct.fabriqueEntite(et),new Point2D(0,0));
        level.addEntite(ct.fabriqueEntite(et),new Point2D(20,0));
        level.addEntite(ct.fabriqueEntite(et),new Point2D(0,20));
        level.addEntite(ct.fabriqueEntite(et),new Point2D(20,20));
        PaneAffichage.getChildren().add(levelCanvas);


        levelCanvas.heightProperty().bind(PaneAffichage.heightProperty());
        levelCanvas.widthProperty().bind(PaneAffichage.widthProperty());

        loadTreeItems("coucou","encore un coucou","salut");
    }

    public void loadTreeItems(Monstre m) {
        /*
        TreeItem<String> root = new TreeItem<String>("Monstre");
        root.setExpanded(true);

        for (Categorie.values(): Categorie type) {
            root.getChildren().add(new TreeItem<String>(type));
        }
        TreeItem<String> root2 = new TreeItem<String>("Root Node 2");
        root2.setExpanded(true);

        root2.getChildren().add(root);
        treeView.setRoot(root2);
        */

    }


}
