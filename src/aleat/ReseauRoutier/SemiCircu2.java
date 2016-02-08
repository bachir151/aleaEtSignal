package aleat.ReseauRoutier;

import aleat.tpsynthese.Plotable;

import java.util.ArrayList;

/**
 * Created by bachir on 20/01/16.
 */
public class SemiCircu2 implements Plotable {
   private ArrayList<Double> xs = new ArrayList<Double>();
   private ArrayList<Double> ys = new ArrayList<Double>();

   public SemiCircu2 (int taille ,double gauche ,double droite ){
      for (int i =0;i<taille;i++){
         xs.add(i,gauche+(droite-gauche)/taille*i);
         ys.add(i,-Math.sqrt(1-Math.pow(xs.get(i),2)));
      }

   }

   public ArrayList<Double> getXs() {
      return xs;
   }

   public ArrayList<Double> getYs() {
      return ys;
   }
}
