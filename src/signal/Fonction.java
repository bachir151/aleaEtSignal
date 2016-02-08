package signal;

/**
 * Created by bachir on 31/01/16.
 */
abstract class  Fonction {
   public double Integrale (double a, double b ){
      double n =2000;
      double h =(b-a)/n;
      double Int =0. ;
      for (int i=0;i<n;i++){
         Int=Int + h*Eval(a + i * h);
      }
      return Int ;
   }
   abstract  double Eval(double x);

  public static   double  sca (Fonction fa ,Fonction fb){
      double n =2000;
      double h =2/n;
      double Inte =0. ;
      for (int i=0;i<n;i++){
         Inte=Inte + h*fa.Eval(-1 + i * h)*fb.Eval(-1 + i * h);
      }
      return h*Inte ;
   }
}
