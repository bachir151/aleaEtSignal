package aleat.tpG;

import java.util.ArrayList;

import aleat.tpB.MyRandom;
import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Plotable;
import aleat.tpF.MethodeInv;

public class MarcheAleatoire2 implements Plotable {

	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	private MyRandom rand = new MyRandom();
	MethodeInv f =new MethodeInv();

	public MarcheAleatoire2(int nb) {

		Xs.add(0.);
		Ys.add(0.);
		for (int i = 0; i < nb; i++) {
			Xs.add(i * 1. / nb);
			Ys.add(Ys.get(i) +f.InvExpo(2)*rand.nextRademacher() / Math.sqrt(nb));
			/*if (i==0)
				Ys.add(0.0);
			else
			Ys.add(Ys.get(i-1) + f.QueueLourde(2.1,0.5) / Math.sqrt(nb));*/
		}
	}

	public ArrayList<Double> getXs() {
		return Xs;
	}

	public ArrayList<Double> getYs() {
		return Ys;
	}

	/*public MarcheAleatoire2(int nb, double alpha) {

		Xs.add(0.);
		Ys.add(0.);
		for (int i = 0; i < nb; i++) {
			Xs.add(i * 1. / nb);
			Ys.add((Ys.get(i) + (f.QueueLourde(alpha, 0.5)) / Math.pow(nb, 1 /
					 (alpha - 1))));
		}
	}*/



	public static void main(String[] args) {

		MultiPlotAncien multiTraceur = new MultiPlotAncien();
		MarcheAleatoire2 marcheAleatoire;

		for (int i = 0; i <5 ; i++) {
			marcheAleatoire = new MarcheAleatoire2(2000);
			multiTraceur.addPlotable("marche aléatoire " + i,marcheAleatoire);
		}

		//multiTraceur.imposeRectangle(0, -2, 1, 2);

		multiTraceur.plotNow();

	}

}
