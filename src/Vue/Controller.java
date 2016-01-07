package Vue;

import Metier.Entite.CreateurEntite2;
import Metier.Entite.Entite;
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
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    private TreeViewLevel trl;
    private EntitesDisponibles entitesDisponibles;
    private CreateurEntite2 creat;
    private Level level;
    private LevelCanvas levelCanvas;

    private ControllerEntite controllerEntite;
    private Stage stageEntite;

    @FXML
    Pane PaneAffichage;

    @FXML
    Pane PanetreeView;

    @FXML
    BorderPane fenetre;

    @FXML
    Button closeButton;

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

        levelCanvas=initializeCanvas(levelCanvas);

    }

    private LevelCanvas initializeCanvas(LevelCanvas levelCanvas)
    {
        levelCanvas.heightProperty().bind(PaneAffichage.heightProperty());
        levelCanvas.widthProperty().bind(PaneAffichage.widthProperty());
            levelCanvas.setOnMousePressed(event -> {
                if (event.isPrimaryButtonDown())
                    if (trl.getSelectionModel().getSelectedItem().isLeaf()) { //TODO : gérer NullPointerException
                        String cat = trl.getSelectionModel().getSelectedItem().getParent().getValue();
                        String type = trl.getSelectionModel().getSelectedItem().getParent().getParent().getValue();
                        level.addEntite(creat.createurEntiteComplete("Metier." + type + "." + type, trl.getSelectionModel().getSelectedItem().getValue()
                                , "Metier." + type + "." + cat, new Point2D(event.getX(), event.getY())), new Point2D(event.getX(), event.getY()));
                    }
                if (event.isSecondaryButtonDown()) {
                    level.delEntiteByPos(new Point2D(event.getX(), event.getY()));
                }

            });

        return levelCanvas;
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


    public void Init(Stage stage,Stage stageEntite,ControllerEntite controllerEntite)
    {
        this.stageEntite = stageEntite;
        this.controllerEntite = controllerEntite;
        stage.setOnCloseRequest(event ->
        {
            File f = new File("Save.dat");
            Save save = new SaveMap();
            save.save(entitesDisponibles.getEntites(),f);
        });
    }

    @FXML
    public void addEntite()
    {
        Entite e ;
        controllerEntite.setEntite();
        stageEntite.showAndWait();
        e = controllerEntite.getEntite();
        if (controllerEntite.isOkClicked() && !entitesDisponibles.findEntite(e)) {
            entitesDisponibles.addEntite(e);
        }
        else System.out.println("Erreur lors de l'ajout. Avez-vous appuyé sur le bouton annuler?");
    }

    @FXML
    public void modifierEntiter()
    {
        if(trl.getSelectionModel().getSelectedItem().isLeaf())
        {
            String name = trl.getSelectionModel().getSelectedItem().getValue();
            String cat = trl.getSelectionModel().getSelectedItem().getParent().getValue();
            String type = trl.getSelectionModel().getSelectedItem().getParent().getParent().getValue();
            controllerEntite.setEntite(name,cat,type);
            stageEntite.showAndWait();
            Entite e = controllerEntite.getEntite();
            entitesDisponibles.modEntite(name,e);

        }
    }

    @FXML
    public void close()
    {
        Window window = closeButton.getScene().getWindow();
        window.hide();
    }
}
