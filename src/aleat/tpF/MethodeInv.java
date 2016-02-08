package aleat.tpF;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import aleat.tpD.MultiPlotAncien;
import aleat.tpD.Histogramme;
import aleat.tpB.MyRandom;
import aleat.tpsynthese.*;


public class MethodeInv {
	private Random rand=new Random();
	
	public MethodeInv(){
		
	}
	
	public double cauchy ()
	{	double u=rand.nextDouble();
		double v=21*rand.nextDouble();
	double Inverse=Math.tan(Math.PI*(v*u-0.5));
	return Inverse;
   }
	public double Weibull(double h, double alpha){
		Random u = new Random();
		return h * Math.pow((-Math.log(u.nextDouble())),(1/alpha));
	}
   ///////////////////////////////
  //--INVERSION EXPONENTIELLE--//
 ///////////////////////////////
	public double InvExpo(double lambda){
		double u=rand.nextDouble();
		double X=-1/lambda*Math.log(1-u); // X=F^-1(U)
		return X;
	}
	public double InvH(){
		double u=rand.nextDouble();
		double X=Math.log(1+(Math.exp(1)-1)*u); // X=F^-1(U)
		return X;
	}
	
   ///////////////////
  //--FACTORIELLE--//
 ///////////////////
	double factorielle(double x) {
		 double i;
		 double result=1;
		 if(x >= 1) {
		  for(i=x;i>1;i--) {
		   result = result*i;
		  }
		  return result;
		 }
		 else if(x == 0) return 1;
		 return 0;
		}
  ///////////////////
 //--COMBINAISON--//
///////////////////
		double combinaisons(double x,double y) {
		 double z = x-y;
		 return factorielle(x)/(factorielle(y)*factorielle(z));
		}
  /////////////////
 //--BINOMIALE--//
/////////////////
	public double binomiale(double n,double p,int k) {
		double C_n_p=combinaisons(n,k);	
		double binom=C_n_p*Math.pow(p, k)*Math.pow(1-p, n-k);
		return binom;
	}
	
  /////////////////////////////////
 //--METHODE INVERSE BINOMIALE--//
/////////////////////////////////	
	public double InvBinomiale(int n ,double p) {
		ArrayList<Double> probas = new ArrayList<Double>();
		//Tableau de probabilit�
		for (int k=0;k<=n;k++){
		probas.add(binomiale(n,p,k));
		}
		//Debut simulation
		double NbAleatoire=0;
		double U = rand.nextDouble();
		double Fdr = probas.get(0);//P(x<=1) :fonction de repartition

		while (U > Fdr) { // F^-1(U)=inf{ x telque F(x)>U} 
			NbAleatoire++;
			Fdr = Fdr + probas.get((int)NbAleatoire);//Fonction de repartition
		}

		return NbAleatoire;
	}

   //////////////////////
  //--QUEUE LOURDE--////
 //////////////////////
	public double falfa(double alfa) {
		Random rand= new Random();
		double u=rand.nextDouble();
		return -1+Math.pow(1-u,1/(1-alfa));
	}
	public double QueueLourde (double alpha ,double beta){
		double U =rand.nextDouble();
		double bernouli=rand.nextDouble();
		double Inverse=(Math.pow(1-U, 1/(1-alpha)))-1;
		if (bernouli<beta)
			return Inverse;
		else return -Inverse;
	
	}
	
	/********************************/
   /**--Theoreme Centrale limite--**/
  /********************************/
	

//**EXPONENTIELLE TCL**//
	
	public double TclExpo(double n,double lambda ){
		double somme=0;
		double esperance=1/lambda;
		double variance=1/Math.pow(lambda,2);
		for(int i=0;i<n;i++){
		somme=somme+InvExpo(lambda);
		}
		//double Ssn=(somme-(n*esperance))/Math.sqrt(n*variance);
		double Ssn=(somme)/Math.sqrt(n*variance);
		//double Ssn=(somme-(n*esperance));
		return Ssn; 
		            
		}
	/**Uniforme**/
	public double TclUnif(double n,double a,double b ){
		double somme=0;
		double esperance=(a+b)/2;
		double variance=Math.pow(b-a,2)/12;
		for(int i=0;i<n;i++){
			somme=somme+rand.nextDouble();
		}
		//double Ssn=(somme-(n*esperance))/Math.sqrt(n*variance);
		//double Ssn=(somme)/Math.sqrt(n*variance);
		double Ssn=(somme-(n*esperance));
		return Ssn;

	}
	public double TclPoisson(double n,double lambda ){
		MyRandom myrand =new MyRandom();
		double somme=0;
		double esperance=lambda;
		double variance=lambda;
		for(int i=0;i<n;i++){
			somme=somme+myrand.nextPoisson(lambda);
		}
		double Ssn=(somme-(n*esperance))/Math.sqrt(n*variance);
		//double Ssn=(somme)/Math.sqrt(n*variance);
		//double Ssn=(somme-(n*esperance));
		return Ssn;

	}
	
//**QUEULOURDE TCL**//
	
