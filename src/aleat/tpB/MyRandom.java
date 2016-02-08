package aleat.tpB;

import java.util.ArrayList;
import java.util.Random;



/*
 * Plutôt que de recréer une classe de simulation, nous étendons la précédente. 
 */
public class MyRandom extends Random {



	public MyRandom(){
		// le constructeur doit faire appel au constructer de la classe mère : 
		super();
	}
	
	
	/*
	 * On met ici nous propres méthodes qui s'ajouterons à celles déjà existance dans la classe mère. 
	 */
	public int nextDiscrete(double [] probas){
		int res=0;
				
		double unReel = super.nextDouble();
		double cumul=probas[0];
				
		while (unReel > cumul){
			res++;
			cumul = cumul + probas[res];
		}
							
		return res;		
	}
	
public int nextRademacher(){
	double u =super.nextDouble();
	if (u > 0.5)
		return 1;
	else
		return -1;

}
	
	/**
	 *  Créer maintenant une méthode qui renvoie un tirage de loi géométrique.
	 */
	public int nextGeom(double p)
	//cette fonction prend en paramètre p  qui est la probabilité de cette loi.
	{
	//on déclare une variable entière Nbechec=1
		int Nbechec=1;

   //On compte le nombre d'echecs avant le premier succes
		while(p<super.nextDouble())
			Nbechec++;
		//On renvoie le nombre d'echecs avant le premier succes
		return Nbechec;
	}


	/**
	 * A l' avenir, vous rajouterez ici toutes les méthodes qui permettent de
	 * tirer des nombres aléatoire (il y aura une nextPoisson, une nextGeometric, une nextAlpha).
	 */

	public int nextPoisson(double lambda)
	{int n=0;
		Random rand= new Random();
		double x=rand.nextDouble();
		while (x > Math.exp(-lambda))
		{
			x=x*(rand.nextDouble());
			n=n+1;
		}
		return n;
	}

	public int Poisson(double lambda){
		double s = 0;
		int r = 0;
		while (s>=-lambda) {
			s = s + Math.log(super.nextDouble());
			r = r + 1;
		}
		return r-1; // valeur finale à retourner
	}

	public  int nextBernouli(double p){
			double u= super.nextDouble();
			if (u > p)
				return 1;
			else
				return 0;
	}

	public double  nextUnif(double a ,double b){
		return a + (b-a)*(super.nextDouble()) ;
	}

	public static void main(String[] args) {
		
		MyFirstRandom myRand=new MyFirstRandom();
		Random rand = new Random();
		double [] probabilites={0.2,0.2,0.6};
		
		ArrayList<Integer> desTirages= new ArrayList<Integer>();
		
		for (int i=0;i<20;i++){
			desTirages.add(myRand.nextDiscrete(probabilites));
		}
		
		System.out.println(desTirages);
		ArrayList<Integer> tirages1= new ArrayList<Integer>();
		ArrayList<Integer> tirages2= new ArrayList<Integer>();
		ArrayList<Integer> tirages3= new ArrayList<Integer>();
		MyRandom myrand2=new MyRandom();
		for (int i=0;i<20;i++){
		//	tirages1.add(myrand2.nextGeom(.2));
			tirages2.add(myrand2.nextPoisson(4));
			tirages3.add(myrand2.nextBernouli(.5));
		}
		//System.out.println("Geom:"+tirages1);
		System.out.println("Poisson:"+tirages2);
		System.out.println("Bernoulli:"+tirages3);

	}

}
