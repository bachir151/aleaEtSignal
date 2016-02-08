package aleat.tpH;

import java.util.ArrayList;

import aleat.tpB.MyRandom;
import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Plotable;

public class Brownien2D implements Plotable {

	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	private MyRandom rand = new MyRandom();

	public Brownien2D(double droite, double pas) {

		Xs.add(0.);
		Ys.add(0.);
		int i = 0;
		while (Xs.get(i) < droite) {

			Xs.add(Xs.get(i) + Math.sqrt(pas) * rand.nextGaussian());
          if (Xs.get(i)>1){
				 Ys.add(Ys.get(i) + Math.sqrt(pas) * rand.nextGaussian());
			 }
			else {
				 Ys.add(Ys.get(i) + 5 * Math.sqrt(pas) * rand.nextGaussian());
			 }
			i++;
		}
	}

	public ArrayList<Double> getXs() {
		return Xs;
	}

	public ArrayList<Double> getYs() {
		return Ys;
	}

	public static void main(String[] args) {

		MultiPlotAncien multiTraceur = new MultiPlotAncien();
		Brownien2D brow;

		for (int i = 0; i < 1; i++) {
			brow = new Brownien2D(2, 0.0002);
			multiTraceur.addPlotable("brownien " + i,brow);
		}

		multiTraceur.plotNow();

	}

}
