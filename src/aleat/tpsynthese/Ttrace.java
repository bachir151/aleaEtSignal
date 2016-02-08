package aleat.tpsynthese;

import java.util.ArrayList;

/**
 * Created by bachir on 20/01/16.
 */
public class Ttrace implements Plotable {
   private ArrayList<Double> xs  = new ArrayList<Double>();
   private ArrayList<Double> ys  = new ArrayList<Double>();

   public Ttrace(double xa ,double ya ,double xb, double yb){
      xs.add(xa);
      xs.add(xb);
      xs.add(ya);
      xs.add(yb);

   }

   public ArrayList<Double> getXs(){
      return xs;
   }

   public ArrayList<Double> getYs(){
      return ys;
   }

}
