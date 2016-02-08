package aleat.ReseauRoutier;

/**
 * Created by bachir on 19/01/16.
 */
public class Roadbach {
   public int dep ;
   public int arr;
   public int id ;
   public int poids ;
   public  double [] route ;
   public Roadbach(City A  ,City B ,int poids ){
      dep=A.dep;
      arr= B.dep;
      this.poids=poids;
   }


   public int  getRoute(){
      return id ;
   }

}
