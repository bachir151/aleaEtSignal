package aleat.tpK;

import aleat.tpH.PlotableColored;
import aleat.tpH.PlotablePoint;
import aleat.tpH.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bachir on 19/12/15.
 */
public class DessinGrille implements PlotablePoint,PlotableColored {
   private ArrayList<Double> Xs=new ArrayList<Double>();
   private ArrayList<Double> Ys=new ArrayList<Double>();
   private ArrayList<Double> radii=new ArrayList<Double>();
   private ArrayList<Double> colors=new ArrayList<Double>();

   public DessinGrille(Grille P){
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

      MultiPlotGrille multi = new MultiPlotGrille();
      int dim=50;
      Grille G =new Grille(dim);
      G.simulGrilleParMcmc(0.5, 5000);
      multi.addPlotable("identité pointé", new DessineGrille(G));
      multi.imposeRectangle(-1, -1, dim, dim); //  (-x,-y,x,y)

      multi.plotNow();

   }
}


