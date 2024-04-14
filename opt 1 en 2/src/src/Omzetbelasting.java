package src;

public class Omzetbelasting extends Belasting {
    private double btw;


    public Omzetbelasting(double omzet, double btw) {
        super(omzet);
        this.btw = btw;
    }


    @Override
    public double berekenBelasting() {
        return bedrag * (btw / 100);
    }
}

