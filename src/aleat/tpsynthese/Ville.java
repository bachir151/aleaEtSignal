package aleat.tpsynthese;

import java.util.ArrayList;

public class Ville {

    int id;

    double x;
    double y;

    ArrayList<Route> routes=new ArrayList<Route>();

    public Ville (int id){
        this.id=id;
    }


    @Override
    public String toString() {
        return "v:" + id +
                ",routes=" + routes+"\n";

    }


}
