package moteurdejeu;

import IA.IA;
import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import cartes.ouvriers.CarteOuvriers;
import cartes.ouvriers.DeckOuvriers;
import joueur.Joueur;

import java.util.ArrayList;
import java.util.Collections;

public class moteurdejeu {



    public void partie(){
        ArrayList<CarteBatiments> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        Joueur j1 = new Joueur(1);
        Joueur j2 = new Joueur(2);
        IA ia1 = new IA(j1);
        IA ia2 = new IA(j2);
        Collections.shuffle(deckBat);
        Collections.shuffle(deckOuv);
        ArrayList<CarteOuvriers> carteOuvSurTable = carteOuvriersSurTable(deckOuv);
        ArrayList<CarteBatiments> carteBatSurTable = carteBatimentsSurTable(deckBat);
        for(int i=0;i<2;i++){
            if(i==0){

                actionIA(ia1,carteOuvSurTable,carteBatSurTable);

                System.out.println();
                System.out.println("Joueur "+(i+1)+" a pioché la carte batiment "+j1.getMainBat().get(0).getNom()+"\n");
                System.out.println("et les cartes ouvriers suivantes :");

                for(int j=0;j<j1.getMainOuv().size();j++){
                    System.out.println(" "+j1.getMainOuv().get(j).getIdCarte()+" "+j1.getMainOuv().get(j).getNom());
                }
                System.out.println("il a placé les cartes suivantes sur le batiment "+j1.getMainBat().get(0).getNom()+":");
                for(int j=0;j<j1.getMainBat().get(0).getOuvriers().size();j++){
                    System.out.println(j1.getMainBat().get(0).getOuvriers().get(j).getIdCarte()+" "+j1.getMainBat().get(0).getOuvriers().get(j).getNom());
                }

                fillCartesBatiments(deckBat,carteBatSurTable);
                fillCartesOuvriers(deckOuv,carteOuvSurTable);

            }
            if(i==1){

                actionIA(ia2,carteOuvSurTable,carteBatSurTable);

                System.out.println("Joueur "+(i+1)+" a pioché la carte batiment "+j2.getMainBat().get(0).getNom()+"\n");
                System.out.println("et les cartes ouvriers suivantes :");

                for(int j=0;j<j2.getMainOuv().size();j++){
                    System.out.println(" "+j2.getMainOuv().get(j).getIdCarte()+" "+j2.getMainOuv().get(j).getNom());
                }
                System.out.println("il a placé les cartes suivantes sur le batiment "+j2.getMainBat().get(0).getNom()+":");
                for(int j=0;j<j2.getMainBat().get(0).getOuvriers().size();j++){
                    System.out.println(j2.getMainBat().get(0).getOuvriers().get(j).getIdCarte()+" "+j2.getMainBat().get(0).getOuvriers().get(j).getNom());
                }

                fillCartesBatiments(deckBat,carteBatSurTable);
                fillCartesOuvriers(deckOuv,carteOuvSurTable);
            }
        }
        if(isBuild(ia1)){
            System.out.println("\nLe joueur j1 a gagné\n");
        }
        if(isBuild(ia2)){
            System.out.println("\nLe joueur j2 a gagné\n");
        }
    }

    public ArrayList<CarteOuvriers> carteOuvriersSurTable(ArrayList<CarteOuvriers> deck){
        ArrayList<CarteOuvriers> cartes = new ArrayList<>();
        for(int i=0;i<5;i++){
            cartes.add(deck.get(i));
            deck.remove(i);

        }
        return cartes;
    }
    public ArrayList<CarteBatiments> carteBatimentsSurTable(ArrayList<CarteBatiments> deck) {
        ArrayList<CarteBatiments> cartes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cartes.add(deck.get(i));
            deck.remove(i);
        }
        return cartes;
    }
    public void fillCartesOuvriers(ArrayList<CarteOuvriers> deck,ArrayList<CarteOuvriers> carteSurTable){
        int nbCartes;
        if(carteSurTable.size()<5){
            nbCartes = 5 - carteSurTable.size();
            for(int i=0;i<nbCartes;i++){
                carteSurTable.add(deck.get(i));
                deck.remove(i);
            }
        }
    }
    public void fillCartesBatiments(ArrayList<CarteBatiments> deck,ArrayList<CarteBatiments> carteSurTable){
        int nbCartes;
        if(carteSurTable.size()<5){
            nbCartes = 5 - carteSurTable.size();
            for(int i=0;i<nbCartes;i++){
                carteSurTable.add(deck.get(i));
                deck.remove(i);
            }
        }
    }

    public void actionIA(IA ia,ArrayList<CarteOuvriers> carteOuvSurTable,ArrayList<CarteBatiments> carteBatSurTable){
        ia.choisitBatiment(carteBatSurTable);
        carteBatSurTable.remove(ia.getJoueur().getMainBat().get(0));
        ia.choisitOuvrier(carteOuvSurTable);
        for(int i=0;i<ia.getJoueur().getMainOuv().size();i++){
            carteOuvSurTable.remove(ia.getJoueur().getMainOuv().get(i));
        }
        ia.poserOuvrierSurChantier();
    }
    public boolean isBuild(IA ia){
        boolean isBuild = false;
        for(int i=0;i<ia.getJoueur().getMainBat().size();i++){
            if(ia.getJoueur().getMainBat().get(i).getSumBoisOuv() >= ia.getJoueur().getMainBat().get(i).getBois()
                    && ia.getJoueur().getMainBat().get(i).getSumPierreOuv() >= ia.getJoueur().getMainBat().get(i).getPierre()
                    && ia.getJoueur().getMainBat().get(i).getSumTuileOuv() >= ia.getJoueur().getMainBat().get(i).getTuile()
                    && ia.getJoueur().getMainBat().get(i).getSumSavoirOuv() >= ia.getJoueur().getMainBat().get(i).getSavoir()) {
                isBuild = true;
                ia.getJoueur().getMainBat().get(i).setIsConstruit(true);
            }
        }
        return isBuild;
    }
    public static void main(String[] args){
        moteurdejeu m1 = new moteurdejeu();
        m1.partie();
    }


}
