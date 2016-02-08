package aleat.tpE;

import aleat.tpD.Plotable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bachir on 10/11/15.
 */
public class Cauchy implements Plotable {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();


   public  Cauchy  (int taille, double gauche, double droite){
      for (int i=0;i<taille;i++){
         xs.add(gauche +(droite-gauche)/taille*i);
         ys.add((1/Math.PI)*(1/(1+Math.pow(xs.get(i),2))));

      }
   }

   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }



}
