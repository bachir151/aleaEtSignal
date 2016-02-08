package aleat.tpB;

/**
 * Created by bachir on 03/10/15.
 */
public class Individu {
   public static int nbIndividu=0;
   public int age=0;
   public double taille =0;
   public Individu(int age,double taille){
      this.age=age;
      this.taille=taille;
      nbIndividu++;
   }

   public static void main(String[] args){
      Individu i1=new Individu(2,4);
      Individu i2=new Individu(3,6);
      Individu i3=new Individu(4,8);

      System.out.println("nbIndividu pour i1="+i1.nbIndividu);
      System.out.println("nbIndividu pour i2="+i2.nbIndividu);
      System.out.println("nbIndividu pour i3="+i3.nbIndividu);
   }
}
