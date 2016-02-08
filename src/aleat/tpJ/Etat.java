package aleat.tpJ;

import java.util.ArrayList;
import java.util.Random;

public class Etat {

	// public String nom;
	public ArrayList<Fleche> sorties = new ArrayList<Fleche>();
	public ArrayList<Integer> pos = new ArrayList<Integer>();
	public int Id;
	Random rand =new Random();

	public Etat(int Id) {
		this.Id = Id;
	}
	public Etat(double nbville,int b) {
		for (int i =0;i<nbville;i++){
			pos.add(0);
		}
	}
	public double poidsTotal() {
		double res = 0;
		for (Fleche fle : sorties) {
			res += fle.poids;
		}
		return res;
	}
	/*public ArrayList<Integer>  position( int nbville){
		for (int i =0;i<nbville;i++){
			pos.set(i, rand.nextInt(10));
			pos.set(i, rand.nextInt(10));
		}
		return pos;
	}*/

	@Override
	public String toString() {
		return "Etat " + Id + ", sorties=" + sorties;
	}

}
