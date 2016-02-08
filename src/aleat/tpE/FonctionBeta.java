package aleat.tpE;

import java.util.ArrayList;
import aleat.tpD.Plotable;
import aleat.tpE.Gamma;

public class FonctionBeta implements Plotable {

	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	/**loi gamma**/
	static double logGamma(double x) {
		double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
		double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
				 + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
				 +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
		return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
	}

	static double gamma(double x) { return Math.exp(logGamma(x)); }

	/***fonction beta***/

	public FonctionBeta (double taille ,double a ,double  b,double gauche ,double droite){
		double B= gamma(a + b)/gamma(a)*gamma(b);
		for (int i=0;i<taille;i++){
			xs.add(i,gauche+(droite-gauche)/taille*i);
			ys.add(i,(B/1.75)*(Math.pow(xs.get(i),a-1)*Math.pow(1-xs.get(i),b-1)));
			
		}
	}
	public ArrayList<Double> getXs() {
		return xs;
	}

	public ArrayList<Double> getYs() {
		return ys;
	}

	/**le main**/
	public static void main(String[] args) {
	 ArrayList<Double> x = new ArrayList<Double>();
	 ArrayList<Double> y= new ArrayList<Double>();
	double gauche=0;
	double droite =1;
	int a =3;
	int b=3;
	double taille=10;
	for (int i=0;i<taille;i++){
		x.add(i,gauche+(droite-gauche)/taille*i);
		y.add(i,Math.pow(x.get(i),a-1)*Math.pow(1-x.get(i),b-1));
	}

	//System.out.println(x);
	//System.out.println(y);
	System.out.println(fact(6)/fact(3)*fact(3));
	}

	//factorielle
	public static double fact(double n) {
		int resultat=1;
		if (n==0){
			resultat=1;
		}
		else {
			for (int i=1;i<=n;i++){
			resultat=resultat*i;
		}
		}
		return resultat ;
	}


}
