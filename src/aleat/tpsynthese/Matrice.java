package aleat.tpsynthese;

/**
 * Created by bachir on 19/01/16.
 */
public class Matrice {

   public double [][] matrice ;

   public Matrice ( int dim ){
      matrice = new double [dim][dim];
   }

   // return C = A * B
   public double [][] multiply(double[][] A) {
      int mA = A.length;
      int nA = A[0].length;
      int mB = matrice.length;
      int nB = matrice[0].length;
      if (nA != mB) {System.out.println("dim invalide");}
     // double[][] C = new double[mA][nB];
      for (int i = 0; i < mA; i++)
         for (int j = 0; j < nB; j++)
            for (int k = 0; k < nA; k++)
              this.matrice[i][j] += A[i][k] * this.matrice[k][j];
      return this.matrice;
   }

   public static void main(String[] args) {


   }
}
