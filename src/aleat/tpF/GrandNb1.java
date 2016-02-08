package aleat.tpF;

import java.util.ArrayList;
import java.util.Random;


import aleat.tpD.Plotable;
import aleat.tpD.MultiPlotAncien;

public class GrandNb1 implements Plotable {
	    Random rand= new Random();
	    MethodeInv f=new MethodeInv();
		private ArrayList<Double> xs = new ArrayList<Double>();
		private ArrayList<Double> ys = new ArrayList<Double>();
	
		
		
		
	    public GrandNb1(double taille,double alpha){
	    	  double x;
	    	  double u=0.;
	    	  for (int j=0;j<taille;j++){
	    		  ys.add(j,0.);
	    	  }
	    	 // ys.add(0,f.InvExpo(alpha));
			 //ys.add(0.);
			 //double alpha=2.1;
	    	for(int i=1;i<taille;i++){
	    		xs.add(i-1,((1/taille)*(i-1)));
				//xs.add((double)1/i);
	   			x=f.QueueLourde(alpha, 0.5);
	   			//u=rand.nextDouble();
	   			//if (u<0.5)
	    	   //ys.set(i,(((ys.get(i-1)+x)/Math.pow(i,(alpha-1)))));
	   			 ys.set(i,(ys.get(i-1)+x));
	 
	        }
	  }
	    
	    
	    public ArrayList<Double> getXs() {
			return xs;
		}

		public ArrayList<Double> getYs() {
			return ys;
		}
		public static void main(String[] args) {
			
			MultiPlotAncien multiTraceur = new MultiPlotAncien();
			GrandNb1 GrandNb1;

			for (int i = 0; i < 5; i++) {
				GrandNb1 = new GrandNb1(500,2.3);
				multiTraceur.addPlotable("Aleat Expo"+i ,GrandNb1);
				//multiTraceur.lesLegendes.add("marche aleatoire " + i);
			}
			//multiTraceur.imposeRectangle(0, -2, 1, 2);

			multiTraceur.plotNow();
	  }

}
