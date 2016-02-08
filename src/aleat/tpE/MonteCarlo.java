package aleat.tpE;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import aleat.tpB.MyRandom;import aleat.tpB.MyRandom;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by bachir on 02/11/15.
 */
public class MonteCarlo extends JFrame {
   private int taille = 300;
   private int saturation = 100000;
   public MonteCarlo() {
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
         for (int i = 0; i < saturation; i++) {
            x=rand.nextUnif(0.,4.);
            y=rand.nextUnif(0.,4.);
            //if (Math.pow(y,2)+Math.pow(x,2)<2 && Math.pow(y,2)>=x && 2-x>=y)
            if (x*x+y*y<2 && y*y>=x && sqrt(2)-x>=y)
            {
               y=y*300; //Pour agrandir le dessin 300x
               x=x*300;
               g.fillRect((int)x, (int)y, 5, 5);
            }
         }
      }
   }
   public static double sqrt(double x){
      return Math.sqrt(x);
   }
   public static void main(String[] args) {
      new MonteCarlo();
      System.out.println(sqrt(2));
   }
}
