package Metier.Save;

import Metier.Entite.Entite;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by PAYS on 28/12/2015.
 */
public class SaveTXT extends Save{
    @Override
    public void save(ArrayList<Entite> Entites,File file) {
        try{
            FileWriter ffw=new FileWriter(file);
            for (Entite e:Entites
                 ) {
                ffw.write(e.getClass().getName()+" "+e.getName()+" "+e.getCategorie().getClass().getName()+" "+e.getPosition().getX()+" "+e.getPosition().getY());
                ffw.write("\n");
            }
            ffw.close();
        } catch (Exception e) {}
    }

    @Override
    public FileChooser.ExtensionFilter getExtension() {
       return new FileChooser.ExtensionFilter("Fichiers texte", "*.txt");
    }
}
