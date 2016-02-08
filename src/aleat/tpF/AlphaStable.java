package aleat.tpF;

import java.util.ArrayList;
import java.util.Random;


import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Plotable;


public class AlphaStable implements Plotable {
	

    Random rand= new Random();
    MethodeInv f=new MethodeInv();
	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	
	
	
	
  /*  public AlphaStable(double taille,double alpha){
    	  double x=0.;
    	  for (int j=0;j<taille;j++){
    		  ys.add(j,0.);
    	  }
    	  ys.add(0,f.QueueLourde(alpha));
    	for(int i=1;i<taille;i++){
    		xs.add(i-1,-(1/taille*i-1));
   			x=f.QueueLourde(alpha);
    	    ys.set(i,(ys.get(i-1)+x)/2);
 
          
    	
    }
  }*/
    
    
    public ArrayList<Double> getXs() {
		return xs;
	}

	public ArrayList<Double> getYs() {
		return ys;
	}
	public static void main(String[] args) {
		
		MultiPlotAncien multiTraceur = new MultiPlotAncien();
		AlphaStable AlphaStable;

		/*for (int i = 1; i < 2; i++) {
			AlphaStable = new AlphaStable(500,4.6);
			multiTraceur.addPlotable("Alpha=4.6" ,AlphaStable);
			//multiTraceur.lesLegendes.add("marche aleatoire " + i);
		}*/

		//multiTraceur.lesLegendes.add("Marche aleatoire 2.6");
		//multiTraceur.lesLegendes.add("Marche aleatoire 1");
		//multiTraceur.lesLegendes.add("Marche aleatoire ");


		multiTraceur.plotNow();
  }

}
