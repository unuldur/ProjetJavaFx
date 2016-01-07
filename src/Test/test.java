package Test;

import Metier.Entite.Entite;
import Metier.ModulesLoader;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by maxime on 12/03/2015.
 */

public class test {

    public static void main(String args[]) {
        try {
            ModulesLoader.addModulesPackage("Metier");
            Collection<Class> list = ModulesLoader.getPlugins(Entite.class);
            for (Class t:list
                 ) {
                System.out.println(t.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //levelCanvas.draw();
    }
}
