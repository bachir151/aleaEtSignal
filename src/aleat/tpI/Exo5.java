
package aleat.tpI;
import java.util.ArrayList;
import java.util.Random;

import aleat.tpB.MyRandom;
public class Exo5 implements VariableAleatoire {
	
	private ArrayList<Double> Xs = new ArrayList<Double>();
	Random rand = new Random();
    int n ;
    
	public Exo5 (int n) {
		this.n=n;
	}
	public double nextSimulation(){
		double  x=0;
		double somme =0;
		for (int i=0; i<n;i++){
	      x=rand.nextInt(3)-1;// = {-1,0,1}
		Xs.add(Math.pow(x,2));
		somme=somme+Xs.get(i);
		}
		return Math.pow(3,n)*Math.sqrt(somme);
	}


public static void main(String[] args) {
	
	ArrayList<Double> Xs = new ArrayList<Double>();
	Random rand = new Random();
	double u=rand.nextInt(3)-1 ;
	//System.out.println(u);
	int n=2;
	double  x=0;
	double somme =0;
	for (int i=0; i<n;i++){
      x=rand.nextInt(3)-1;// = {-1,0,1}
	Xs.add(Math.pow(x,2));
	somme=somme+Xs.get(i);
	}
	//System.out.println( (1/Math.pow(3, n))*Math.sqrt(somme));
	System.out.println( x=rand.nextInt(3)-1);
}
}
