package aleat.tpE;

import java.util.ArrayList;
import aleat.tpD.Plotable;


public class SemiCircu implements Plotable{

	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	
	public SemiCircu(int taille ,double gauche ,double droite ){
		for (int i =0;i<taille;i++){
			xs.add(i,gauche+(droite-gauche)/taille*i);
			ys.add(i,Math.sqrt(4-Math.pow(xs.get(i),2)));
		}

	}
	
	public ArrayList<Double> getXs() {
		return xs;
	}

	public ArrayList<Double> getYs() {
		return ys;
	}
}

