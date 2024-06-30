import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Land nederland = new Land("Nederland", true);
        Land england = new Land("England", false);
        Gemeente denhaag = new Gemeente("Den Haag", 514816, 1000);

        AdressParameters parameters1 = new AdressParameters("Johanna Westerdijkplein", 75, "2521 EN", denhaag);
        Adress denhaagAdress = new Adress(parameters1);

        AZC denhaagAZC = new AZC("AZC Den Haag HHS", denhaagAdress);
        Berichtenbox berichtenbox = new Berichtenbox();

        Vluchteling vluchteling = new Vluchteling("Tom", nederland, new Dossier(true), true, berichtenbox);
        vluchteling.addObserver(denhaagAZC);


        ArrayList<Land> landen = new ArrayList<>();
        ArrayList<Gemeente> gemeentes = new ArrayList<>();
        ArrayList<AZC> azcs = new ArrayList<>();
        ArrayList<Vluchteling> vluchtelingen = new ArrayList<>();

        landen.add(nederland);
        landen.add(england);
        gemeentes.add(denhaag);
        azcs.add(denhaagAZC);

        vluchtelingen.add(vluchteling);


        Beheerder beheerder = new Beheerder(landen, gemeentes, azcs);
        COAMedewerker coaMedewerker = new COAMedewerker(landen, vluchtelingen, azcs);
        AZCmedewerker azcMedewerker = new AZCmedewerker( denhaagAZC);

        Scanner scanner = new Scanner(System.in);
        boolean doorgaan = true;

        System.out.println("Welkom bij het COA-systeem!");

        while (doorgaan) {
            System.out.println("\nKies gebruikerstype:");
            System.out.println("1. Beheerder");
            System.out.println("2. COA-medewerker");
            System.out.println("3. Vluchteling");
            System.out.println("4. AZC-medewerker");
            System.out.println("0. Stoppen");

            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1:
                    beheerder.uitvoeren();
                    break;
                case 2:
                    coaMedewerker.uitvoeren();
                    break;
                case 3:
                    vluchtelingNaam(vluchtelingen);
                    break;
                case 4:
                    azcMedewerker.uitvoeren();
                    break;
                case 0:
                    doorgaan = false;
                    System.out.println("Programma afgesloten.");
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
        scanner.close();
    }

    public static void vluchtelingNaam(ArrayList<Vluchteling> vluchtelingen) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer uw volledige naam in:");
        String naam = scanner.nextLine();
        Vluchteling vluchteling = null;

        for (Vluchteling v : vluchtelingen) {
            if (v.getNaam().equals(naam)) {
                vluchteling = v;
                break;
            }
        }

        if (vluchteling == null) {
            System.out.println("Geen gegevens bekend voor deze naam.");
        } else {
            vluchteling.toonOpties();
            int keuze = scanner.nextInt();
            scanner.nextLine();

            vluchteling.verwerkOptie(keuze, scanner);
        }
    }
}
