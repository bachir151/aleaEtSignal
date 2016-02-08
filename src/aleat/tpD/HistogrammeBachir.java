package aleat.tpD;
import java.util.*;
import java.util.List;

import aleat.tpB.MyRandom;

/**
 * Created by bachir on 13/10/15.
 */
public class HistogrammeBachir implements Plotable {
   private Integer nbBaton ;
   private ArrayList<Double> tailleBatons  = new ArrayList<Double>();
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();
   private ArrayList<Double> donnees = new ArrayList<Double>();
   private double gauche;
   private double droite;
   private boolean normalize=true;


   public HistogrammeBachir(List<Double> donnees){
      for (int i=0;i<donnees.size();i++) {
         this.donnees.add(donnees.get(i));
      }
      this.gauche = minimum(this.donnees);
      this.droite = maximum(this.donnees);
   }
   public HistogrammeBachir(double[] donnees){
      for (int i=0;i<donnees.length;i++) {
         this.donnees.add(donnees[i]);
      }
      this.gauche = minimum(this.donnees);
      this.droite = maximum(this.donnees);
   }
   public void setNombreDeBaton(int nbBaton){
      this.nbBaton =nbBaton;
   }
   public ArrayList<Double> getXs(){
      return xs;
   }
   public ArrayList<Double> getYs(){
      return ys;
   }
   private double maximum(ArrayList<Double> tab) {

      double theMax = tab.get(0);
      for (int i = 1; i < tab.size(); i++) {
         if (theMax < tab.get(i)) {
            theMax = tab.get(i);
         }
      }
      return (theMax);
   }
   private double minimum(ArrayList<Double> tab) {

      double theMin = tab.get(0);
      for (int i = 1; i < tab.size(); i++) {
         if (theMin > tab.get(i)) {
            theMin = tab.get(i);
         }
      }
      return (theMin);
   }
   public void setIntervalle(double gauche ,double droite){
      this.gauche=gauche;
      this.droite=droite;
   }
   public void setUnBatonParEntier(){
      this.nbBaton=(int)((droite-gauche))+1;
   }
   public void dresseHistogramme(Boolean normalize) {
      double largeurBaton =(droite - gauche) / (nbBaton);
      double longueurTotalBaton =0.;
      for (int i = 0; i < nbBaton; i++) {
         tailleBatons.add(0.);
      }
      for (double d : donnees) {
         int j = (int) ((d - gauche) / (droite- gauche) * (nbBaton));
         if (j >= 0 && j < nbBaton) {
            tailleBatons.set(j, tailleBatons.get(j) + 1);
         }
      }
      System.out.println(tailleBatons.get(tailleBatons.size()-1));
      for (int i=0;i<tailleBatons.size()-1;i++){
          longueurTotalBaton =longueurTotalBaton+tailleBatons.get(i);
      }
      if (minimum(donnees)>=gauche && maximum(donnees)<=droite) {
         double tailleDernierBaton=tailleBatons.get(tailleBatons.size() - 1) + 1;
         tailleBatons.set(tailleBatons.size() - 1, donnees.size()-longueurTotalBaton);
      }
      else {}

      //On rempli xs
      xs.add(gauche);
      xs.add(gauche);
      for (int i = 1; i< nbBaton; i++) {
         xs.add(gauche + largeurBaton*i);
         xs.add(gauche + largeurBaton*i);
         xs.add(gauche + largeurBaton*i);
      }
      xs.add(droite);
      xs.add(droite);
      //On remplie ys
      ys.add(0.);
      for (int i = 0; i < nbBaton; i++) {
         ys.add(tailleBatons.get(i));
         ys.add(tailleBatons.get(i));
         ys.add(0.);
      }
      //On normalise
      if (normalize) {
         double Aire=longueurTotalBaton*largeurBaton;
         for (int j = 0; j < ys.size(); j++) {
            ys.set(j, (ys.get(j) /Aire));
            xs.set(j,xs.get(j));
         }
      }



   }

   public static void main (String [] args){
      //double[] donnees = { 1., 2., 3., 4., 4., 4.,10., 10.,10., 2., 10.,10.,10., 2., 2., 3.,5., 4., 4., 13., 2.,2.,1.,0.,-1.,-1.,-1.,-3.,-3. };
     //double [] donnees ={2,2,2,2,6,6,6.,6.};
     // double [] donnees ={2,4,6,8,10};
     // double [] donnees ={2,2,4,4,4,6,6,6,6,6,8,8,8,8,8,8,10,10,10,10,10,10,10};
      Random rand=new Random();
      MyRandom rand2 =new MyRandom();
      /*double donnees [] = new double[500000];
      for (int i=0;i<500000;i++){
         donnees[i]=rand2.geom(0.5);
      }*/
      double donnees [] = new double[100000];
      for (int i=0;i<100000;i++){
         donnees[i]=rand.nextGaussian();
      }
      /*double donnees [] = new double[800];
      for (int i=0;i<800;i++){
         donnees[i]=rand2.nextPoisson(4);
      }*/
     /* double donnees [] = new double[500000];
      for (int i=0;i<500000;i++){
         donnees[i]=rand.nextDouble();
      }*/

      HistogrammeBachir hist = new HistogrammeBachir(donnees);
       hist.setNombreDeBaton(100);
      // hist.setIntervalle(0, 4);
      hist.setIntervalle(-4, 4);
      //hist.setUnBatonParEntier();
      hist.dresseHistogramme(true);
      //new Traceur3(hist);
     /* Plotable cons = new FonctionConstante(donnees.length, -2, 2, 0);
      for(int i=0;i<donnees.length-1;i++){
         cons.getXs().set(i,donnees[i]);
         cons.getYs().set(i,0.1);
         //cons.getYs().set(i,rand.nextDouble());
      }*/
     /* cons.getXs().set(donnees.length-1,9.6);
      cons.getYs().set(donnees.length-1,0.1);*/
      MultiPlotAncien multiPlot = new MultiPlotAncien();
      multiPlot.nbGraduationX = 6;
      //multiPlot.addPlotable("test", hist);
      //multiPlot.setColor("test", Color.black);
     // multiPlot.setStroke("test", MultiPlotGrille.thick);
      multiPlot.addPlotable("Gauss", new Cosinus(100, -4, 4));
      //multiPlot.addPlotable("Gauss", new CourbeDeGauss(100, -4, 4));
     // multiPlot.addPlotable("Constante", cons);
     // multiPlot.setJoinType("Constante", MultiPlotGrille.JoinType.bullet, 10);
      //noon  multiPlot.imposeRectangle(-5,0,10,0.4);
     // multiPlot.imposeRectangle(-4, 0, 4, 0.4);
     multiPlot.plotNow();
    // double x= new Gamma.gamma(4);


   }

}
