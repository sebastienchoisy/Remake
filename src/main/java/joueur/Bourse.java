package joueur;

import cartes.ouvriers.CarteOuvriers;

public class Bourse {
    private int pieceArgent, pieceOr, ecus;
    private Joueur joueur;

    /**
     * Constructeur de la Bourse, on récupère les pièces d'argent et d'or pour créer le nombre d'écus.
     * @param pieceArgent le nombre de piece d'argent qu'on donne au joueur en début de partie.
     * @param pieceOr     le nombre de piece d'or qu'on donne au joueur en début de partie
     * @param joueur    le numero du joueur auquel on assigne la bourse.
     */

    public Bourse(int pieceArgent, int pieceOr, Joueur joueur) {
        this.pieceArgent = pieceArgent;
        this.pieceOr = pieceOr;
        this.joueur = joueur;
        this.ecus = pieceArgent + 5 * pieceOr;
    }

    /**
     * @return le nombre d'écus que le joueur possède.
     */
    public int getEcus() {
        return this.ecus;
    }

    /**
     * actionAutorisee permet d'autoriser ou non une action à l'IA en fonction de l'argent qu'elle dispose
     * @param carte la carte ouvrier
     * @return true ou false
     */
    public boolean isActionOuvAutorisee(CarteOuvriers carte){
        return carte.getCout() <= getEcus();
    }

}
