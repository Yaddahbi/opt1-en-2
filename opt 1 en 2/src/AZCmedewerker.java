import java.util.Scanner;

class AZCmedewerker extends Gebruiker {
    private AZC azc;


    public AZCmedewerker(AZC azc) {
        this.azc = azc;
    }

    @Override
    protected void toonOpties() {
        System.out.println("\nKies een optie:");
        System.out.println("1. Toon niet verwerkte berichten");
        System.out.println("0. Terug");
    }

    @Override
    protected boolean verwerkOptie(int keuze, Scanner scanner) {
        switch (keuze) {
            case 1:
                azc.toonNietVerwerkteBerichten();
                break;
            case 0:
                return false;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
        return true;
    }
}
