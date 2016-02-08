package aleat.tpsynthese;


import java.util.Random;

/**
 * Created by vigon on 19/01/2016.
 */
public class Main {

    public static void main(String[] args){

        int nbVilles=30;
        double longMaxRoute=0.7;
        Monde monde=new Monde(nbVilles);

        Random random=new Random();
        for (Ville ville : monde.villes){
            double x=random.nextDouble()*2-1;
            double y=random.nextDouble()*2-1;
            while (x*x+y*y>1){
                x=random.nextDouble()*2-1;
                y=random.nextDouble()*2-1;
            }
            ville.x=x;
            ville.y=y;
        }

        for (Ville villeDep : monde.villes){
            for (Ville villeArr :monde.villes){
                if(villeDep.id<villeArr.id) {
                    double distance=norme2d(villeDep.x-villeArr.x,villeDep.y-villeArr.y);
                    if (distance<longMaxRoute) {
                                monde.ajouteRoute(villeDep, villeArr);
                    }
                }
            }
        }

        System.out.println(monde);

        MultiPlot multiPlot=new MultiPlot();
        for (Ville ville : monde.villes){
            for (Route route:ville.routes){
                if (route.dep.id<route.arr.id) {

                    String legende=route.dep.id+">"+route.arr.id;
                    multiPlot.addPlotable(legende, route);
                    //multiPlot.setJoinType(legende, MultiPlotAncien.JoinType.joinBullet,10);
                }
            }
        }

        multiPlot.imposeRectangle(-1,-1,1,1);
        multiPlot.plotNow();
    }

    public static double norme2d(double x, double y){
        return Math.sqrt(x*x+y*y);
    }


}
