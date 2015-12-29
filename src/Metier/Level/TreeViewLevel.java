package Metier.Level;

import Metier.Entite.Entite;
import Metier.Monstre.Categorie;
import Metier.Observateur.Observateur;
import Metier.Type;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayList;


public class TreeViewLevel extends TreeView<String> implements Observateur{
    
    private EntitesDisponibles entites ;
    
    public TreeViewLevel(EntitesDisponibles entitesDisponibles)
    {
        entites = entitesDisponibles;
    }

    public void maj()
    {
        TreeItem<String> root = new TreeItem<>("Types");
        for(Entite e : entites.getEntites())
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

    @Override
    public void update() {
        maj();
    }
}
