package aleat.tpD;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Nous étendons la classe JFrame = une fenêtre visible défini par notre système d' exploitation.
 * Dans une telle fenêtre on peut empiler des JPanel = des panneaux. 
 * Ici nous ne mettrons qu' un seul panneau : Panneau qui étend JPanel.
 *  Dans notre panneau nous dessinerons une ligne brisée à l' aide de la méthode
 *  paintComponent : c' est une méthode qui se lance automatiquement au moment opportun.
 *  Cette méthode n'a qu' un seul argument : un objet de type Graphics qui va absorber tous les
 *  éléments graphiques.
 */

public class Traceur1 extends JFrame {

	/*
	 * Constructeur : on spécifie les propriété et le contenu de la fenêtre.
	 */
	public Traceur1() {
		this.setSize(300, 200); // taille
		this.setLocation(0, 0); // position du coin nord-est
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on ferme
																// l'application
																// quand on
																// ferme la
																// fenêtre
		this.setContentPane(new Panneau()); // le panneau contenu dans cette
											// fenêtre.
		this.setVisible(true);// la fenêtre est visible sur notre écran.
	}

	/*
	 * Notre panneau
	 */
	private class Panneau extends JPanel {

		public void paintComponent(Graphics g) {

			int[] x = { 10, 20, 30, 40 };// les abscisses
			int[] y = { 40, 60, 10, 100 };// les ordonnées
			g.drawPolyline(x, y, 4); // l'objet graphique mémorise la ligne
										// brisée.
		}
	}

	/**
	 * En modifiant ce programme, découvrez comment sont placés les axes dans le
	 * système JAVA: c'est un système très répandu en informatique qui diffère
	 * de la convention mathématique usuelle.
	 */
	public static void main(String[] args) {
		new Traceur1();
	}

}