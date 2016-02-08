package aleat.tpF;

import aleat.tpD.Plotable;

import java.util.ArrayList;


public class expoDensite implements Plotable{

	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();

	public expoDensite(double lambda,int taille, double gauche, double droite){
		for (int i =0;i<taille;i++){
			xs.add(i, gauche + (droite - gauche) / taille * i);
			ys.add(i, lambda * Math.exp(-xs.get(i) * lambda));
		}

	}

	
	public ArrayList<Double> getXs() {
		return xs;
	}

	public ArrayList<Double> getYs() {
		return ys;
	}
}

