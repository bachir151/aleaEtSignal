package aleat.tpH;

import java.util.ArrayList;

import aleat.tpB.MyRandom;;


public class Diffusion implements Plotable {

	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	private MyRandom rand = new MyRandom();

	public Diffusion(double droite, double pas) {

		Xs.add(0.);
		Ys.add(1.);
		int i = 0;

		while (Xs.get(i) < droite) {
			Xs.add(Xs.get(i) + pas);
			double deltaY = Ys.get(i) * pas + Ys.get(i) * Math.sqrt(pas)
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
		Diffusion dif;
		double T = 4;

		for (int i = 0; i < 3; i++) {
			dif = new Diffusion(T, 0.01);
			multiTraceur.addPlotable("H" +i,dif);

		}

		// multiTraceur.imposeRectangle(0, 0, T, 5);
		multiTraceur.plotNow();

	}

}
