package IA;

import cartes.batiments.CarteBatiments;
import cartes.ouvriers.CarteOuvriers;
import joueur.Joueur;

import java.util.ArrayList;

public class IA {
    Joueur joueur;
    int nbActions;
    public IA(Joueur joueur){
        this.joueur = joueur;
        this.nbActions = 6;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public int getNbActions() {
        return nbActions;
    }

    public void setNbActions(int nbActions) {
        this.nbActions = nbActions;
    }

    public void choisitBatiment(ArrayList<CarteBatiments> cartesBatSurTable){
        if(joueur.getMainBat().size()==0) {
            int sum = 100;
            for (int i = 0; i < cartesBatSurTable.size(); i++) {
                if(sum>cartesBatSurTable.get(i).getSumRessources()){
                    sum=cartesBatSurTable.get(i).getSumRessources();
                }
            }
            for(int i = 0; i < cartesBatSurTable.size(); i++){
                if(cartesBatSurTable.get(i).getSumRessources()==sum){
                    joueur.ajouteBatiment(cartesBatSurTable.get(i));
                    nbActions = nbActions-1;
                    break;
                }
            }

        }
    }

    public void choisitOuvrier(ArrayList<CarteOuvriers> cartesSurTable){
            for(int i=0;i<3;i++){
                joueur.ajouteOuvrier(cartesSurTable.get(i));
                nbActions = nbActions-1;
            }
    }

    public void poserOuvrierSurChantier(){
        for(int i=0;i<nbActions;i++){
            if(joueur.getMainBat().get(0).getBois()>joueur.getMainBat().get(0).getSumBoisOuv() ){
                for(int j=0;j<joueur.getMainOuv().size();j++){
                    if(joueur.getMainOuv().get(j).getBois()>0 &&nbActions<6){
                        joueur.getMainBat().get(0).attribuerOuvrier(joueur.getMainOuv().get(j));


                    }
                }
            }
            else if(joueur.getMainBat().get(0).getPierre()>joueur.getMainBat().get(0).getSumPierreOuv()){
                for(int j=0;j<joueur.getMainOuv().size();j++){
                    if(joueur.getMainOuv().get(j).getPierre()>0 &&nbActions<6){
                        joueur.getMainBat().get(0).attribuerOuvrier(joueur.getMainOuv().get(j));


                    }
                }
            }
            else if(joueur.getMainBat().get(0).getSavoir()>joueur.getMainBat().get(0).getSumSavoirOuv()){
                for(int j=0;j<joueur.getMainOuv().size();j++){
                    if(joueur.getMainOuv().get(j).getSavoir()>0 &&nbActions<6){
                        joueur.getMainBat().get(0).attribuerOuvrier(joueur.getMainOuv().get(j));

                    }
                }
            }
            else if(joueur.getMainBat().get(0).getTuile()>joueur.getMainBat().get(0).getSumTuileOuv()){
                for(int j=0;j<joueur.getMainOuv().size();j++){
                    if(joueur.getMainOuv().get(j).getTuile()>0 &&nbActions<6){
                        joueur.getMainBat().get(0).attribuerOuvrier(joueur.getMainOuv().get(j));


                    }
                }
            }
        }
    }

}

