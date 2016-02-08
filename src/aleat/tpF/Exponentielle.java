package aleat.tpF;

import aleat.tpD.Plotable;

import java.util.ArrayList;

/**
 * Created by bachir on 10/11/15.
 */
public class Exponentielle implements Plotable {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();


   public Exponentielle  (int taille, double gauche, double droite,double l){
      for (int i=0;i<taille;i++){
         xs.add(gauche +(droite-gauche)/taille*i);
         ys.add(l*Math.exp(-l*xs.get(i)));

      }
   }

   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }


}
