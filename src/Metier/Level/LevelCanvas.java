package Metier.Level;

import Metier.Entite.Entite;
import Metier.Visiteur.Visiteur;
import Metier.Visiteur.VisiteurAffichageItem;
import Metier.Visiteur.VisiteurAffichageMonstre;
import Metier.Visiteur.VisiteurAffichageTile;
import javafx.scene.canvas.Canvas;

/**
 * Created by PAYS on 10/12/2015.
 */
public class LevelCanvas extends Canvas{
    private Level level;
    VisiteurAffichageItem vi;
    VisiteurAffichageMonstre vm;
    VisiteurAffichageTile vt;
    public LevelCanvas(Level l)
    {
        level=l;
        vi =new VisiteurAffichageItem(getGraphicsContext2D());
        vm =new VisiteurAffichageMonstre(getGraphicsContext2D());
        vt =new VisiteurAffichageTile(getGraphicsContext2D());

        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    public void draw()
    {

        vi.setGraphicsContext(getGraphicsContext2D());
        vm.setGraphicsContext(getGraphicsContext2D());
        vt.setGraphicsContext(getGraphicsContext2D());

        for (Entite e:level.getListEntite()) {
            e.accept(vt);
        }
        for (Entite e:level.getListEntite()) {
            e.accept(vm);
        }
        for (Entite e:level.getListEntite()) {
            e.accept(vi);
        }

    }
}
