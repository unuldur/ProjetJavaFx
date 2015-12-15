/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.Commande;

import Metier.Entite.Entite;
import Metier.Level.Level;
import javafx.geometry.Point2D;

/**
 *
 * @author codemontgo
 */
public class CommandeSupprimer implements Commande {
    
    private final Level level;
    private final Entite entite;
    private Point2D pos;
    
    public CommandeSupprimer(Level l, Entite e)
    {
        this.entite = e;
        this.level = l;
    }
    
    @Override
    public void execute()
    {      
        pos = entite.getPosition();
        level.delEntite(entite);
    }
    
    @Override
    public void reverse()
    {      
        level.addEntite(entite, pos);
    }
    
}
