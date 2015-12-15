/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.Commande;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author codemontgo
 */
public class Invocateur {
    private List<Commande> historique = new ArrayList<>();
    private int i;
    
    public Invocateur()
    {
        i = 0;
    }
    
    public void doCom(Commande com)
    {
        //On efface les actions UNDO précédentes
        List<Commande> nouv = new ArrayList<>(i + 1);
        for(int j = 0; j < i; ++j)
        {
            nouv.add(historique.get(j));
        }
        nouv.add(com);        
        this.historique = nouv;
        i ++;
        
        //Et on execute la commande
        com.execute();
    }
    
    public void undo()
    {
        if(canUndo())
        {
            i --;
            Commande comRev = historique.get(i);
            comRev.reverse();
        }
        else
        {
            System.err.println("undo impossible !");
        }
    }   
    
    public void redo()
    {
        if(canRedo())
        {
            Commande com = historique.get(i);
            i++;
            com.execute();
        }
        else
        {
            System.err.println("redo impossible !");
        }
    }
    
    public boolean canUndo()
    {
        return (i > 0);               
    }
    
    public boolean canRedo()
    {
        return (i < historique.size());               
    }
}
