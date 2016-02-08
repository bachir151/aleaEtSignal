package signal;

import com.sun.xml.internal.ws.transport.http.DeploymentDescriptorParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import aleat.tpsynthese.*;
import aleat.tpsynthese.*;
/**
 * Created by bachir on 26/01/16.
 */
public class Polynome extends Fonction implements Plotable  {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();

   private ArrayList <Double>  coef =  new ArrayList <Double> ();
   private int degre ;


   public Polynome ( ArrayList coef ){
      this.coef =coef ;
      this.degre=coef.size()-1 ;
   }
   public Polynome (){
      ArrayList<Double> c =new ArrayList<>();
      this.coef =c ;
      this.degre=coef.size()-1 ;
   }
   public Polynome (int size){
      ArrayList<Double> c =new ArrayList<>();
      for (int i =0 ;i <size;i++){c.add(0.);}
      this.coef =c ;
      this.degre=coef.size()-1 ;
   }

   public static  Polynome derivee ( Polynome P){
      P.degre= P.degre-1;
      ArrayList <Double> copie =new ArrayList<Double>();
      for (int i=0;i<P.coef.size()-1;i++){
         {copie.add(i,P.coef.get(i+1)*(i+1));}
      }
     // copie.add(0.);
      P.coef =copie ;

      return P ;
   }

   public static Polynome additionne(Polynome Pa ,Polynome Pb){
       if (Pa.degre > Pb.degre){
          for (int i =0 ;i< Pb.coef.size();i++){
          Pa.coef.set(i,Pa.coef.get(i)+Pb.coef.get(i));
          }
          return Pa;
       }
      else {
          for (int i = 0; i < Pa.coef.size(); i++) {
             Pb.coef.set(i, Pb.coef.get(i) + Pa.coef.get(i));
          }
          return Pb ;
       }

   }

   public static Polynome multiplication (Polynome p ,Polynome q){
      Polynome resultat=new Polynome();
      for (int k=0 ; k<q.coef.size()+p.coef.size()-1 ;k++ ){
         resultat.coef.add(0.);
      }

      for(int i=0;i<q.coef.size();i++)
         for(int j=0;j<p.coef.size();j++)
            resultat.coef.set(i+j,resultat.coef.get(i+j)
                   +q.coef.get(i)*p.coef.get(j));

      return resultat;

   }
   public static Polynome multiplieParX(Polynome P){
      P.degre= P.degre +1;
      ArrayList <Double> copie =new ArrayList<Double>();

      for (int i=0;i<=P.coef.size();i++){
         if (i==0){copie.add(0.);}
         else {copie.add(i,P.coef.get(i-1));}
      }
      P.coef =copie ;

      return P ;
   }
   public void  toFonction(double gauche ,double droite ,double taille) {
      double v = 0.;
      int i=0;
      for (int j = 0; j < taille; j++) {
         xs.add(j, gauche + (droite - gauche) / taille * j);
         v = Eval(xs.get(j));
         for ( i = 1; i < coef.size(); i++) {

              // v = v + coef.get(i) * Math.pow(xs.get(j), i);

         }
         ys.add(v);
        //v = 0.;
      }
   }

   public double IntegralPrim (double a , double b){
     ArrayList<Double>  coefPrimitive = new ArrayList<>();
      coefPrimitive.add(0.) ;
      for (int i =0 ;i<coef.size();i++) {
         coefPrimitive.add(coef.get(i)/(i+1));
      }
      Polynome P = new Polynome(coefPrimitive);
      double integrale = P.Eval(b)-P.Eval(a);
      return integrale ;
   }


   public double Eval (double x){
      double anX=coef.get(coef.size()-1)*x; // an*X
      double sum=0.;
      for (int i= coef.size()-2 ;i>=0;i--){  //a0+X(a 1 + X(a2 + X(a3 + ... + X(an−2 + X(an−1 + anX)
         sum=anX+coef.get(i);
         anX=sum*x;
      }
      return sum ;
   }
   public static double scalaire ( Polynome Pa ,Polynome Pb ){
      Polynome P= new Polynome();
      P.coef = multiplication(Pb, Pa).coef ;
      return P.IntegralPrim(-1, 1);
   }

   static Polynome Xpow(double n){
      Polynome P=new Polynome();

         for (int i = 0; i < n + 1; i++) {
            if (i != n)
               P.coef.add(i, 0.);
            else
               P.coef.add(i, 1.);
         }

      return P;
   }
   public static void  afficheMatrice (double [][] m){
    for (int j= 0; j< m.length; j++) {
       for (int i= 0 ;i<m.length ;i++) {
          System.out.format("%.1f", m[j][i]);
          System.out.print("  ");
       }
       System.out.println("");
    }

   }
   public static double Norme (Polynome P){
      return Math.sqrt(scalaire(P, P));
   }
   public Polynome multiplycste (double c ){

      for (int i =0 ;i < coef.size();i++){
         coef.set(i, c * coef.get(i));
      }
      return  (new Polynome (coef)) ;
   }

