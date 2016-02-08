package aleat.tpK;

import aleat.tpD.Histogramme;
import aleat.tpD.MultiPlotAncien;

import java.util.ArrayList;
import java.util.Random;

public class McmcEnCercle {

	private ArrayList<Double> pi = new ArrayList<Double>();

	private int etatCourant = 0;

	private int T = 1000;
	private int nbEtat = 8;
	Random rand = new Random();

	public McmcEnCercle() {

		for (int i = 0; i < nbEtat; i++) {
			if (i == 1 || i == 2 || i == 3) {pi.add(1.);}
			else if  (i == 5 || i == 6 || i == 7){pi.add(2.);}
				else {pi.add(0.);}
		}
			//pi.add((double) (i +1));


	}

	/*public int nextSimulation() {

		etatCourant = rand.nextInt(nbEtat); //On choisit un état au hasard x0

		for (int t = 1; t <= T; t++) {
			MyFirstRandom myRand = new MyFirstRandom();
			//double[] probabilites = { 1./140.,4./140.,9./140.,16./140.,25./140., 36./140., 49/140.};
			int aleat = 2 * rand.nextInt(2) - 1;
			int xi = ((etatCourant + aleat + nbEtat) % nbEtat); // x1=(x+1+8) mod 8 =l'etat suivant
			//int xi=myRand.nextDiscrete(probabilites);
			double choix = rand.nextDouble();
			if (choix < Math.min(pi.get(xi) / pi.get(etatCourant), 1))
				etatCourant = xi;//On accepte l'etat suivant avec proba pi(x1)/pi(x0)

		}

		return etatCourant; //sinon reste dans l'état x0
	}*/

	public int nextSimulation() {

		etatCourant = rand.nextInt(nbEtat);//x0

		for (int t = 1; t <= T; t++) {

			 int aleat = 2 * rand.nextInt(2) - 1;
		       //xi =rand.nextInt(8);
		//if (etatCourant==0 && xi==4)
			//int xi = ((etatCourant + aleat + nbEtat) % nbEtat);
			int xi = ((etatCourant + aleat + nbEtat) % nbEtat);//epsilon
			double choix = rand.nextDouble();
			if (choix < Math.min(pi.get(xi) / pi.get(etatCourant), 1))
				etatCourant = xi;

		}

		return etatCourant;
	}


/***Rajout***/
	public static  int  sommecarre(){
		int a =0;
		for (int i=0 ;i<8;i++ ){
			a=a+i*i;
		}
		return a ;
	}
	public static  int  xplus1carre( int x ) {
		return (x+1)*(x+1);
	}
	 public static double pi(int x){
		return xplus1carre(x)/(double)sommecarre();
		//System.out.println(xplus1carre(x) +"/" +sommecarre());
	}


	public static void main(String[] args) {

		McmcEnCercle mcmcEnCercle = new McmcEnCercle();

		ArrayList<Double> donnees = new ArrayList<Double>();

		for (int k = 0; k < 1000; k++) {
			donnees.add((double) mcmcEnCercle.nextSimulation());
		}

		Histogramme hist = new Histogramme(donnees);
		//hist.setUnBatonParentier();
		hist.dresseHistogramme(true);

		MultiPlotAncien traceur = new MultiPlotAncien();
		traceur.addPlotable("histogramme ", hist);
		traceur.plotNow();

      Random rand =new Random();
		//int a =rand.nextInt(8);
		//System.out.println(a);

		//System.out.println(7*rand.nextInt(2)-7);
		/*boolean [][] mat =new boolean [10][10];
		for (int i=0;i<10;i++){
			for (int j=0;i<10;i++){
			mat[i][j]=(Math.random()<0.5);}}
		System.out.println(mat[0][1]);*/
		//for (int i=0;i<8;i++)
	//	System.out.println(xplus1carre(i) +"/" +sommecarre());
		//ArrayList<Integer> pi = new ArrayList<Integer>();
		//Random rand =new Random();

		/*********Test de sommeCarre et afficheMatrice*****/
		/*for (int i=0;i<8;i++)
		System.out.println(xplus1carre(i) +"/" +sommecarre());*/
		/*int [][]  matrice = new int  [9][4];
		for (int i=0 ;i<9;i++){
			for (int j=0 ;j<4;j++){

				if (i<3){
					matrice[i][j]=0;
					matrice[i][1] = 1;
					matrice[i][(i + 1)%4] = 1;
				}
				else {
					matrice[i][j]=0;
					matrice[i][1] = 1;
					matrice[i][(i + 2)%4] = 1;
				}
			}
		}
		System.out.println(matrice[0][1]);
      System.out.println(matrice[1][2]);
		System.out.println(matrice[2][3]);
		System.out.println(matrice[3][1]);
		System.out.println(matrice[4][2]);
		System.out.println(matrice[5][3]);
		System.out.println(matrice[6][1]);
		System.out.println(matrice[7][2]);
		System.out.println(matrice[8][3]);*/
	}

}
