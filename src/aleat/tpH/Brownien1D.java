package aleat.tpH;

import java.util.ArrayList;

import aleat.tpB.MyRandom;
import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Plotable;
import aleat.tpF.MethodeInv;

public class Brownien1D implements Plotable {

	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	private MyRandom rand = new MyRandom();

	public Brownien1D(double droite, double pas) {
		MethodeInv f=new MethodeInv();
		Xs.add(0.);
		Ys.add(0.);
		int i = 0;
		while (Xs.get(i) < droite) {
			Xs.add(Xs.get(i) + pas);

			//Ys.add(Ys.get(i) + Math.sqrt(pas) * f.QueueLourde(7,0.7));
			Ys.add(Ys.get(i) + Math.sqrt(pas) * rand.nextGaussian());
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
		Brownien1D brow;

		for (int i = 0; i < 7; i++) {
			brow = new Brownien1D(2, 0.001);
			multiTraceur.addPlotable("brownien " + i,brow);
		}

		multiTraceur.plotNow();

	}

}
