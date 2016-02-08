package aleat.tpE;

import java.awt.Graphics;
//import java.util.Random;
import aleat.tpB.MyRandom;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PointsAire extends JFrame {

	private int taille = 300;
	private int nbPoints = 100000;

	public PointsAire() {

		this.setSize(taille, taille);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new Panneau());
		this.setVisible(true);
	}

	public class Panneau extends JPanel {

		public void paintComponent(Graphics g) {

			MyRandom rand = new MyRandom();
			double x = 0;
			double y = 0;
			for (int i = 0; i < nbPoints; i++) {
				x=rand.nextUnif(-2.,2.);
				y=rand.nextUnif(-2.,2.);
				if (Math.pow(y,2)+Math.pow(x,2)<2 && x>0 && y>0  && Math.pow(y,2)>=x && Math.sqrt(2)-x>=y)
				{
					y=y*300;
					x=x*300;
				g.fillRect((int)x, (int)y, 10, 10);
				}
			}
		}
	}
	
	

	public static void main(String[] args) {
		MyRandom rand = new MyRandom();
		double x=0;
		double y=0;
		int nbPoints = 500000;
		int N=0;
		for (int i = 0; i < nbPoints; i++) {
			//abscisse et ordonn�e des points tir�s au hasard dans le rectangle
			x=rand.nextUnif(0.,Math.sqrt(2));
			y=rand.nextUnif(0.,Math.sqrt(2));
			//On v�rifie si ces points appartiennent  A
			if (Math.pow(y,2)+Math.pow(x,2)<2 && x>0 && y>0 && Math.pow(y,2)>x && Math.sqrt(2)-x>y)
			{
				//On compte le nombre de points appartenant  A
				N=N+1;
			}
	}
		double aire=(((double)N/nbPoints)*Math.sqrt(2)*Math.sqrt(2));//calcul de l'aire
		System.out.println("Aire="+ aire);
	//	new PointsAire();
	
}
}
