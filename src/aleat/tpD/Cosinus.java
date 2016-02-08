package aleat.tpD;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

/**
 * Created by bachir on 13/10/15.
 */
public class Cosinus implements Plotable {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();


   public  Cosinus  (int taille, double gauche, double droite){
      Random rand = new Random();
      for (int i=0;i<taille;i++){
         xs.add((double)i);
         ys.add(Math.sqrt(2)*i*Math.log(i));

      }
   }

   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }



}
