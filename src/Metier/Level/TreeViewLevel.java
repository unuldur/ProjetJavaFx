package Metier.Level;

import Metier.Entite.Entite;
import Metier.Observateur.Observateur;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


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
            String nameType = e.getClass().getSimpleName();
            TreeItem<String> type = treeItemEqual(root.getChildren(),nameType);
            if(type == null)
            {
                type = new TreeItem<>(nameType);
                root.getChildren().add(type);
            }

            if(e.getCategorie()!= null)
            {
                String nameCategorie = e.getCategorie().getCategorie();
                TreeItem<String> categorie = treeItemEqual(root.getChildren().get(root.getChildren().lastIndexOf(type)).getChildren(),nameCategorie);

                if(categorie == null)
                {
                    categorie =  new TreeItem<>(nameCategorie);
                    root.getChildren().get(root.getChildren().lastIndexOf(type)).getChildren().add(categorie);
                }
                root.getChildren().get(root.getChildren().lastIndexOf(type)).getChildren()
                        .get(root.getChildren().get(root.getChildren().lastIndexOf(type)).getChildren().lastIndexOf(categorie)).getChildren().add(new TreeItem<>(e.getName()));
            }
            else
            {
                root.getChildren().get(root.getChildren().lastIndexOf(type)).getChildren().add(new TreeItem<>(e.getName()));
            }
        }
        setRoot(root);
    }

    private TreeItem<String> treeItemEqual(ObservableList<TreeItem<String>> list,String name)
    {
        for (TreeItem<String> item:list) {
            if(item.getValue().equals(name))
                return item;
        }
        return null;
    }

    @Override
    public void update() {
        maj();
    }
}
