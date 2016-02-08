package aleat.tpA;

/**
 * Created by bachir on 22/10/15.
 */
public class Dichotomie {


   public static void dico (){
      double m=0;
      double a =1;
      double b=2;
      int i=0;
      while(b-a>0.001){
         m=0.5*(a+b);
         if (Math.pow(m,3)<5){
            a=m;}
         else {
            b=m;}
         System.out.println("Etape"+(i+1) +":"+"a="+a
         +","+"b="+b+","+"m="+m);
         System.out.println("___________________________________________");
         //System.out.println(a);
         i++;
         //System.out.println(m);
      }
      System.out.println(b-a);
   }
   public static double f(double x){
      return Math.pow(x,3)+2*x-8;
   }

   public static double dico( double h){
      int i =0;
      double a ;
      double x ;
      a=1;
      x=a;
   while(f(a)*f(x)>0){
   x=x+h;
      i++;
  }
      System.out.println(i);
      return x;
   }
public static void main(String args[]){
  System.out.println( dico(0.1));
   //System.out.println(f(1.6800006));

}
}
