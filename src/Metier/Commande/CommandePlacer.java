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
public class CommandePlacer implements Commande {
    
    private final Level level;
    private final Entite entite;
    private final Point2D pos;
    
    public CommandePlacer(Level l, Entite e, Point2D p)
    {
        this.level = l;
        this.entite = e;
        this.pos = p;
    }
    
    @Override
    public void execute()
    {
        level.addEntite(entite, pos);
    }
    
    @Override
    public void reverse()
    {
        level.delEntite(entite);
    }
    
}
