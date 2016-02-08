package aleat.tpH;

import java.util.ArrayList;

import aleat.tpB.MyRandom;

public class diffusion2 implements aleat.tpH.Plotable{
	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	private MyRandom rand = new MyRandom();

	public diffusion2(double droite, double deltaT,double derive,double agitation) {
		double brownienX;
		double brownienY;
		Xs.add(0.);
		Ys.add(0.);
		int i = 0;
		while (Xs.get(i) < droite) {
           /* brownienX=Math.sqrt(deltaT) * rand.nextGaussian();
				Xs.add(Xs.get(i)+(derive)*deltaT+agitation*brownienX);
            brownienY= Math.sqrt(deltaT) * rand.nextGaussian();
            Ys.add( Ys.get(i)+(derive)*deltaT+agitation*brownienY);
			i++;*/
			Xs.add(Xs.get(i) + Math.sqrt(deltaT)
					 * rand.nextGaussian());
			Ys.add(Ys.get(i) + 5.*Xs.get(i)*deltaT + 5.*Xs.get(i)*Ys.get(i) *
					 Math.sqrt(deltaT)* rand.nextGaussian());
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
		diffusion2 brow;

		for (int i = 0; i <1; i++) {
			brow = new diffusion2(2,0.0005,5, 2);
			multiTraceur.addPlotable("j"+i,brow);
			//multiTraceur.lesLegendes.add("brownien " + i);
		}

		multiTraceur.plotNow();

	}


}
