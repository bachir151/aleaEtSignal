package aleat.ReseauRoutier;

import aleat.tpsynthese.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by bachir on 19/01/16.
 */
public class Traceroute implements Plotable {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();

   Random rand = new Random();

   public Traceroute( double xa ,double ya , double xb,double yb  ){

      xs.add(xa);
      ys.add(ya);
      xs.add(xb);
      ys.add(yb);

   }





   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }
   public static void main(String[] args){
   ArrayList<Double> xs  = new ArrayList<Double>();
      ArrayList<Double> ys  = new ArrayList<Double>();
      int nbville=20;

      Region R = new Region(nbville);
      Random rand =new Random();
      for (int i =0;i<nbville;i++){
         for (int j =0;j <nbville ;j++){
            //if (i !=j){
            R.ajouteRoute(R.MesVilles.get(rand.nextInt(nbville)),R.MesVilles.get(rand.nextInt(nbville)),2*rand.nextInt(1)-1);}
         //}

      }
      int i=0;
      MultiPlot multiPlot=new MultiPlot();
      for ( Roadbach route : R.MesRoutes) {
         if (route.poids < 1) {
            for (City villedep : R.MesVilles) {
               for (City villearr : R.MesVilles){
                  if (route.dep==villedep .dep && route.arr==villearr.dep){
                     i++;

                     double xa= villedep.posX;
                     double ya=villedep.posY;
                     double xb=villearr.posX;
                     double yb=villearr.posY;
                     if (xa*xa+ya*ya>1 || xb*xb+yb*yb>1){}
                     else{
                        String s = "l"+i ;
                     multiPlot.addPlotable(s, new Traceroute(xa, ya, xb,yb));
                     multiPlot.setJoinType(s , MultiPlot.JoinType.joinBullet,10);}
                  }
               }

            }
         }
      }
      multiPlot.addPlotable("route4", new SemiCircu(300,-1,1.));
      multiPlot.addPlotable("route2", new SemiCircu2(300,-1,1.));
      multiPlot.setColor("route2", Color.black);
      multiPlot.setColor("route4", Color.black);
      multiPlot.imposeRectangle(-1, -1, 1,1);
      multiPlot.plotNow();
      //System.out.println("ville départ: " + R.MesRoutes.get(1).dep + ", arrivé : " + R.MesRoutes.get(1).arr);
     // System.out.println(xs);
      //System.out.println(ys);



   }


}
