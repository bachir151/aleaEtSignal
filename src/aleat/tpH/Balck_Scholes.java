package aleat.tpH;
import java.util.ArrayList;

import aleat.tpB.MyRandom;
//import TpD.Dessinable;
//import TpD.Multi;

public class Balck_Scholes implements Plotable {
	
	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	public int fin ;
	private MyRandom rand = new MyRandom();
	public Balck_Scholes(double droite,double mu,double sigma, double deltaT) {

		Xs.add(0.);
		Ys.add(4.);
		double Brownien;
		int i = 0; 

		while (Xs.get(i) < droite) {
			Xs.add(i+1,Xs.get(i) + deltaT);
            Brownien= Math.sqrt(deltaT) * rand.nextGaussian();
            Ys.add( Ys.get(i)+Ys.get(i)*mu*deltaT+Ys.get(i)*sigma*Brownien);
			i++;
		}
			fin=i;
	}

	public double finy() {
		return Ys.get(fin);
	}
	public ArrayList<Double> getXs() {
		return Xs;
	}

	public ArrayList<Double> getYs() {
		return Ys;
	}

	public static void main(String[] args) {
		
		
		MultiPlotGrille multiTraceur = new MultiPlotGrille();
		Balck_Scholes dif;
		//double T = 4;
		double s=0;
		for (int i = 0; i < 500; i++) {
			dif = new Balck_Scholes(3,5.,3.,0.003);
			s=s+dif.finy();
		}
		System.out.println("la somme forfaitaire = " + (int) s/500);

	/*	for (int i = 0; i < 5; i++) {
			dif = new Balck_Scholes(T,1,1, 0.002);
			multiTraceur.addPlotable("g" +i,dif);
		}

		// multiTraceur.imposeRectangle(0, 0, T, 5);
		multiTraceur.plotNow();*/

	}

	

}
