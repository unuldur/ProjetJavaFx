package Metier.Load;

import Metier.Entite.Entite;
import Metier.Level.Level;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PAYS on 29/12/2015.
 */
public abstract class Load {
    public abstract ArrayList<Entite> Load( File file);
    public abstract FileChooser.ExtensionFilter getExtension();
}
