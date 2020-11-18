package cartes.batiments;

import cartes.Cartes;
import cartes.ouvriers.CarteOuvriers;

import java.util.ArrayList;

public class CarteBatiments extends Cartes {
    private boolean isConstruit;
    private static ArrayList<CarteOuvriers> ouvriers = new ArrayList<>();
    private int ecu;
    private int points;

    public CarteBatiments(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points) {
        super(id, nom, bois, tuile, savoir, pierre);
        this.ecu = ecu;
        this.points = points;
        this.isConstruit = false; // 0 si pas encore construit et 1 si construit

    }

    public int getEcu() {
        return ecu;
    }
    public int getPoints() {
        return points;
    }

    public void setEcu(int ecu) {
        this.ecu = ecu;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public boolean getisContruit(){
        return isConstruit;
    }
    public void setIsConstruit(boolean bool){
        this.isConstruit = bool;
    }
    public ArrayList<CarteOuvriers> getOuvriers(){
        return ouvriers;
    }
    public void attribuerOuvrier(CarteOuvriers carte){
        ouvriers.add(carte);
    }
    public void libererOuvrier(){
        if(ouvriers.size()!=0){
        for(int i=0;i< ouvriers.size()+1;i++){
            ouvriers.remove(0);
        }
        }else{
            System.out.println("\nIl n'y aucun ouvrier assigné à ce chantier\n");
        }
    }
    public int getSumRessources(){
        return super.bois+super.pierre+super.savoir+super.tuile;
    }
    public int getSumBoisOuv(){
        int sumBois =0;
        for(int i=0;i<ouvriers.size();i++){
            sumBois += ouvriers.get(i).getBois();
        }
        return sumBois;
    }
    public int getSumPierreOuv(){
        int sumPierre =0;
        for(int i=0;i<ouvriers.size();i++){
            sumPierre += ouvriers.get(i).getPierre();
        }
        return sumPierre;
    }
    public int getSumSavoirOuv(){
        int sumSavoir =0;
        for(int i=0;i<ouvriers.size();i++){
            sumSavoir += ouvriers.get(i).getSavoir();
        }
        return sumSavoir;
    }
    public int getSumTuileOuv(){
        int sumTuile =0;
        for(int i=0;i<ouvriers.size();i++){
            sumTuile += ouvriers.get(i).getTuile();
        }
        return sumTuile;
    }
}
