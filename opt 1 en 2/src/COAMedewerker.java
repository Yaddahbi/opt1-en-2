import java.util.ArrayList;
import java.util.Scanner;

class COAMedewerker extends Gebruiker {
    private ArrayList<Land> landen;
    private ArrayList<Vluchteling> vluchtelingen;
    private ArrayList<AZC> azcs;

    public COAMedewerker(ArrayList<Land> landen, ArrayList<Vluchteling> vluchtelingen, ArrayList<AZC> azcs) {
        this.landen = landen;
        this.vluchtelingen = vluchtelingen;
        this.azcs = azcs;
    }

    @Override
    protected void toonOpties() {
        System.out.println("COA-medewerker acties:");
        System.out.println("1. Registreer vluchteling");
        System.out.println("0. Terug");
    }

    @Override
    protected boolean verwerkOptie(int keuze, Scanner scanner) {
        switch (keuze) {
            case 1:
                registreerVluchteling(scanner);
                break;
            case 0:
                return false;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
        return true;
    }

    public void registreerVluchteling(Scanner scanner) {
        System.out.println("Registreer een nieuwe vluchteling:");
        System.out.print("Naam: ");
        String naam = scanner.nextLine();
        System.out.print("Leeftijd: ");
        System.out.print("Land van herkomst: ");
        String landVanHerkomstNaam = scanner.nextLine();

        Land landVanHerkomst = null;
        for (Land land : landen) {
            if (land.getNaam().equalsIgnoreCase(landVanHerkomstNaam)) {
                landVanHerkomst = land;
                break;
            }
        }

        if (landVanHerkomst == null) {
            System.out.println("Onbekend land van herkomst. Registreer eerst het land.");
            return;
        }

        for (Vluchteling v : vluchtelingen) {
            if (v.getNaam().equalsIgnoreCase(naam) && v.getLandVanHerkomst().equals(landVanHerkomst)) {
                System.out.println("Deze vluchteling is al geregistreerd.");
                return;
            }
        }

        Dossier dossier;
        System.out.println("Kan de vluchteling een paspoort tonen? (ja/nee)");
        boolean paspoortGetoond = scanner.nextLine().equalsIgnoreCase("ja");
        if (paspoortGetoond) {
            dossier = new Dossier(true);
        } else {
            dossier = new Dossier(false);
        }
        Berichtenbox berichtenbox = new Berichtenbox();
        Vluchteling nieuweVluchteling = new Vluchteling(naam, landVanHerkomst, dossier, false, berichtenbox);
        for (AZC azc : azcs) {
            nieuweVluchteling.addObserver(azc);
        }
        vluchtelingen.add(nieuweVluchteling);
        System.out.println("Vluchteling succesvol geregistreerd.");
    }
}
