package aleat.tpF;

import java.util.ArrayList;
import java.util.Random;


import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Plotable;


public class GrandNb implements Plotable {
	Random rand = new Random();
	MethodeInv f = new MethodeInv();
	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	private ArrayList<Double> Va = new ArrayList<Double>();


	public GrandNb(double taille, double alpha) {



		double cumul = 0;

		for (int j = 0; j < taille; j++) {
			//Va.add(j, f.InvExpo(1));
			//Va.add(j, f.QueueLourde(alpha, 0.5));
			//Va.add(j, f.falfa(4));
			Va.add(j, f.cauchy());
		}

		for (int i = 0; i < taille; i++) {
			xs.add(i, (double) i + 1);
			cumul = cumul + Va.get(i);
			ys.add(i, cumul / (i + 1));


		}


	}


	public ArrayList<Double> getXs() {
		return xs;
	}

	public ArrayList<Double> getYs() {
		return ys;
	}

	public static void main(String[] args) {
		MethodeInv f = new MethodeInv();
		MultiPlotAncien multiTraceur = new MultiPlotAncien();
		//multiTraceur.addPlotable("t1", new GrandNb(50000, 3));
		multiTraceur.addPlotable("t2", new GrandNb(100000, 3));
		multiTraceur.addPlotable("t3", new GrandNb(100000, 3));
		multiTraceur.addPlotable("t4", new GrandNb(100000, 3));
		//multiTraceur.addPlotable("t4", new FonctionConstante(500,0,5000,0.5));
		//multiTraceur.addPlotable("t4", new Cauchy(1500,-20,20));
		//multiTraceur.addPlotable("t4", new Cauchy(1500,-20,20));
		//multiTraceur.addPlotable("t4", new Weibull(1500,0,5,0.5,2));
		//multiTraceur.addPlotable("t5", new Cauchy(100,0,20));
		multiTraceur.plotNow();
	}
}


