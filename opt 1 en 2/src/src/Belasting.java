package src;

public class Belasting {
    protected double bedrag;

    public Belasting(double bedrag) {
        this.bedrag = bedrag;
    }

    public double berekenBelasting() {
        return bedrag;
    }
}