   public static ArrayList<Polynome> GramSmid  (ArrayList<Polynome> V){
      ArrayList<Polynome> W =new ArrayList<>();
      W.add(0, V.get(0).multiplycste(1 / Norme(V.get(0))));
      System.out.println("w"+0+"=" + V.get(0).coef);
    // V.get(0).coef.set(0, 0.70716);
     // W.add(V.get(0));
      //System.out.println("or coef 0 =" + W.get(0).coef);
     // or.add(0, Base.get(0).multiplycste(1 / Norme(Base.get(0))));
      for ( int i=1; i< V.size() ; i++){
            Polynome p2 =new Polynome(W.get(0).coef.size()); // 0 0 0 0
            for ( int j=0; j<i ; j++){
               Polynome p = new Polynome(W.get(j).coef); // W0
               p = p.multiplycste(-scalaire(V.get(i), W.get(j))) ; // <v1 ,W0>W0
               p2 = additionne(p2,p);

            }
         W.add(i, additionne(V.get(i), p2)) ;
         W.set(i, W.get(i).multiplycste(1 / Norme(W.get(i))));

         System.out.println("w"+i +"= " + W.get(1).coef);
      }

     return W ;
   }
  public static ArrayList<Polynome> GramSchmit(ArrayList<Polynome> base){
     ArrayList<Polynome> gram= new ArrayList<>();
     double c= 1./Norme(base.get(0));
     gram.add(base.get(0).multiplycste(c) );
     for (int i=1;i<base.size();i++)
     {
        ArrayList<Double> co = new ArrayList<>();
        double norme=0.0;
        co.add(0.0);
        Polynome sous = new Polynome(co);
        for (int j=i-1;j>=0;j--){
           sous=additionne(sous, gram.get(j).multiplycste(scalaire(base.get(i), gram.get(j))));
        }
        norme= Norme((additionne(base.get(i), sous.multiplycste(-
               1.0))));
        gram.add((additionne(base.get(i), sous.multiplycste(-
               1.0))).multiplycste(1 / norme));
     }
     return gram;
  }

   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }
   public static Polynome PolyLegendre (double n){
      ArrayList<Double> coef0 = new ArrayList<>();
      ArrayList<Double> coef1 = new ArrayList<>();
      coef0.add(1.);
      coef1.add(0.); coef1.add(1.);
      Polynome P0=new Polynome (coef0);
      Polynome P1=new Polynome (coef1);
      double a =(2*(n-1)+1)/n;
      double b=(n-1)/n;
      if (n==0){
         return P0;
      }
      if (n==1){
         return P1;
      }
      else
         return additionne(multiplieParX(PolyLegendre(n - 1).multiplycste(a)), PolyLegendre(n - 2).multiplycste(-1.* b));

   }




   public static void main (String[] args ){

      ArrayList<Double> pa= new ArrayList<Double>();
      //pa.add(0.) ; pa.add(0.) ;pa.add(0.) ;pa.add(1.); //pa.add(1.);// x^3
      pa.add(1.) ; pa.add(-1.); pa.add(0.) ; pa.add(1.) ; //1-x+x^3
      //pa.add(1.) ; pa.add(-1.) ;pa.add(0.) ;pa.add(0.) ;pa.add(2.) ;
      ArrayList<Double> pb= new ArrayList<Double>();
     // pb.add(0.) ;  pb.add(1.) ;pb.add(-1.); // x-x^2
      pb.add(1.) ;  pb.add(-1.) ;pb.add(0.);pb.add(0.) ; pb.add(2.) ; //pb.add(2.); // 1-x+2x^4
      //pb.add(0.) ; pb.add(0.) ; pb.add(0.) ;  pb.add(1.) ;
      Polynome Pa= new Polynome(pa);
      Polynome Pb = new Polynome(pb);

      MultiPlot multi = new MultiPlot();
      Polynome P = new Polynome();
     /* for (int i =0 ;i <20 ;i++){
      P= PolyLegendre(i);
         System.out.println(P.coef) ;
      P.toFonction(-1, 1, 500); // sur [-1,1]
      multi.addPlotable("Poly"+i, P);
      }*/
     //multi.plotNow();

      /***Multiplyscste****/
      //System.out.println(Pa.multiplycste(2).coef);
      /***Xpow***/
      // System.out.println(multiplication(Xpow(3),Xpow(2)).coef);
       // System.out.println("prod scalaire = "+scalaire(Pa,Pb));
      /*****Coefficient***/
      //System.out.println(Pb.coef);
      /***Multiplication***/
       //System.out.println( "Résultat =" + multiplication(Pa,Pb).coef);
      /***Horner***/
       //System.out.println("Résulat =" +Pa.Eval(0.5));
      /***Integrale****/
      // System.out.println("Intégrale Primitive  =" + Pb.IntegralPrim(-1.,1.));
       //System.out.println(" Intégrale Rectangle  =" +Pb.Integrale(-1.,1.));
      /***derivée***/
      //System.out.println( "Dérivée= " + derivee(Pb).coef);
      /****Addition***/
      //System.out.println("Somme= " +additionne(Pa,Pb).coef);
      /****Multiplie par X***/
      //System.out.println( "Résultat = " +multiplieParX(Pb).coef) ;

      ArrayList<Double> xu = new ArrayList<Double>();
      xu.add(1.);
      ArrayList<Double> xd = new ArrayList<Double>();
      xd.add(0.) ;xd.add(1.);
      ArrayList<Double> xt = new ArrayList<Double>();
      xt.add(0.) ;xt.add(0.);xt.add(1.);
      ArrayList<Double> xtt = new ArrayList<Double>();
      xtt.add(0.) ;xtt.add(0.);xtt.add(0.) ;xtt.add(1.);

      Polynome Pxu= new Polynome(xu);
      Polynome Pxd= new Polynome(xd);
      Polynome Pxt= new Polynome(xt);
      Polynome Pxtt= new Polynome(xtt);
      ArrayList<Polynome> Base = new ArrayList<>();
      ArrayList<Polynome> W = new ArrayList<>();
      Base.add(Pxu);
      Base.add(Pxd);
      Base.add(Pxt);
      //  System.out.println("Norme = " + 1/Norme(Pxu));
      //System.out.println(Base.get(0).coef);
      //System.out.println("coef norma = " +Base.get(0).multiplycste(1. / Norme(Base.get(0))).coef);
      //System.out.println(Base.get(0).coef);
     // W=GramSmid(Base);
     // W=GramSchmit(Base);
     // System.out.println(W.get(0).coef);

      //System.out.println(scalaire(PolyLegendre(3), PolyLegendre(3)));





      int n = 5;
      double [][] prodscalMonome = new double [n][n];
      for (int i=0 ;i<n ;i++){
         for (int j=0 ;j<n ;j++){
               double  normei = 1/Norme(PolyLegendre(i)) ;
                double  normej = 1/Norme(PolyLegendre(j)) ;

               prodscalMonome [i][j] = scalaire(PolyLegendre(i).multiplycste(normei),PolyLegendre(j).multiplycste(normej));

         }
      }
      //double [] p = new double [pb.size()];
      afficheMatrice(prodscalMonome);



     // System.out.println(W.get(0).coef);
     // System.out.println(W.get(1).coef);
     // System.out.println(W.get(2).coef);

      //System.out.println(GramSmid(Base).get(0).coef);

     // Fonction Pa= new Polynome(pa);
     // Fonction Pb = new Polynome(pb);
      // System.out.println(scalaire(Pb, Pa));

      // System.out.println(sca(Pb, Pa));
      /*double [][] prodscalMonome = new double [pa.size()][pb.size()];
      for (int i=0 ;i<pa.size() ;i++){
         for (int j=0 ;j<pb.size() ;j++){
            prodscalMonome [i][j] = scalaire(Xpow(i),Xpow(j));
         }
      }*/
     /* int n =3 ;
      double [][] prodscalMonome = new double [n][n];
      for (int i=0 ;i<n ;i++){
         for (int j=0 ;j<n ;j++){
            if ( i==j)
            prodscalMonome [i][j] = 1.0;
            else
               prodscalMonome [i][j] = 0.0;

         }
      }*/
      //double [] p = new double [pb.size()];
      ///afficheMatrice(prodscalMonome);
      double s =0.;
     /* for (int j=0 ;j<pb.size() ;j++){
         for (int i=0 ;i<pa.size() ;i++) {
            s = s + pa.get(i) * prodscalMonome[i][j] ;
         }
         p[j]=s;
      }*/

     /* double f=0.;
      for (int k=0 ;k<pb.size() ;k++){
         f=f+p[k]*pb.get(k);
      }*/
      //System.out.println(f);
     // afficheMatrice(prodscalMonome);
     // System.out.println("long= "+prodscalMonome.length);
     /* for (int i=0 ;i <p.length;i++){
      //System.out.println(p[i]);
         //System.out.print(" ");
         }*/




   }
}
