import java.util.ArrayList;
import java.util.Scanner;

class Beheerder extends Gebruiker {
    private ArrayList<Land> landen;
    private ArrayList<Gemeente> gemeentes;
    private ArrayList<AZC> azcs;

    public Beheerder(ArrayList<Land> landen, ArrayList<Gemeente> gemeentes, ArrayList<AZC> azcs) {
        this.landen = landen;
        this.gemeentes = gemeentes;
        this.azcs = azcs;
    }

    @Override
    protected void toonOpties() {
        System.out.println("Beheerder acties:");
        System.out.println("1. Genereer rapport voor de directeur van COA");
        System.out.println("2. Toon overzicht van veilige landen");
        System.out.println("0. Terug");
    }

    @Override
    protected boolean verwerkOptie(int keuze, Scanner scanner) {
        switch (keuze) {
            case 1:
                genereerRapport();
                break;
            case 2:
                toonOverzichtVeiligeLanden();
                break;
            case 0:
                return false;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
        return true;
    }

    public void genereerRapport() {
        System.out.println("Rapport voor de directeur van COA:");
        for (Gemeente gemeente : gemeentes) {
            System.out.println("Gemeente: " + gemeente.getNaam());
            System.out.println("Aantal inwoners: " + gemeente.getAantalInwoners());
            System.out.println("Beschikbare plaatsen: " + gemeente.getBeschikbarePlaatsen());
            System.out.println("AZC's:");
            for (AZC azc : azcs) {
                if (azc.getAdress().getGemeente().equals(gemeente)) {
                    System.out.println("- " + azc.getNaam() + " (" + azc.getAdress().toString() + ")");
                }
            }
        }
    }

    public void toonOverzichtVeiligeLanden() {
        System.out.println("Overzicht landen:");
        for (Land land : landen) {
            System.out.println("- " + land.getNaam() + " (Veilig: " + land.isVeilig() + ")");
        }
    }
}
