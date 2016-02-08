package aleat.tpH;

import java.util.ArrayList;

import aleat.tpB.MyRandom;
//import TpD.Dessinable;
//import TpD.Multi;

public class Diffusion2D implements Plotable {

	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	private MyRandom rand = new MyRandom();

	public Diffusion2D(double droite, double pas) {

		Xs.add(0.);
		Ys.add(0.);
		int i = 0;
		while (Xs.get(i) < droite) {

			double deltaX = pas + Xs.get(i) * Math.sqrt(pas)
					* rand.nextGaussian();
			Xs.add(Xs.get(i) + deltaX);

			double deltaY = pas + Xs.get(i) * Math.sqrt(pas)
					* rand.nextGaussian();

			Ys.add(Ys.get(i) + deltaY);
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

		MultiPlotGrille multiTraceur = new MultiPlotGrille();
		Diffusion2D brow;

		for (int i = 0; i < 1; i++) {
			brow = new Diffusion2D(2, 0.00002);
			multiTraceur.addPlotable("g" +i,brow);
		}

		multiTraceur.plotNow();

	}

}
