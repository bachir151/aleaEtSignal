package aleat.tpsynthese;

import java.util.ArrayList;

/**
 * Created by vigon on 19/01/2016.
 */
public class Monde {

    ArrayList<Ville> villes;


    public Monde(int nbVilles){

        villes=new ArrayList<Ville>(nbVilles);

        for (int i=0;i<nbVilles;i++){
            this.villes.add(new Ville(i));
        }
    }


    public void ajouteRoute(Ville ville1,Ville ville2){

        ville1.routes.add(new Route(ville1,ville2));
        ville2.routes.add(new Route(ville2,ville1));

    }





    @Override
    public String toString() {
        return "Monde{" +
                "villes=\n" + villes +
                '}';
    }
}
