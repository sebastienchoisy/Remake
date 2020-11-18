package cartes.batiments;

import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class TestDeckBatiments {

    @Test
    public void testGetDeck(){
        ArrayList<CarteBatiments> deck = new DeckBatiments().getDeck();
        assertEquals(42,deck.size());
    }
}
