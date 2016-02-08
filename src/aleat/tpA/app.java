package aleat.tpA;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bachir on 21/09/15.
 */
public class app {


   public static double f(int x){
      return 1.2*x*x-9*x+30;
   }
   public static void main (String args[]) {
     // double[] donnees = {1., 1.5, 3.2, 3.3, 3.4, 5., 5.9,5,5.1,5.3};
     // double[] donnees = {1., 1.2,1.4,1.6 ,2.1, 3.2, 3.4, 5.};
      Random rand = new Random();
      float [] donnees = new float [10000] ;
      for (int k=0;k<10000;k++) {
           donnees[k]=1+(10-1)*rand.nextFloat(); ;
      }
      System.out.print("Les données :");
      System.out.print("[");
      for (int j=0;j<10000;j++) {
         System.out.print((donnees[j]) + "--");
      }
      System.out.print("]");
      System.out.println();
      double droite = 10;
      double gauche = 0;
      int nbBaton = 50;
      double pas = (droite - gauche) / nbBaton;
      ArrayList<Float> tailleBatons = new ArrayList<Float>();
      for (int i = 0; i < nbBaton; i++) {
         tailleBatons.add((float)0);
      }
     /* for (Float d : donnees) {
         for (int j = 1; j < nbBaton + 1; j++) {

            if (d > (pas * (j - 1)) && d <= (pas * (j))) {
               float old = tailleBatons.get(j - 1);
               tailleBatons.set(j - 1, (old + 1));
            }
         }
      }*/
      for (double d : donnees) {
         //int j = (int) ((d - droite) / (gauche - droite) * (nbBaton - 1));
         double j =  d*nbBaton/6 ;
         if (j >= 0 && j < (double) nbBaton) {
            tailleBatons.set( (int)j, tailleBatons.get((int)j) + 1);
         }
      }
      System.out.print("Comptage :");
      System.out.print("[");
      for (int j=0;j<50;j++) {
         System.out.print(  tailleBatons.get(j) + ",");
      }
      System.out.print("]");
      System.out.println("");


     // ArrayList<Integer> PileFace = new ArrayList<>();
      double tirage =20;
      double pile =0;
      double  face =0;
      for (int i=0 ;i<tirage ;i++){
      double u= rand.nextDouble();
             if (u > 0.5)
                pile=pile+1;
             else
                face=face+1;
      }
     // System.out.println( "Frequence pile :" + pile/tirage);
      //System.out.println ("Frequence face :" + face/tirage );
      for (int i=1 ;i <=8 ;i++){
         System.out.println( "f"+(i)+"="+f(i) );
      }
   }
}

