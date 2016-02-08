package signal;

/**
 * Created by bachir on 31/01/16.
 */
public class xnExpX extends Fonction  {
   private double x ;
   private double n ;

   public xnExpX(double n){this.n=n;}

   public double Eval(double x){return Math.pow(x,n) * Math.exp(-x)  ;}


   public static void main(String [] args){
      for (int i=0;i<6 ;i++){
      Fonction fa =new xnExpX(i);
      //Fonction  fb =new xnExpX(0.);
      //System.out.println(fa.Eval( -1));
      //System.out.println(exp.Eval(-1));
      System.out.println("Pour n ="+i +" , I = " + fa.Integrale(-1, 1));}
      //System.out.println(sca(fa, fb));
   }


}
