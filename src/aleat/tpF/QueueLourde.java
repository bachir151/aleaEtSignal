package aleat.tpF;

import java.util.ArrayList;
import aleat.tpD.Plotable;

public class QueueLourde implements Plotable {

	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	
    public QueueLourde(int taille,double gauche ,double droite,double alpha){
    	for(int i=0;i<taille;i++){
			xs.add(i,gauche+(droite-gauche)/taille*i);
			ys.add(i,(alpha-1)/Math.pow(1+xs.get(i),alpha));
    }
  }
    
    public ArrayList<Double> getXs() {
		return xs;
	}

	public ArrayList<Double> getYs() {
		return ys;
	}
	public static void main(String[] args) {
		

	}

}
