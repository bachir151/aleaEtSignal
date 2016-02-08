package aleat.tpI;

import aleat.tpB.MyRandom;

import java.util.Random;

public class MonteCarlo {

	MyRandom rand = new MyRandom();

	public MonteCarlo() {

	}

	public double estimeEsperance(VariableAleatoire va, double precision) {

		double res = 0;
		int compteurDePetitDelta = 0;
		int N = 0;
		do {
			N++;
			double tirage = va.nextSimulation();
			if (Math.abs(tirage / N) < precision) compteurDePetitDelta++;
			else compteurDePetitDelta = 0;
			res = res + tirage;
		} while (compteurDePetitDelta < 20);
		//System.out.println("n="+N);
		return res / N;

	}

	public double estimeVariance(VariableAleatoire va, double precision) {

		double esp = estimeEsperance(va, precision);

		double espDuCarre = 0;
		int compteurDePetitDelta = 0;
		int N = 0;
		do {
			N++;
			double tirage = va.nextSimulation();
			if (Math.abs(tirage / N) < precision) compteurDePetitDelta++;
			else compteurDePetitDelta = 0;
			espDuCarre += tirage * tirage;
		} while (compteurDePetitDelta < 20);

		espDuCarre = espDuCarre / N;

		return espDuCarre - esp * esp;
	}

	public static void main(String[] args) {

		// VariableAleatoire va=new CarreDuneVaUniforme();

		//VariableAleatoire va = new VaUnifDansDisque();
		//VariableAleatoire vb = new VaCarreUnif();
		//VariableAleatoire vb = new Exo1();
		int n =40;
		double alpha =8.5;
		//VariableAleatoire vb = new LourdeMc(alpha);
		VariableAleatoire vc = new Exo4(100);

		MonteCarlo monteCarlo = new MonteCarlo();
		Random rand =new Random();
		//double c = monteCarlo.estimeVariance(vb, 0.1);
	//	double d = monteCarlo.estimeEsperance(vb, 0.1);
		//double a = monteCarlo.estimeVariance(va, 0.01);
		//double b = monteCarlo.estimeEsperance(va, 0.0001);
		//System.out.println("estimation var= " + a);
		//System.out.println("estimation esp = " + b);
		//System.out.println("estimation var= " + c);
		for (int i=0 ;i<5;i++)
		System.out.println("estimation es = " + monteCarlo.estimeEsperance(vc, 0.001));
		//for (int i=0 ;i<5;i++)
		//System.out.println("estimation  = " + monteCarlo.estimeVariance(vb, 0.0001));
		//System.out.println("estimation var = " + Math.pow(2,n)*monteCarlo.estimeVariance(vc, 0.001));
	}

}
