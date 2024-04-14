package src;

public class Main {
    public static void main(String[] args) {
        GegevensInvoer invoer = new GegevensInvoer();
        Gegevens gegevens = invoer.invoerenGegevens();

        Omzetbelasting omzetbelasting = new Omzetbelasting(gegevens.getOmzet(), gegevens.getBtw());
        double omzetbelastingBedrag = omzetbelasting.berekenBelasting();

        Inkomstenbelasting inkomstenbelasting = new Inkomstenbelasting(gegevens.getInkomen(), gegevens.getAftrekposten(), gegevens.getHeffingskorting(), gegevens.getVermogen());
        double inkomstenbelastingBedrag = inkomstenbelasting.berekenBelasting();

        System.out.println("Uw omzetbelasting bedraagt: " + omzetbelastingBedrag);
        System.out.println("Uw inkomstenbelasting bedraagt: " + inkomstenbelastingBedrag);
    }
}