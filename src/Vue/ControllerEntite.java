package Vue;

import Metier.Entite.CategorieEntite;
import Metier.Entite.CreateurEntite2;
import Metier.Entite.Entite;
import Metier.ModulesLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by PAYS on 30/12/2015.
 */
public class ControllerEntite {

    private Map<String,ArrayList<String>> tab = new TreeMap<>();
    private Stage dialogStage;
    private Entite entite;
    private boolean okClicked = false;
    private CreateurEntite2 creat = new CreateurEntite2();

    @FXML
    Button path;

    @FXML
    ComboBox<String> types;

    @FXML
    ComboBox<String> categories;

    @FXML
    Label name;

    @FXML
    AnchorPane fenetre;


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setEntite()
    {
        path.setText("Chercher");
        name.setText("");
        types.setValue(types.getItems().get(0));
        categories.setValue(categories.getItems().get(0));
    }

    public void setEntite(String names,String cat,String type)
    {
        name.setText(names);
        path.setText("src\\Image\\"+name.getText());
        types.setValue(type);
        categories.setValue(cat);
    }

    public Entite getEntite()
    {
        return entite;
    }
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            entite = creat.createurEntite("Metier."+types.getValue()+"."+types.getValue(),name.getText(),"Metier."+types.getValue()+"."+categories.getValue());
            //deplacement du fichier image dans le repertoire
            FileChannel in = null;
            FileChannel out = null;
            try {
                // Init
                in = new FileInputStream(path.getText()).getChannel();
                out = new FileOutputStream("src\\Image\\"+name.getText()).getChannel();
                in.transferTo(0, in.size(), out);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(in != null) {
                    try {
                        in.close();
                    } catch (IOException ignored) {}
                }
                if(out != null) {
                    try {
                        out.close();
                    } catch (IOException ignored) {}
                }
            }
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if(name.getText().equals(""))
            errorMessage+=" Pas de nom ";
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
    public void setListEntite()
    {
        try {
        ModulesLoader.addModulesPackage("Metier");
        Collection<Class> types = ModulesLoader.getPlugins(Entite.class);
        ModulesLoader.removeModulesPackage("Metier");
        for (Class classe:types) {
            if(classe == null ) continue;
            ModulesLoader.addModulesPackage(classe.getPackage().getName());
                Collection<Class> categories = ModulesLoader.getPlugins(CategorieEntite.class);
                for (Class categorie:categories) {
                    if(categorie == null) continue;
                    if(categorie.getSuperclass() != CategorieEntite.class)
                    {
                        ArrayList<String> cats = tab.get(classe.getSimpleName());
                        if(cats == null) cats =new ArrayList<>();
                        cats.add(categorie.getSimpleName());
                        tab.put(classe.getSimpleName(),cats);
                    }
                }

            ModulesLoader.removeModulesPackage(classe.getPackage().getName());
        }
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        setListEntite();
        for (String name:tab.keySet()) {
            types.getItems().add(name);
        }
        types.setValue(types.getItems().get(0));
        majCategorie();
        types.valueProperty().addListener(observable -> majCategorie());
    }

    private void majCategorie()
    {
        categories.getItems().clear();
        for (String name: tab.get(types.getValue())) {
            categories.getItems().add(name);
        }
        categories.setValue(categories.getItems().get(0));
    }

    @FXML
    public void loadImage()
    {
        FileChooser saveWindow = new FileChooser();
        saveWindow.getExtensionFilters().setAll( new FileChooser.ExtensionFilter("Fichier png"," *.png"));
        File f = saveWindow.showOpenDialog(fenetre.getScene().getWindow());
        if(f!= null)
        {
            String nam = f.getName();
            String[]a = nam.split(" ");
             String nomSansEspace="";
            for (String fin:a ) {
                nomSansEspace= nomSansEspace + fin;
            }
            path.setText(f.getPath());
            name.setText(nomSansEspace);
        }
    }
}
