package aleat.tpI;
import aleat.tpB.MyFirstRandom;
import java.util.*;

/**
 * Created by bachir on 01/12/15.
 */
public class VaSommeDiscrete
       implements VariableAleatoire {
   Random rand = new Random();
   public VaSommeDiscrete() {super();}
   public double nextSimulation(){
      double x=0.0;
      double y,z=0;
      x=0;
      for (int i = 0; i < 100; i++) {
         MyFirstRandom rand2 = new MyFirstRandom();
         double[] probabilites = { (double) 1/3,(double) 1/3,(double)
                1/3};
         double res=rand2.nextDiscrete(probabilites);
// variable aleatore discrete sur {-1,0,1}
         x=x + Math.pow(res-1, 2);
      }
      double densite = Math.pow((double) 1/3,100);
//densite du vecteur (x,y) = produit des densites
      double fi;
      fi=Math.pow((double) 1/3, 100)*Math.sqrt(x);
      z= z+fi/densite;
      return z;

   }
   public static void main(String[] args) {
      MyFirstRandom rand2 = new MyFirstRandom();
      double[] probabilites = {  1./3,1./3, 1./3};
      double res=rand2.nextDiscrete(probabilites);
      System.out.print(res-1);
   }
}
