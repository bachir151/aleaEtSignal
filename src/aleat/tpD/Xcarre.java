package aleat.tpD;

import java.util.ArrayList;

/**
 * Created by bachir on 13/10/15.
 */
public class Xcarre implements Plotable {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();


   public Xcarre(int taille, double gauche, double droite){
      for (int i=0;i<taille;i++){
         xs.add(gauche + (droite-gauche)/taille*i);
         ys.add( xs.get(i)*xs.get(i));

      }
   }

   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }




}
