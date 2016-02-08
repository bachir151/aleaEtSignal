package signal;

import aleat.tpsynthese.MultiPlot;

import java.util.ArrayList;

/**
 * Created by bachir on 02/02/16.
 */
public class Sin extends  Fonction  {

   public Sin (){
   }
   public double Eval(double x){return Math.sin(x) ;}

   //Math.sqrt (1-Math.pow(x,2)) ;
   public static void main(String [] args){
      Fonction sin = new Sin();
     // System.out.println(sca(sin ,sin)) ;
      //System.out.println(0.5-Math.sin(1)/4 -(-0.5-Math.sin(-1)/4));

      ArrayList<Double > Mescoef = new ArrayList<>();
      ArrayList<Polynome >  w = new ArrayList<>();
      Fonction f = new Sin();
      Polynome  pol = new Polynome(30);
      ArrayList<Double> px= new ArrayList<Double>();
      px.add(0.) ; px.add(0.) ;px.add(1.) ;
      // Polynome f = new Polynome(px);

      double M = 8;
      for (int i=0 ;i < M ;i++  ){
         double  n =1/Polynome.Norme(Polynome.PolyLegendre(i)) ;
         w.add(Polynome.PolyLegendre(i).multiplycste(n)) ; // Wi
      }
      for (int j=0 ;j < M ;j++  ){
         Mescoef.add(Polynome.sca(w.get(j), f)); // Ai=sca (Wi,f)
      }
      pol=w.get(0);
      for (int k=0 ;k < M ;k++ ){
         pol = Polynome.additionne(pol, w.get(k).multiplycste(Mescoef.get(k))) ; // sum Ai Wi
      }
      MultiPlot multi = new MultiPlot();
      // Polynome Poly = new Polynome(Mescoef);
      pol.toFonction(-20,20,100);

      multi.addPlotable("Mafonction", pol);
      multi.plotNow();

   }

}
