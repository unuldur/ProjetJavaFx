package Metier.Save;

import Metier.Entite.Entite;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by PAYS on 28/12/2015.
 */
public abstract class Save {

    public abstract void save(ArrayList<Entite> Entites,File file);
    public abstract FileChooser.ExtensionFilter getExtension();
}
