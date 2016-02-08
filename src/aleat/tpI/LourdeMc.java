package aleat.tpI;
import java.util.Random;
import aleat.tpF.MethodeInv;
/**
 * Created by bachir on 30/11/15.
 */
public class LourdeMc implements VariableAleatoire {
   Random rand = new Random();
   double alpha;
   //public double n ;
   MethodeInv f =new MethodeInv();
   public LourdeMc (double alpha) {
      this.alpha=alpha;
   }
   public double nextSimulation() {
     // double U =rand.nextDouble();
      double U=f.InvH();
      /*//double bernouli=rand.nextDouble();
      double Inverse=(Math.pow(1-U, 1/(1-alpha)))-1;
         return Inverse*Inverse;*/
      return (Math.exp(1)-1)*( U*U* Math.exp(U*U)/Math.exp(U));
   }
}
