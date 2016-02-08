package aleat.tpE;
import java.lang.Math;

import aleat.tpB.MyRandom;
import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Histogramme;
//import java.util.ArrayList;
//import packE.MyFirstRandom;

public class Rejet {
	

	public Rejet (){
	}
	//

	//
	public double beta(double x,double alpha ,double beta) {
		double f=Math.pow(x,alpha-1)*Math.pow(1-x,beta-1);
		return f ;
	}
	
	public double semiCirculaire(double x){
		double f=(1/Math.PI)*Math.sqrt(4-Math.pow(x,2));
		return f ;
	}

	
	
	public double RejetSemiCircu() {
		MyRandom rand = new MyRandom();
		double y;
		double x;
		double max = 1 / Math.PI;
		do {
			y = rand.nextDouble();
			x = rand.nextDouble();
		}
		while (max * x > semiCirculaire(y));

		return y;

}
	//
	public double  rejetbeta (double alpha ,double beta){
		MyRandom rand=new MyRandom();
		double y;
		double x;
		double M= alpha-1/alpha+beta-2;
		do {
			y=rand.nextDouble();
			x=rand.nextDouble();//ou x=rand.nextUnif(0,M);
		}
		while(M*x>beta(y,alpha,beta));//while(x>beta(y,alpha,beta));
		return y;
	}
	
	
	
	
	public static void main(String[] args) {
		//ArrayList <Double> donnees=new ArrayList<Double>();
		MyRandom rand=new MyRandom();
		Rejet f =new Rejet();
		double alpha=1.7;
		double beta=2.5;
		/*for (int i =1;i<=10;i++)
		{
			double alpha=rand.nextInt(10);
			double beta=rand.nextInt(10);
			donnees.add(f.rejetbeta(alpha,beta ));
		}
           System.out.println(donnees);*/
		double donnees [] = new double[5000];
		for (int i=0;i<5000;i++) {
			donnees[i] = f.rejetbeta(alpha, beta);

		}
		Histogramme hist = new Histogramme(donnees);
		hist.setNombreDeBaton(150);
		hist.dresseHistogramme(true);
		MultiPlotAncien multiPlot = new MultiPlotAncien();
		//multiPlot.addPlotable("test",hist);
		multiPlot.addPlotable("FonctionBeta", new SemiCircu(100,-1,1)) ;
		//multiPlot.addPlotable("FonctionBeta", new FonctionBeta(100,1.7,2.5,0,1));
		multiPlot.plotNow();
	}

}
