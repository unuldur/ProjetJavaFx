package Metier.Visiteur;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by PAYS on 10/12/2015.
 */
public abstract class VisiteurAffichage extends Visiteur  {
    private GraphicsContext graphicsContext;

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public VisiteurAffichage(GraphicsContext gc)
    {
        graphicsContext = gc;
    }
}