	public double TclQueueLourde(double n,double alpha,double beta){
		double somme=QueueLourde(alpha,beta);
		for (int i=0;i<n;i++){
         somme=somme+QueueLourde(alpha,beta);
		}
		double Ssn=(somme)/Math.pow(n,1/(alpha-1));
		return Ssn;
	}
	
//**TLC BINOMIALE**//
	public double TlcBinom(double n,double p ,double esperance ,double variance){
		double somme=0;
		for (int i=0;i<n;i++){
			somme=somme+InvBinomiale(20,p);		
		}
		
		double Sn=(somme-n*esperance)/(Math.sqrt(n)*Math.sqrt(variance));
		return Sn;
	}

		
	
	

	public static void main(String[] args) {
	//	double lambda =2;
		int nbsimul=50000;
		double lambda=2;
		int n =50;
		 ArrayList<Double> donnees = new ArrayList<Double>();
		ArrayList<Double> tmp = new ArrayList<Double>();
		MethodeInv f=new MethodeInv();
		Random rand =new Random();
		MyRandom myrand =new MyRandom();

		for(int i=0;i<n;i++){tmp.add(0.);}
		for(int i=0;i<nbsimul;i++){
			for (int k=0;k<n;k++){tmp.set(k,f.InvExpo(lambda));} //Génération des X_1 ...X_n ~ exp(%lamba)
			double som=0;
			for(int j=0;j<n;j++){som=som+tmp.get(j);} // X_1 +....+X_n
			donnees.add(som);
		}
		  // for (int i=0;i<600000;i++){donnees.add(f.InvBinomiale(20,0.5));}
		   //for (int k=0;k<=10000;k++){donnees.add(f.falfa(1.5));}
		//for (int k=0;k<=5000;k++){donnees.add(f.QueueLourde(1.2,0.5));}
		//for (int k=0;k<=50000;k++){donnees.add(f.cauchy());}
		//for (int k=0;k<=500000;k++){donnees.add(f.Weibull(1, 4));}
	    //for (int j=0;j<50000;j++){donnees.add(f.TclExpo(350, 3));}
		 //for (int j=0;j<500000;j++){donnees.add(rand.nextGaussian());}
		//for (int j=0;j<50000;j++){donnees.add(f.TlcBinom(50, 0.5,10,5));}
	   //for (int j=0;j<100000;j++){donnees.add(f.TclUnif(350,0, 1));}
		//for (int j=0;j<10000;j++){donnees.add(f.TclPoisson(3000, 1.2));}
		//for (int j=0;j<50000;j++){donnees.add(f.TclQueueLourde(500, 6.,0.5));}


		//System.out.println(f.binomiale(3,0.2,1));
		   // System.out.println(f.QueueLourde(1.7));

		/***histogramme****/
		Histogramme hist = new Histogramme(donnees);
		hist.setIntervalle(0,50);
		//hist.setIntervalle(-15,15); //queue
		//hist.setIntervalle(0,2); // weibull
		hist.setNombreDeBaton(100);
		hist.dresseHistogramme(true);
		MultiPlotAncien multiPlot = new MultiPlotAncien();
		multiPlot.addPlotable("test",hist);
		//multiPlot.nbGraduationX=12;
		//multiPlot.imposeRectangle(0, 0, 180, 20000);
		multiPlot.addPlotable("Gamma", new FonctionGamma(lambda,n,200, 0, 50));
	//	multiPlot.addPlotable("Gauss", new CourbeDeGauss(1000, -20, 20));
		//multiPlot.addPlotable("t4", new Cauchy(1500, -15, 15));
		//multiPlot.addPlotable("t4", new Weibull(1500,0,2,1,4));
		//multiPlot.addPlotable("t4", new Exponentielle(1500,0,10,2));
		//multiPlot.setStroke("Gauss", MultiPlotGrille.thick);

		//multiPlot.addPlotable("FonctionInv", new expoDensite(lambda,100,0,6));
		multiPlot.plotNow();
	

	}

}
