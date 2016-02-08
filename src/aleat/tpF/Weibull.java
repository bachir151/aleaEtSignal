package aleat.tpF;

import aleat.tpD.Plotable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bachir on 10/11/15.
 */
public class Weibull implements Plotable {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();


   public  Weibull  (int taille, double gauche, double droite ,double l, double k){
      Random rand = new Random();
      for (int i=0;i<taille;i++){
         xs.add((droite-gauche)/taille*i);
         ys.add((k/l)*(Math.pow(xs.get(i)/l,k-1)*Math.exp(-Math.pow(xs.get(i)/l,k))));

         // else ys.add( 0.);

      }
   }

   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }


}
