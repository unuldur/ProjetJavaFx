package Metier.Level;

import Metier.Entite.Entite;
import Metier.Monstre.Categorie;
import Metier.Type;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayList;


public class TreeViewLevel extends TreeView<String>{
    
    private ArrayList<Entite> liste;
    
    public TreeViewLevel()
    {
        this.liste = new ArrayList<>();
    }
    
    public TreeViewLevel(ArrayList<Entite> liste)
    {
        this.liste = liste;
    }
    
    public void addEntite(Entite entite)
    {
        this.liste.add(entite);
    }
    
    public ArrayList<Entite> getEntites()
    {
        return this.liste;
    }
    
    public void maj()
    {
        ArrayList<TreeItem<String>> types= new ArrayList<>();
        ArrayList<TreeItem<String>> categorie = new ArrayList<>();
        TreeItem<String> root = new TreeItem<>("Types");
        for(Entite e : liste)
        {
            TreeItem<String> actuType = new TreeItem<>(e.getClass().getSimpleName());
            if(!root.getChildren().contains(actuType))
            {
                root.getChildren().add(actuType);
            }

            if(e.getCategorie()!= null)
            {

                TreeItem<String> actuCategorie = new TreeItem<>(e.getCategorie().getCategorie());
                if(!root.getChildren().get(root.getChildren().lastIndexOf(actuType)).getChildren().contains(actuCategorie))
                {
                    root.getChildren().get(root.getChildren().lastIndexOf(actuType)).getChildren().add(actuCategorie);
                }
                root.getChildren().get(root.getChildren().lastIndexOf(actuType)).getChildren()
                        .get(root.getChildren().get(root.getChildren().lastIndexOf(actuType)).getChildren().lastIndexOf(actuCategorie)).getChildren().add(new TreeItem<>(e.getName()));
            }
            else
            {
                root.getChildren().get(root.getChildren().lastIndexOf(actuType)).getChildren().add(new TreeItem<>(e.getName()));
            }
        }
        setRoot(root);
    }
}
