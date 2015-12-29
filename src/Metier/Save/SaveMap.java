package Metier.Save;

import Metier.Entite.Entite;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by PAYS on 29/12/2015.
 */
public class SaveMap extends Save{


    @Override
    public void save(ArrayList<Entite> Entites, File file) {
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream(file);
            oos = new ObjectOutputStream(fichier);
            for (Entite e:Entites) {
                oos.writeObject(e.getClass().getName()+" "+e.getName()+" "+e.getCategorie().getClass().getName()+" "+e.getPosition().getX()+" "+e.getPosition().getY());
            }
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public FileChooser.ExtensionFilter getExtension() {
        return new FileChooser.ExtensionFilter("Fichiers map", "*.map");
    }
}
