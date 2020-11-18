package cartes.ouvriers;

import cartes.Cartes;

public class CarteOuvriers extends Cartes {
    private int cout;
    private boolean assign;

    public CarteOuvriers(int id, String nom, int cout, int pierre, int bois, int savoir, int tuile){
        super(id, nom , bois, tuile, savoir, pierre);
        this.cout = cout;
        this.assign = false;
    }

    public int getCout() {
        return cout;
    }
    public void setCout(int cout) {
        this.cout = cout;
    }
    public boolean isAssign() { return assign;
    }
    public void setAssign(boolean assign) {
        this.assign = assign;
    }


}
