package aleat.tpH;

import java.util.ArrayList;

import aleat.tpB.MyRandom;
//import TpD.Dessinable;
//import TpD.Multi;

public class Diffusion1D implements Plotable {
	
	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	private MyRandom rand = new MyRandom();
	public Diffusion1D(double droite ,double derive,double agitation, double deltaT) {

		Xs.add(0.);
		Ys.add(1.);
		double Brownien;
		int i = 0;
		while (Xs.get(i) < droite) {
			Xs.add(Xs.get(i) + deltaT);
            Brownien= Math.sqrt(deltaT) * rand.nextGaussian();
           // Ys.add( Ys.get(i)+derive*deltaT+agitation*Brownien);
			Ys.add(Ys.get(i) + (Math.exp(Ys.get(i))) * deltaT + (1/(Ys.get(i))) *
					 Math.sqrt(deltaT* rand.nextGaussian()));
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
		Diffusion1D dif;
		double T = 20;

		for (int i = 0; i < 3; i++) {
			dif = new Diffusion1D(T,-0.1,4,0.001);
			multiTraceur.addPlotable("g" +i,dif);
			//multiTraceur.lesLegendes.add("Diffusion " + i);
		}

		// multiTraceur.imposeRectangle(0, 0, T, 5);
		multiTraceur.plotNow();

	}


}
