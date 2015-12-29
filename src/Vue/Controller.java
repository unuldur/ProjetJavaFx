package Vue;

import Metier.Entite.CreateurEntite2;
import Metier.Item.Item;
import Metier.Level.EntitesDisponibles;
import Metier.Level.Level;
import Metier.Level.LevelCanvas;
import Metier.Level.TreeViewLevel;
import Metier.Load.Load;
import Metier.Load.LoadMap;
import Metier.Monstre.Monstre;
import Metier.Save.Save;
import Metier.Save.SaveMap;
import Metier.Save.SaveTXT;
import Metier.Tile.Tile;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    private TreeViewLevel trl;
    private EntitesDisponibles entitesDisponibles;
    private CreateurEntite2 creat;
    private Level level;
    private LevelCanvas levelCanvas;

    @FXML
    Pane PaneAffichage;

    @FXML
    Pane PanetreeView;

    @FXML
    BorderPane fenetre;

    @FXML
    public void initialize()
    {


        creat = new CreateurEntite2();
        level = new Level();
        entitesDisponibles= new EntitesDisponibles();
        trl = new TreeViewLevel(entitesDisponibles);
        levelCanvas = new LevelCanvas(level, new ArrayList<>(Arrays.asList("Tile", "Item", "Monstre")));

        level.ajouterObservateur(levelCanvas);
        entitesDisponibles.ajouterObservateur(trl);

        File f =new File("Save.dat");
        Load load = new LoadMap();
        entitesDisponibles.setListe(load.Load(f));

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
                }
            if (event.isSecondaryButtonDown())
            {
                level.delEntiteByPos(new Point2D(event.getX(),event.getY()));
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
        }
    }

    @FXML
    public void saveMap()
    {
        save(new SaveMap());
    }

    @FXML
    public void saveTxt()
    {
        save(new SaveTXT());
    }

    public void save(Save save)
    {
        FileChooser saveWindow = new FileChooser();
        saveWindow.getExtensionFilters().setAll(save.getExtension());
        File f = saveWindow.showSaveDialog(fenetre.getScene().getWindow());
        if(f!= null)
            save.save(level.getListEntite(),f);
    }

    @FXML
    public void loadMap()
    {
        load(new LoadMap());
    }

    public void load(Load load)
    {
        FileChooser saveWindow = new FileChooser();
        saveWindow.getExtensionFilters().setAll(load.getExtension());
        File f = saveWindow.showOpenDialog(fenetre.getScene().getWindow());
        level.delAll();
        if(f!= null)
            level.setListEntite(load.Load(f));
    }


    public void Init(Stage stage)
    {

        stage.setOnCloseRequest(event ->
        {
            File f = new File("Save.dat");
            Save save = new SaveMap();
            save.save(entitesDisponibles.getEntites(),f);
        });
    }

}
