package aleat.tpH;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import aleat.tpK.Grille;

/**
 * Created by bachir on 19/12/15.
 */
public class DessineGrille implements PlotablePoint,PlotableColored {
   private ArrayList<Double> Xs=new ArrayList<Double>();
   private ArrayList<Double> Ys=new ArrayList<Double>();
   private ArrayList<Double> radii=new ArrayList<Double>();
   private ArrayList<Double> colors=new ArrayList<Double>();

   public DessineGrille(Grille P){
      Random rand =new Random();
      for (int i=0;i<P.getDim();i++){
         for (int j=0;j<P.getDim();j++)
         {Xs.add(i*1.);}
      }
      for (int i=0;i<P.getDim();i++){
         for (int j=0;j<P.getDim();j++)
         {Ys.add(j*1.);}
      }
      for (int i=0;i<P.getDim();i++){
         for (int j=0;j<P.getDim();j++){
            colors.add((double)P.getContent()[i][j]);
           // radii.add(4.);
            radii.add((double)P.getContent()[i][j]);
         }
      }

   }

   @Override
   public List<Double> colors() {
      return colors;
   }
   @Override
   public List<Double> radius() {
      return radii;
   }
   @Override
   public List<Double> getXs() {
      return Xs;
   }
   @Override
   public List<Double> getYs() {
      return Ys;
   }

   public  static  void main (String [] args ){

     // System.out.println(n);
   // DessineGrille i = new DessineGrille(5);
     /* System.out.println(i.radius());
      System.out.println(i.getXs());
      System.out.println(i.getYs());*/
   /*Random rand=new Random();
   double maxRad=-Double.MAX_VALUE;//-Double
   double minRad=Double.MAX_VALUE;*/
   }
}


