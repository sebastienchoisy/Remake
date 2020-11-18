package joueur;

import cartes.batiments.CarteBatiments;
import cartes.ouvriers.CarteOuvriers;


import java.util.ArrayList;

public class Joueur {
       private int id;
       private int points;
       private ArrayList<CarteBatiments> MainBat = new ArrayList<>();
       private ArrayList<CarteOuvriers> MainOuv = new ArrayList<>();

       public Joueur(int id){
           this.id=id;
           this.points=0;

       }
       public int getId(){
           return id;
       }
       public void setId(int id){
           this.id=id;
       }
       public int getPoints(){
           return points;
       }
       public void setPoints(int points){
           this.points = points;
       }
       public void addPoints(int points){
           this.points += points;
       }
       public ArrayList<CarteBatiments> getMainBat(){
           return MainBat;
       }
       public ArrayList<CarteOuvriers> getMainOuv(){
           return MainOuv;
       }
       public void ajouteOuvrier(CarteOuvriers carte){
           MainOuv.add(carte);
       }
       public void ajouteBatiment(CarteBatiments carte){
           MainBat.add(carte);
       }
       public void attribuerOuvrierAChantier(CarteOuvriers ouvrier, CarteBatiments batiment){
           batiment.attribuerOuvrier(ouvrier);
           MainOuv.remove(ouvrier);
       }

}
