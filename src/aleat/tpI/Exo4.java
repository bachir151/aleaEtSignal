package aleat.tpI;
import java.util.ArrayList;
import java.util.Random;
import aleat.tpB.MyFirstRandom;
public class Exo4 implements VariableAleatoire {
	private ArrayList<Double> Xs = new ArrayList<Double>();
	Random rand = new Random();
	MyFirstRandom rand2=new MyFirstRandom();
    int n ;
    
	public Exo4 (int n) {
		this.n=n;
	}

	public double nextSimulation(){
		double x =0;
		double somme =0;
		for (int i=0; i<n;i++){
			x=rand2.nextUnif(1,-1);
			somme=somme+Math.pow(x, 2);
		}
		return Math.sqrt(somme)/(Math.pow(0.5,n)); // sqrt(x_1^2 +....x_n^2)
	}
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayList<Double> Xs = new ArrayList<Double>();
		int n=5;
		double x =0;
		double somme =0;
		for (int i=0; i<n;i++){
			x=2*rand.nextDouble()-1;
		Xs.add(Math.pow(x,2));
		somme=somme+Xs.get(i);
		}
		System.out.println(somme);
		System.out.println(Xs);
		
	}

}