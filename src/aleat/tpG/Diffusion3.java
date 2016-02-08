package aleat.tpG;

import aleat.tpH.PlotableColored;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by bachir on 24/11/15.
 */
public class Diffusion3 implements PlotableColored {

   private ArrayList<Double> Xs=new ArrayList<Double>();
   private ArrayList<Double> Ys=new ArrayList<Double>();
   private ArrayList<Double> colors=new ArrayList<Double>();


   public Diffusion3(){
      Xs.add(0.);
      Ys.add(0.);
      int i = 0;
      double pas=0.1;
      double droite =2;
      Random rand =new Random();
      while (Xs.get(i) < droite) {

         Xs.add(Xs.get(i) + Math.sqrt(pas) * rand.nextGaussian());
         Ys.add(Ys.get(i) + Math.sqrt(pas) * rand.nextGaussian());
         colors.add(i*1.);
         i++;
      }

   }

   @Override
   public List<Double> colors() {
      return colors;
   }

   @Override
   public List<Double> getXs() {
      return Xs;
   }

   @Override
   public List<Double> getYs() {
      return Ys;
   }
}


