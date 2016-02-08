package aleat.tpsynthese;

import aleat.tpD.Plotable;
import java.util.ArrayList;
import  aleat.tpE.*;
import aleat.tpD.Plotable;
/**
 * Created by bachir on 12/01/16.
 */
public class FonctionGamma implements Plotable {
   private ArrayList<Double> xs = new ArrayList<Double>();
   private ArrayList<Double> ys = new ArrayList<Double>();
   /**loi gamma**/
   static double logGamma(double x) {
      double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
      double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
             + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
             +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
      return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
   }

   static double gamma(double x) { return Math.exp(logGamma(x)); }
   /***on commence***/
   public FonctionGamma(double lambda,double n ,int taille, double gauche, double droite){
      for (int i =0;i<taille;i++){
         xs.add(i,gauche+(droite-gauche)/taille*i);
         ys.add(i,1/gamma(n)*Math.pow(lambda*xs.get(i),n-1)*lambda*Math.exp(-xs.get(i)*lambda));
      }

   }




   public ArrayList<Double> getXs() {
      return xs;
   }

   public ArrayList<Double> getYs() {
      return ys;
   }

}
