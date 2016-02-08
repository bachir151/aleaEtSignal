package aleat.tpA;
import  aleat.*;

import java.util.ArrayList;
import java.util.Random;

public class Frequence {

	public static void main(String[] args) {

		/*
		 * De nouveau on crée un objet de type Random() (on dit aussi
		 * "appartenant à la classe Random")
		 */
		Random rand = new Random();

		/*
		 * On crée un pointeur auquel on affecte une "ArrayList" :
		 */
		ArrayList<Integer> occurences = new ArrayList<Integer>();

		/*
		 * Je remplis mon tableau avec 10 zeros consécutifs. Remarquez au
		 * passage la syntaxe de la boucle 'for'
		 */

		int taille = 10;
		for (int i = 0; i < taille; i++) {
			occurences.add(0);
		}

		/*
		 * Affichons ce tableau
		 */
		System.out.println(occurences);

		/**
		 * Analysez la suite
		 */
		int nbTirage = 10000;
		int unEntier;

		for (int i = 0; i < nbTirage; i++) {
			unEntier = rand.nextInt(taille);
			for (int k = 0; k < taille; k++) {
				if (unEntier == k) {
					/*
					 * incrémentation de la k-ième valeur du tableau. Remarquez
					 * l'utilisation de get() et set()
					 */
					int old = occurences.get(k);
					occurences.set(k, old + 1);
				}
			}
		}

		/*
		 * Affichons ce tableau de nouveau
		 */
		System.out.println(occurences);


			double m = 0.;
			for (int j = 0; j < taille; j++) {
				m = m + j * occurences.get(j);
			}
			System.out.println("la moyenne est :" + m / 10000.);



	}

}
