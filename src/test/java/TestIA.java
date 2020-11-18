import cartes.batiments.CarteBatiments;
import joueur.Joueur;
import org.junit.Test;
import IA.IA;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIA {

    @Test
    public void TestChoisitBatiment(){
        Joueur j1 = new Joueur(0);
        IA iatest = new IA(j1);
        ArrayList<CarteBatiments> cartes = new ArrayList<>();
        cartes.add(new CarteBatiments(0,"test1",1,5,4,4,3,9));
        cartes.add(new CarteBatiments(0,"test2",3,1,5,1,3,9));
        cartes.add(new CarteBatiments(0,"test3",5,3,1,3,3,9));
        cartes.add(new CarteBatiments(0,"test4",4,2,3,5,3,9));
        cartes.add(new CarteBatiments(0,"test5",1,4,2,2,3,9));
        iatest.choisitBatiment(cartes);
        assertEquals("test5",j1.getMainBat().get(0).getNom());
    }

}
