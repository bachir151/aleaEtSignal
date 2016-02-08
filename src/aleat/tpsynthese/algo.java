package aleat.tpsynthese;

import java.util.ArrayList;
import java.util.Random;
import aleat.tpB.*;

/**
 * Created by bachir on 24/01/16.
 */
public class algo {
   private Random rand= new Random();
   public ArrayList<Double>  array = new ArrayList<Double>();

   public algo( int taille ) {
      for (int i = 0; i < taille; i++)
         array.add(0.);
   }

   public algo (){

   }




   public  void algorithme(){
      int poupeB =3;
      int autreJouet=12;
      int totalHotte= poupeB+autreJouet;
      for (int tirage =0;tirage <2 ;tirage++){
         int jouetTire=rand.nextInt(15)+1;
         if (jouetTire<=poupeB){
            poupeB =poupeB-1;
         }
         else {autreJouet=autreJouet-1;}
      }
      totalHotte=totalHotte-1;
      array.set(poupeB,array.get(poupeB)+1);
      //System.out.println("Nombre de de poupée restantes=" + poupeB);
     // System.out.println("array=" +array);
   }

   public int  marchealeat (){
      int y=0;
      int i =0;
      int x =0;
      double  u=0.;
      for (i= 0;i<30;i++){
         u =rand.nextDouble();
         if (u<0.5){x=x+1 ;

         }
         else {x=x-1;
         }
         if (x==0){
          break ;
         }
      }
      if (i==29){return 0;}
      else  {return i ;}
   }



   public static void main (String[] args){
      Random rand =new Random();
      ArrayList<Integer> arrivee = new ArrayList<Integer>();
      algo a = new algo();
      int b= a.marchealeat();
      System.out.println(b);
     /* for (int i=0;i<700;i++){

         while (b !=0 || b !=30){
             b= a.marchealeat();
         arrivee.add(b);}
      }*/
     /* int j=0;
      for (int i=0;i<700;i++){
        if (arrivee.get(i)==0) {break
        ;}
      }*/
      //System.out.println(arrivee);
     // System.out.println("proba ="+ j/700.);
     // System.out.println("proba ="+ j/700.);

      //for (int i=0;i<2;i++)
      //System.out.println(rand.nextInt(2)+1);
     // algo  a =new algo();
      //System.out.println();
      /*for (int i=0;i<7000;i++){
      a.algorithme();}
      for (int i= 0 ;i<4 ;i++){
       //  a.array.set(i ,a.array.get(i)/7000.);
      }
      //a.array.set(0 ,a.array.get(2)+a.array.get(3));
      System.out.println(a.array);*/

   }

}
