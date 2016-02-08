package aleat.tpE;

import java.util.ArrayList;
import java.util.Random;
import aleat.tpD.Histogramme;
import aleat.tpB.MyRandom;
import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Plotable;
public class Aire implements Plotable  {
	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	public Random rand=new Random();

	
	public Aire(int nbPoints) {
		MyRandom rand=new MyRandom();
		double x=0.0;
		double y=0.0;
		for (int i = 0; i < nbPoints; i++) {
			x=rand.nextUnif(0,2);
			y=rand.nextUnif(0,2);
			if (Math.pow(y, 2)+y>x && Math.pow(y, 2)+y<4-Math.pow(x,2)-x ){
				xs.add(x);
				ys.add(y);
			}
			
		}
	}
	public static double sommeCaree(double [] va){
		double somme =0.;
		for (int i=0;i<va.length;i++){
			somme=va[i]*va[i]+somme;
		}
		return somme;
	}
	public static double normeEuclidien(double [] va){
		double somme =0.;
		for (int i=0;i<va.length;i++){
			somme=va[i]*va[i]+somme;
		}
		return Math.sqrt(somme);
	}
	public static double [] normaliseVector(double [] vect){
		//double a =normeEuclidien(va);
		double sommeCarre =0.;
		for (int i=0;i<vect.length;i++){
			sommeCarre=vect[i]*vect[i]+sommeCarre;
		}
		double norme =Math.sqrt(sommeCarre);
		for (int i=0;i<vect.length;i++){
			vect[i]=vect[i]/norme;
		}
		return vect ;
	}

	public static double [] sphere(int dim ,int rayon){
		Random rand=new Random();
		MyRandom rand1=new MyRandom();
		double xxn[] = new double[dim];
		double sommeCarre=0.;
		do {
			for (int i = 0; i < xxn.length; i++) {
				//xxn[i] = rayon*rand.nextDouble();
				xxn[i] = rand1.nextUnif(-rayon, rayon);

			}
			 sommeCarre=0.;
			for (int j = 0; j < xxn.length; j++) {
				sommeCarre = Math.pow(xxn[j],2)+sommeCarre;
			}
		}while(sommeCarre>=rayon*rayon);

		//return xxn;
		return normaliseVector(xxn);

	}

	public static double maximum(double [] tab) {

		double theMax = tab[0];
		for (int i = 1; i < tab.length; i++) {
			if (theMax < tab[i]) {
				theMax = tab[i];
			}
		}
		return (theMax);
	}
	public  static double sqrt(double x){
		return Math.sqrt(x);
	}
	public static double volume(){
		int nbpoints=200000;
		int N=0;
		double Vol_Cube =4*4*4;
		MyRandom rand =new MyRandom();

		for (int i=0; i<nbpoints;i++){
			double x =rand.nextUnif(-2,2);
			double y=rand.nextUnif(0,4);
			double z =rand.nextUnif(-2,2);
			if(x<=2 && x>= -2 && y>=x*x && y<=4 && z<=sqrt(y-x*x) && z>=-sqrt(y-x*x)){
				N++;
			}
		}
		//System.out.println(8*Math.PI);
		return ( (double)N/200000.)*Vol_Cube;
	}

	public static void main(String[] args) {
		//double [] X=sphere(2, 1) ;
		int rayon=1;
		int dimension=15;
		Random rand =new Random();
		double [] donnees = new double [50000];
		for (int i =0;i<50000;i++){
			double [] X=sphere(dimension, rayon) ;
			double somme=0.;
			donnees[i]=X[rand.nextInt(dimension)];
		}

		Histogramme hist = new Histogramme(donnees);
		hist.setNombreDeBaton(150);
		hist.dresseHistogramme(true);

		MultiPlotAncien multiPlot = new MultiPlotAncien();
		multiPlot.addPlotable("test", hist);
		//multiPlot.setStroke("test",MultiPlotGrille.thick);
		multiPlot.plotNow();
		//normaliseVector(x);
		//double norme =sqrt(sommeCaree(X));
		//System.out.println("||X||="+norme);
		//double a =Math.sqrt(x[0]*x[0]+x[1]*x[1]);
		/*double a = normeEuclidien(x);
		for(int i=0;i<x.length;i++){
			x[i]=x[i]/a;
		}*/
	/*	double somme=0.;
		for (int i=0;i<50;i++) {
			somme=volume()+somme;
			//System.out.println("Volume bol =" + volume());
		}
		System.out.println("Volume bol ="+ somme/50.);
		System.out.println(8*Math.PI);*/

		/*System.out.println("x0="+x[0]);
		System.out.println("x1="+x[1]);
		double x0=x[0]/a;
		double x1 =x[1]/a;*/
		//System.out.println("x0 nomalise="+x0);
		//System.out.println("x1 nomalise="+x1);
		//System.out.println(x0*x0 +x1*x1);
		//ArrayList<Double> xs = new ArrayList<Double>();
		//ArrayList<Double> ys = new ArrayList<Double>();
		//MyRandom rand=new MyRandom();
		//int nbPoints=10;
		//double x=0.0;
		//double y=0.0;
	/*	for (int i = 0; i < nbPoints; i++) {
			x=rand.nextUnif(0,4);
			y=rand.nextUnif(0,4);
			if (Math.pow(y, 2)+y>x && Math.pow(y, 2)+y<4-Math.pow(x,2)-x )
			{
				//System.out.println(x);
				xs.add(x);
				ys.add(y);
			}
			
		}*/
	}


	public ArrayList<Double> getXs() {
		return xs;
	}

	public ArrayList<Double> getYs() {
		return ys;
	}

}
