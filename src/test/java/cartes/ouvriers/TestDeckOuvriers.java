package cartes.ouvriers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDeckOuvriers {

    @Test
    public void testGetDeck(){
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        assertEquals(42,deck.size());
    }
}
