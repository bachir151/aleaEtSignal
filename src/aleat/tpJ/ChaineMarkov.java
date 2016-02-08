package aleat.tpJ;

import java.util.ArrayList;
import java.util.Random;

import aleat.tpB.MyRandom;

import aleat.tpH.MultiPlotGrille;
import aleat.tpH.Plotable;

public class ChaineMarkov implements Plotable {

	private Graphe graphe;
	private Etat pointDepart;
	private Random rand = new Random();
	private double tmax=800.;
	private ArrayList<Double> ProbaInvariante=new ArrayList<Double>();

	private ArrayList<Double> Xs = new ArrayList<Double>();
	private ArrayList<Double> Ys = new ArrayList<Double>();
	public ArrayList<Double> pi2 = new ArrayList<Double>();

	public ArrayList<Double> getXs() {
		return Xs;
	}

	public ArrayList<Double> getYs() {
		return Ys;
	}
	public ChaineMarkov(){

	}


	public ChaineMarkov(Graphe graph, int pointDepar) {
		graphe = graph;
		pointDepart = graphe.etats.get(pointDepar);
		for (int s = 0; s < graphe.Nbetats; s++) {
			ProbaInvariante.add(1 / (double) (graphe.Nbetats));
		}
		for (int i = 0; i < graphe.Nbetats; i++) {
			pi2.add(1 / (double) (graphe.Nbetats));
		}
	}

	private Etat prochainEtat(Etat etatActuel) {

		if (etatActuel.sorties.size() == 0)
			return etatActuel;
		/*else if(etatActuel.Id==graphe.Nbetats-1 )
			return etatActuel;*/
		else {
			int i = 0;
			double cumul = etatActuel.sorties.get(0).proba;
			double unReel = rand.nextDouble();

			while (unReel > cumul) {
				i++;
				cumul = cumul + etatActuel.sorties.get(i).proba;
			}
			return etatActuel.sorties.get(i).arrivee;
		}

	}
	public double  pi(int etat) {
		double passage=0.0;
		for (Double y : Ys) {
			if (y==etat)
				passage =passage +1.;
		}
		return passage/tmax;
	}


	public ArrayList<Double> ProbaInvariante2(double d) {
		ArrayList<Double> Pinouveauj = new ArrayList<Double>();
		double resultat;
		for (int k=0;k<tmax;k++){
			ArrayList<Double> Pinouveauj2 = new ArrayList<Double>();
			for (Etat j : graphe.etats) {
				resultat=0;
				{for (Etat i : graphe.etats)
					for (Fleche fle : i.sorties) {
						if (fle.arrivee==j)
							resultat =resultat + pi2.get(i.Id)*fle.proba*d;
/* pi3 est initialisé au début par (1/n,...,1/n) hors de cette
fonction*/
					}
					Pinouveauj2.add(resultat+(1-d)*1.0/graphe.Nbetats);
				}
			}

			pi2=Pinouveauj2;}
		Pinouveauj=pi2;
		return Pinouveauj;
	}


	public ArrayList<Double> ProbaInv(){
		ArrayList<Double> Pinouveauj = new ArrayList<Double>();
		ArrayList<Double> pi = new ArrayList<Double>();
		ArrayList<Double> p=new ArrayList<Double>();
		for (int s=0;s<graphe.Nbetats;s++){
			Pinouveauj.add(0.);
		}
		ArrayList<Double> Pi = new ArrayList<Double>();
		for (int s=0;s<graphe.Nbetats;s++){
			pi.add(1/(double)(graphe.Nbetats));
		}
       // for(int k=0;k<10;k++){
			 /* for (int a=0;a<Pinouveauj.size();a++){
				  Pinouveauj.set(a,0.);
			  }*/
		for (Etat i : graphe.etats) {
			for (Fleche fle : i.sorties) {
					Pinouveauj.set(fle.arrivee.Id, Pinouveauj.get(fle.arrivee.Id) + pi.get(i.Id) * fle.proba);

				}
				//System.out.println(Pinouveauj);
			}
			  //System.out.println(Pinouveauj);
			 // pi=Pinouveauj;
			  ////System.out.println(pi);

		//}
		return Pinouveauj;
	}
	public ArrayList<Double> ProbaInvariante() {
		ArrayList<Double> Pinouveauj = new ArrayList<Double>();
		double resultat;
		for (int k=0;k<tmax;k++){
			ArrayList<Double> Pinouveauj2 = new ArrayList<Double>();
			for (Etat j : graphe.etats) {
				resultat=0.;
				{for (Etat i : graphe.etats)
					for (Fleche fle : i.sorties) {
						if (fle.arrivee==j)
							resultat =resultat + pi2.get(i.Id)*fle.proba;
					}
					Pinouveauj2.add(resultat);
				}
			}
			//System.out.println("t"+k+" "+","+"pi="+Pinouveauj2);
			pi2=Pinouveauj2;}
		Pinouveauj=pi2;
		return Pinouveauj;
	}

	public void simuleTrajectoire(int Tmax) {

		Etat etatActuel = pointDepart;
		Xs.add(0.);
		Ys.add(pointDepart.Id * 1.);
		//System.out.print(etatActuel.Id + ",");
		for (int t = 1; t <= Tmax; t++) {
			etatActuel = prochainEtat(etatActuel);
			Xs.add(t * 1.);
			Ys.add(etatActuel.Id * 1.);
			//System.out.print(etatActuel.Id + ",");
		}
	}

