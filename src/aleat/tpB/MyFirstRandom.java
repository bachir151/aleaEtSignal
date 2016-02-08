package aleat.tpB;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.*;
public class MyFirstRandom {

	/*
	 * Un champs privé
	 */
	private Random random;

	/*
	 * Le constructeur
	 */
	public MyFirstRandom() {
		random = new Random();
	}

	/**
	 * Une méthode. Décrivez ce que fait cette méthode
	 */
	public int nextDiscrete(double[] probas) {
		int res = 0;

		double unReel = random.nextDouble();
		double cumul = probas[0];
		while (unReel > cumul) {
			res++;cumul = cumul + probas[res];
		}
		return res;
	}

	public double nextUnif(double gauche, double droite)
     {
		 return gauche + (droite-gauche)*(random.nextDouble()) ;
		 }

	/*
	 * Quand on crée un classe, c'est dans le but de l'utiliser dans un (gros)
	 * programme principal (un programme contenant
	 * "public static void main..."). C'est ce que nous avons fait précédemment.
	 * Cependant, on peut créer des petit "main" à l'interieure de ses classe
	 * pour illustrer leur fonctionnement. Exemple :
	 */
	static void  affiche (Object [] array){
		String crochet1= "[" ;
		String crochet2="]" ;
		for (int i=0;i < array.length-1;i++ ){
			crochet1 += array[i].toString() + " "+"," ;
		}
		crochet1 +=array[array.length-1] + crochet2 ;
		System.out.println(crochet1);
	}

	public static void main(String[] args) {

		MyFirstRandom myRand = new MyFirstRandom();
		double[] probabilites = { 0.005,0.22,0.22,0.22,0.05, 0.11, 0.11,0.11 };

		ArrayList<Integer> desTirages = new ArrayList<Integer>();

		/*for (int i = 0; i < 20; i++) {
			desTirages.add(myRand.nextDiscrete(probabilites));
		}*/

		//System.out.println(desTirages);
		System.out.println(myRand.nextDiscrete(probabilites));
		//System.out.println(myRand.nextUnif(1, 10));
		/*ArrayList <Double> a =new ArrayList<Double>();
		for (int i=0;i<5;i++){
			a.add(i,myRand.nextUnif(5, 10));
		}
		System.out.println(a);
		Integer [] array1 ={1,2,3,4,5,6};
		Double [] array2 = {1.,2.,3.,4.,5.,6.};
		String [] array3= {"un","deux","trois"};
		affiche(array1);
		affiche(array2);
		affiche(array3);*/


	}

	/**
	 * Créez une méthode nextUnif(double gauche, double droite) qui renvoie une
	 * VA réelle uniforme dans l'intervalle gauche droite. Quelle est
	 * l'espérance d'une telle VA ?     
	 */

}
