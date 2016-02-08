package aleat.tpB;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;


/**
 * Created by vigon on 23/09/2015.
 */
public class u {

    public static void o (Object object){
        System.out.println(object);
    }

    static void  affiche (ArrayList<Integer> array){
        long lS=new Date().getTime();
        String monarray= "[" ;
        for (int i=0;i < array.size()-1;i++ ){
                monarray += array.get(i).toString() + ";";
        }
        monarray +=array.get(array.size()-1)+"]";
        o(monarray);

        long lE=new Date().getTime();
        o(lE-lS);
    }
    public static void oo(Object ob){
        String message=ob.toString()+"     ";
        for (int i=2;i<=2;i++){
            StackTraceElement str=Thread.currentThread().getStackTrace()[i];
            message+=str.toString();

        }

        System.out.println(message);
    }
    public static void main(String[] args) {
        ArrayList <Integer> a =new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            a.add(i);
        }
        affiche(a);
        //MaPremiereClasse monSecondObjet = new MaPremiereClasse(123456);
        //System.out.println(monSecondObjet);
        //oo(monSecondObjet);
       // monSecondObjet.remplieAleatoirementLeTableau(4);
       // oo(monSecondObjet);
        //System.out.println(monSecondObjet);


    }

}
