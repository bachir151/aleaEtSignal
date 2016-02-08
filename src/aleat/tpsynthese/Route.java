package aleat.tpsynthese;



import java.util.ArrayList;
import java.util.List;


public class Route implements Plotable{

    Ville arr;
    Ville dep;
//    Ville getDep(Monde monde){
//        for (Ville ville :monde.villes){
//            for (Route route:ville.routes){
//                if (route==this) return ville;
//            }
//        }
//        return  null;
//    }

    public Route(Ville dep,Ville arr){
        this.arr=arr;
        this.dep=dep;
    }

    @Override
    public String toString() {
        return "->" + arr.id;

    }

    @Override
    public List<Double> getXs() {
        ArrayList<Double> res=new ArrayList<Double>();
        res.add(this.dep.x);
        res.add(this.arr.x);
        return res;
    }

    @Override
    public List<Double> getYs() {
        ArrayList<Double> res=new ArrayList<Double>();
        res.add(this.dep.y);
        res.add(this.arr.y);
        return res;    }
}
