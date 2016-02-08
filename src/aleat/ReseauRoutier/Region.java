package aleat.ReseauRoutier;

import java.util.ArrayList;

/**
 * Created by bachir on 19/01/16.
 */
public class Region {
   public int dep ;
   public int arr;
   public int id ;
   public int poids ;
  public ArrayList<City> MesVilles =new ArrayList<City>();
   public ArrayList<Roadbach> MesRoutes =new ArrayList<Roadbach>();
   public Region(int n ){
      for (int i =0;i<n;i++){
        MesVilles.add(new City(i));
      }

   }
   public void ajouteRoute(City A  ,City B,int poids ){
      MesRoutes.add( new Roadbach(A ,B,poids));
   }


   public static void main(String[] args) {
      int nbVille=5;
      Region region = new Region(nbVille);
      /*for (int i=0;i<nbVille;i++){
         System.out.println(region.MesVilles.get(i).id);}*/
         region.ajouteRoute(region.MesVilles.get(0), region.MesVilles.get(1), 2);
       region.ajouteRoute(region.MesVilles.get(0),region.MesVilles.get(3),1);
      System.out.println("ville départ: " + region.MesRoutes.get(0).dep + ", arrivé : " + region.MesRoutes.get(0).arr);
      System.out.println("poids="+region.MesRoutes.get(0).poids);
      System.out.println("ville départ: " + region.MesRoutes.get(1).dep + ", arrivé : " + region.MesRoutes.get(1).arr);
      System.out.println("poids="+region.MesRoutes.get(1).poids);
      System.out.println(region.MesVilles.get(0).posX);
      System.out.println(region.MesVilles.get(0).posY);

   }



}
