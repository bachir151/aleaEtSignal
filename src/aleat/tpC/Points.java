package aleat.tpC;
import aleat.tpB.MyRandom;
import java.awt.Graphics;
import java.util.Random;
import aleat.tpH.*;
import java.util.Random;
import java.util.ArrayList;
import aleat.tpJ.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Points extends JFrame {

	private int taille = 50;
	private int nbVilles = 50;

	public Points() {

		this.setSize(taille, taille);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new Panneau());
		this.setVisible(true);
	}

	public class Panneau extends JPanel {

		public void paintComponent(Graphics g) {

		/*	Random rand = new Random();
			MyRandom myrand= new MyRandom();
			int x = 0;
			int y = 0;
			int z=0;
			int t =0;
			int a =this.getWidth();
			int b =this.getHeight();
			Etat E =new Etat(1);
			nbVilles= myrand.nextPoisson(this.getWidth()*this.getHeight());
			Graphe G =new Graphe(nbVilles);
				for (int j = 0; j < G.Nbetats;j ++) {
					int villeA = rand.nextInt(nbVilles);
					int villeB = rand.nextInt(nbVilles);
					double poids = (double) rand.nextInt(10);
					G.ajouteFleche(villeA, villeB, poids);
				}
			 int e=0;

			E.position(nbVilles);
			System.out.println(E.pos);
			 for (Etat etat : G.etats) {
							for (Fleche f : etat.sorties) {
								if (f.poids < 2) {
									//g.fillRect(x, y, 1, 1);
									System.out.println(etat.pos.get(etat.Id));
									System.out.println(f.arrivee.pos.get(etat.Id));
									//System.out.println(etat.Id);

									//g.drawLine(etat.pos.get(e), etat.pos.get(e), f.arrivee.pos.get(e), f.arrivee.pos.get(e));
								}
							}
						}*/

			for (int i = 0; i < nbVilles; i++) {
				/*x = rand.nextInt(this.getWidth());
				y = rand.nextInt(this.getHeight());
				z= rand.nextInt(this.getWidth());
				t= rand.nextInt(this.getHeight());
				System.out.println("taille: " + x + "*" + y);
				g.fillRect(x, y, 1, 1);
				g.drawLine(x, y,z, t);*/
			}
		}
	}

	public static void main(String[] args) {

		new Points();


	}


}
