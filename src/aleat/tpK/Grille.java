package aleat.tpK;

//import aleat.tpD.MultiPlotGrille;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bachir on 15/12/15.
 */
public class Grille {

   private ArrayList<Double> pi = new ArrayList<Double>();
   private int dim;
   private int [][] content ;
   Random rand = new Random();

   public Grille(int dim) {
      this.dim=dim;
      this.content= new int [dim][dim];
      for (int i = 0; i < dim; i++)
         for (int j = 0; j < dim; j++)
            this.content[i][j] = 2 * rand.nextInt(2) - 1;
   }
   public int Hamiltonien (int a ,int b){
      int Hamiltonien [] [] = new int [dim][dim];
      for (int i = 0; i < dim; i++) {
         for (int j = 0; j < dim; j++) {
            int voisin1 = content[(i - 1+dim) % dim][j];
            int voisin2 = content[i][(j - 1+dim) % dim];
            int voisin3 = content[(i + 1+dim) % dim][j];
            int voisin4 = content[i][(j + 1+dim) % dim];
            Hamiltonien[i][j] =( content[i][j]) * (+voisin1 + voisin2 + voisin3 + voisin4);
         }
      }
      return Hamiltonien[a][b];
   }

   public int getDim(){return dim ;}
   public int [][] getContent(){
      return content;
   }
public void simulGrilleParMcmc (double beta,int nbSimulation){

 for (int i=0;i<nbSimulation;i++) {
    int ia = rand.nextInt(dim);
    int ib = rand.nextInt(dim);
    double pi = (double) Math.exp(-beta * Hamiltonien(ia, ib));
    double choix = rand.nextDouble();
    if (choix < pi) {
       content[ia][ib] = -content[ia][ib];
    }

 }
}


   public   ArrayList  afficheligne(int m [][] ,int l,int dim){
      ArrayList<Double> ligne  = new ArrayList<Double>();
         for (int j=0;j<dim;j++){
            ligne.add((double)m[l][j]);
         }
      return ligne ;
   }





   public static void main(String[] args) {
    int dim =4;
      Grille P =new Grille(dim);

     // Grille P =new Grille(dim);

     /*for (int i =0;i<dim;i++) {
        System.out.println(P.afficheligne(P.content, i, dim));
     }
      System.out.println("*********************");*/
     /* for (int k=0;k<1;k++){
         System.out.print((double)Math.exp(-0.05*P.Hamiltonien(2, 1)));
      //P.simulation(1.5);
      }*/
      for (int i =0;i<dim;i++) {
         System.out.println(P.afficheligne(P.content, i, dim));
      }


   }
}
