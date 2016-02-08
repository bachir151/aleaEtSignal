package aleat.tpH;

//import modeleAleatoire.tpD_histo.cache.PlotablePoint;

import aleat.tpD.Plotable;

import java.util.ArrayList;


public class FonctionId implements Plotable {


	private ArrayList<Double> xs  = new ArrayList<Double>();
	private ArrayList<Double> ys  = new ArrayList<Double>();


	public FonctionId(int taille, double gauche, double droite){
		for (int i=0;i<taille;i++){
		 xs.add(gauche + (droite-gauche)/taille*i);
		 ys.add( xs.get(i));

		}				
	}	
	
	public ArrayList<Double> getXs(){
		return xs;
	}
	
	public ArrayList<Double> getYs(){
		return ys;
	}
	
	
	
	
	
}

