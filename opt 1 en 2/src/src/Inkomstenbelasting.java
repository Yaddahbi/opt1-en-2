package src;

public class Inkomstenbelasting extends Belasting {
    private double aftrekposten;
    private double heffingskorting;
    private double vermogen;

    public Inkomstenbelasting(double inkomen, double aftrekposten, double heffingskorting, double vermogen) {
        super(inkomen);
        this.aftrekposten = aftrekposten;
        this.heffingskorting = heffingskorting;
        this.vermogen = vermogen;
    }

    @Override
    public double berekenBelasting() {
        double belastbaarInkomen = bedrag - aftrekposten;
        double inkomstenbelasting = 0;


        if (belastbaarInkomen <= 0) {
            inkomstenbelasting = 0;
        } else if (belastbaarInkomen <= 35000) {
            inkomstenbelasting = belastbaarInkomen * 0.3655;
        } else if (belastbaarInkomen <= 70000) {
            inkomstenbelasting = 35000 * 0.3655 + (belastbaarInkomen - 35000) * 0.4085;
        } else {
            inkomstenbelasting = 35000 * 0.3655 + 35000 * 0.4085 + (belastbaarInkomen - 70000) * 0.4915;
        }

        double vermogensbelasting = 0;
        if (vermogen > 0) {
            if (vermogen <= 50000) {
                vermogensbelasting = vermogen * 0.00635;
            } else if (vermogen <= 100000) {
                vermogensbelasting = vermogen * 0.0128 - 215;
            } else {
                vermogensbelasting = vermogen * 0.0144 - 315;
            }
        }

        double totaleBelasting = inkomstenbelasting + vermogensbelasting - heffingskorting;


        if (totaleBelasting < 0) {
            totaleBelasting = 0.00;
        }


        return totaleBelasting;
    }
}

