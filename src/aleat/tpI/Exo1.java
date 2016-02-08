package aleat.tpI;
import java.util.Random;
import aleat.tpB.MyFirstRandom;

public class Exo1 implements VariableAleatoire {
	Random rand = new Random();
	MyFirstRandom rand2 =new MyFirstRandom();
	public double nextSimulation(){
		//double x =rand.nextDouble();
		double x=rand2.nextUnif(0,1);
		//double y=2*rand.nextDouble()-1;
		double y=rand2.nextUnif(0,2);
		double f_z= 1./2.; //densité de z
		double phi= Math.pow(x, 2)*(Math.pow(y-x, 3)); // %
		//double phi=x*x+y*y;
		double z=phi/f_z;
		return phi/f_z  ;
	}
}
