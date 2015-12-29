package Metier.Load;

import Metier.Entite.CreateurEntite;
import Metier.Entite.CreateurEntite2;
import Metier.Entite.Entite;
import Metier.Level.Level;
import javafx.geometry.Point2D;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by PAYS on 29/12/2015.
 */
public class LoadMap extends Load{
    @Override
    public ArrayList<Entite> Load(File file) {
        ArrayList<Entite> entites = new ArrayList<>();
        CreateurEntite2 creat = new CreateurEntite2();
        ObjectInputStream ois = null;
        String entite;
        String[] paramEntite;
        try {
            final FileInputStream fichier = new FileInputStream(file);
            ois = new ObjectInputStream(fichier);
            while(ois.available() ==0)
            {
                entite = (String) ois.readObject();
                paramEntite = entite.split(" ");
                Point2D pos = new Point2D(Double.parseDouble(paramEntite[3]),Double.parseDouble(paramEntite[4]));
                entites.add(creat.createurEntiteComplete(paramEntite[0],paramEntite[1],paramEntite[2],pos));
            }
        } catch (final java.io.IOException e) {
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return entites;
    }

    @Override
    public FileChooser.ExtensionFilter getExtension() {
        return new FileChooser.ExtensionFilter("Fichiers map", "*.map");
    }
}