	public void damping(double d ) {
		ArrayList<Double> pi = new ArrayList<Double>();
			for (int i = 0; i < ProbaInvariante.size(); i++) {
				pi.add(ProbaInvariante.get(i) * d + (1 - d) / (double) graphe.etats.size());
				ProbaInvariante.set(i, 0.);
			}
			for (Etat e : graphe.etats) {
				for (Fleche fl : e.sorties) {
					ProbaInvariante.set(fl.arrivee.Id, ProbaInvariante.get(fl.arrivee.Id) + pi.get(e.Id) * fl.proba);
				}
			}
	}
	public static void main(String[] args) {
		ArrayList<Double> X=new ArrayList<>();
		ArrayList<Double> Y=new ArrayList<>();
		ArrayList<Double> b=new ArrayList<>();
		Random rand= new Random();


		/*Graphe graph = new Graphe(6);
		graph.ajouteFleche(0, 3);
		graph.ajouteFleche(1, 0);
		graph.ajouteFleche(2, 1);
		//graph.ajouteFleche(2, 4);
		graph.ajouteFleche(3, 1);
		//graph.ajouteFleche(3, 4);
		graph.ajouteFleche(4, 1);
		//graph.ajouteFleche(4, 2);
		//graph.ajouteFleche(4, 3);
		graph.ajouteFleche(5, 1);
		graph.ajouteFleche(1, 2);*/


        /***Données 1*/
		/*graph.ajouteFleche(0, 1);
		graph.ajouteFleche(0, 2);
		graph.ajouteFleche(1, 2);
		graph.ajouteFleche(2, 1);
		graph.ajouteFleche(2, 0);*/
		 /***Données 2*/ /*Pour tester les pi*/
		/*Graphe graph = new Graphe(3);
		graph.ajouteFleche(0, 1);
		graph.ajouteFleche(0, 2);
		graph.ajouteFleche(1, 0);
		graph.ajouteFleche(1, 2);
		graph.ajouteFleche(2, 0);*/
		/**données 2 bis*/
		/*Graphe graph = new Graphe(4);
		graph.ajouteFleche(0, 1,1.);
		graph.ajouteFleche(1, 0,2.);
		graph.ajouteFleche(1, 2,1.);
		graph.ajouteFleche(1, 3,1.);
		graph.ajouteFleche(2, 0,1.);
		graph.ajouteFleche(2, 1,1.);
		graph.ajouteFleche(3, 2,1.);*/
		/***Donnés 3*/ /*Marche absorbée*/ // voir classe pour la réfléchie
		/*Graphe graph = new Graphe(7);
		for (int i=1; i<6; i ++){
			graph.ajouteFleche(i, i+1);
			graph.ajouteFleche(i, i-1);
		}
		graph.ajouteFleche(0, 1);
		graph.ajouteFleche(6, 5);*/
		/*Graphe graph = new Graphe(3);
		graph.ajouteFleche(0, 1);
		graph.ajouteFleche(1, 0);
		graph.ajouteFleche(2, 1);*/
		MyRandom r =new MyRandom();
		int n =r.Poisson(10);
		Graphe graph = new Graphe(n);
		for (int i =0 ;i<n;i++ ) {
			int villeA = rand.nextInt(n);
			int villeB = rand.nextInt(n);
			double poids = (double) rand.nextInt(10);
			graph.ajouteFleche(villeA, villeB, poids);
		}

 System.out.println(graph.etats.get(1).poidsTotal());
      double tmax=800;
		graph.calculProbaDeTransition();

		ChaineMarkov CM = new ChaineMarkov(graph,0); /*point de départ=1*/

		CM.simuleTrajectoire((int)tmax);

		MultiPlotGrille trac = new MultiPlotGrille();
		//trac.addPlotable("chaine de Markov", CM);
		//trac.plotNow();
	//	System.out.println("");
		/***Affichage proba Inv empirique*/
		/*System.out.println("pi1(0)="+CM.pi(0));
		System.out.println("pi1(1)="+CM.pi(1));
		System.out.println("pi1(2)="+CM.pi(2));*/
		//System.out.println("pi1(3)="+CM.pi(3));
		/*System.out.println("pi1(4)="+CM.pi(4));
		System.out.println("pi1(5)="+CM.pi(5));
		System.out.println("pi1(6)="+CM.pi(6));*/
		///System.out.println("pi(6)="+CM.pi(6));

		/***Damping***/
		CM.damping(0.85);
		System.out.println(CM.ProbaInvariante);
		/***Affichage proba Inv pratique*/
		/*System.out.println("pi2(0)="+CM.ProbaInvariante().get(0));
		System.out.println("pi2(1)="+CM.ProbaInvariante().get(1));
		System.out.println("pi2(2)="+CM.ProbaInvariante().get(2));*/
		/*System.out.println("pi2(0)="+CM.ProbaInv().get(0));
		System.out.println("pi2(1)="+CM.ProbaInv().get(1));
		System.out.println("pi2(2)="+CM.ProbaInv().get(2));*/
		//System.out.println("pi2(3)="+CM.ProbaInv().get(3));
		//System.out.println(CM.ProbaInv().get(0)+CM.ProbaInv().get(1)+CM.ProbaInv().get(2)+CM.ProbaInv().get(3));

		/*System.out.println("pi3(0)="+CM.ProbaInvariante2(0.85).get(0));
		System.out.println("pi3(1)="+CM.ProbaInvariante2(0.85).get(1));
		System.out.println("pi3(2)="+CM.ProbaInvariante2(0.85).get(2));
		System.out.println("pi(3)="+CM.ProbaInvariante2(0.85).get(3));
		System.out.println("pi(4)="+CM.ProbaInvariante2(0.85).get(4));
		System.out.println("pi(5)="+CM.ProbaInvariante2(0.85).get(5));*/
		/*System.out.println("pi(3)="+CM.pi(3));
		System.out.println("pi(4)="+CM.pi(4));
		System.out.println("pi(5)="+CM.pi(5));
		System.out.println("pi(6)="+CM.pi(6));*/



	}

}
