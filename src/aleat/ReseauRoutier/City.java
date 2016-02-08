package aleat.ReseauRoutier;
import java.util.*;

/**
 * Created by bachir on 19/01/16.
 */
public class City {
   public Random rand =new Random();
   public int dep ;
   public int arr;
   public double posX ;
   public double posY ;

   public int id ;
   public City(int id){
      this.id=id;
      this.dep=id;
      this.arr=0;
      this.posX=2*rand.nextDouble()-1;
      this.posY=2*rand.nextDouble()-1;
   }


   public int getCityId(){
      return id ;
   }


   public static void main(String[] args) {


   }

}
