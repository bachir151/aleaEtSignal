package aleat.tpH;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vigon on 16/11/2015.
 */
public class IdentityColored implements PlotableColored{

    private ArrayList<Double> Xs=new ArrayList<Double>();
    private ArrayList<Double> Ys=new ArrayList<Double>();
    private ArrayList<Double> colors=new ArrayList<Double>();
    public Random rand = new Random();

    public IdentityColored(){
        //Xs.add(1.);
        //Ys.add(1.);
        double pas =0.001;
        for (int i=0;i<10000;i++){
           // Xs.add(i*1.);
            if (i==0){
                Xs.add(i,0.);
                Ys.add(i,0.);
            }
            else {
                double deltaX = pas + Xs.get(i-1) * Math.sqrt(pas)
                       * rand.nextGaussian();
                //Xs.add(pas+Xs.get(i-1) + Math.sqrt(pas) * rand.nextGaussian() );
                Xs.add(Xs.get(i-1) + deltaX);
                double deltaY = pas + Xs.get(i-1) * Math.sqrt(pas)
                       * rand.nextGaussian();

                Ys.add(Ys.get(i-1) + deltaY);

                //Ys.add(pas+Ys.get(i-1) + Math.sqrt(pas) * rand.nextGaussian() );
            }
           // Ys.add(Math.sin(Xs.get(i)));
           // Ys.add(i*1.);
            if (i<10000/2) {
                colors.add( -150.);
            }
            else {
                colors.add( i*1./8);
            }
        }

    }

    @Override
    public List<Double> colors() {
        return colors;
    }

    @Override
    public List<Double> getXs() {
        return Xs;
    }

    @Override
    public List<Double> getYs() {
        return Ys;
    }

}
