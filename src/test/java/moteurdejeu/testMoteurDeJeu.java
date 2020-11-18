package moteurdejeu;

import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import cartes.ouvriers.CarteOuvriers;
import cartes.ouvriers.DeckOuvriers;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class testMoteurDeJeu {
    moteurdejeu m1 = new moteurdejeu();


    @Test
    public void testCarteOuvriersSurTable(){
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> cartesSurTable = m1.carteOuvriersSurTable(deckOuv);
        assertEquals(5,cartesSurTable.size());
        assertEquals(42-5,deckOuv.size());
    }
    @Test
    public void testCarteBatimentsSurTable(){
        ArrayList<CarteBatiments> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteBatiments> cartesSurTable = m1.carteBatimentsSurTable(deckBat);
        assertEquals(5,cartesSurTable.size());
        assertEquals(42-5,deckBat.size());
    }
    @Test
    public void testFillCartesOuvriers(){
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> cartesSurTable = m1.carteOuvriersSurTable(deckOuv);
        cartesSurTable.remove(0);
        assertEquals(4,cartesSurTable.size());
        m1.fillCartesOuvriers(deckOuv,cartesSurTable);
        assertEquals(5,cartesSurTable.size());

    }
    @Test
    public void testFillCartesBatiments(){
        ArrayList<CarteBatiments> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteBatiments> cartesSurTable = m1.carteBatimentsSurTable(deckBat);
        cartesSurTable.remove(0);
        assertEquals(4,cartesSurTable.size());
        m1.fillCartesBatiments(deckBat,cartesSurTable);
        assertEquals(5,cartesSurTable.size());

    }
}
