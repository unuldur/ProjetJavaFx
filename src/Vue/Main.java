package Vue;

import Metier.Entite.Entite;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //creation vue Sample
        final FXMLLoader loaderSample = new FXMLLoader(
                getClass().getResource(
                        "sample.fxml"
                )
        );
        Parent root =  loaderSample.load();
        primaryStage.setTitle("Editeur de niveau");

        Controller controller = loaderSample.getController();

        //creation vue AjouEntite

        final FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "AjoutEntite.fxml"
                )
        );
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        ControllerEntite controllerAjout = loader.getController();
        dialogStage.setResizable(false);
        controllerAjout.setDialogStage(dialogStage);



        controller.Init(primaryStage,dialogStage,controllerAjout);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
