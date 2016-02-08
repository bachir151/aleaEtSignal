package aleat.tpD;

import java.util.ArrayList;

public class CourbeDeGauss implements Plotable{

	
	
	private ArrayList<Double> xs  = new ArrayList<Double>();
	private ArrayList<Double> ys  = new ArrayList<Double>();

	
	public CourbeDeGauss(int taille, double gauche, double droite){
		for (int i=0;i<taille;i++){
		 xs.add(gauche + (droite-gauche)/taille*i);
		 ys.add((1./Math.sqrt(2.*Math.PI))*1.008*Math.exp(-Math.pow(xs.get(i),2)/2.));
		}				
	}	
	
	
	public ArrayList<Double> getXs(){
		return xs;
	}
	
	public ArrayList<Double> getYs(){
		return ys;
	}
	
	

}
