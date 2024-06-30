import java.util.ArrayList;
import java.util.Scanner;

public class Vluchteling extends Gebruiker implements Subject {
    private String naam;
    private Land landVanHerkomst;
    private Dossier dossier;
    private boolean verblijfsvergunning;
    private ArrayList<Observer> observers = new ArrayList<>();
    
    public Vluchteling(String naam, Land landVanHerkomst, Dossier dossier, boolean verblijfsvergunning, Berichtenbox berichtenBox) {
        this.naam = naam;
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = dossier;
        this.verblijfsvergunning = verblijfsvergunning;
    }

    @Override
    protected void toonOpties() {
        System.out.println("\nKies actie:");
        System.out.println("1. Toon gegevens");
        System.out.println("2. Registreer nieuw adres");
        System.out.println("0. Terug");
    }

    @Override
    protected boolean verwerkOptie(int keuze, Scanner scanner) {
        switch (keuze) {
            case 1:
                toonGegevens();
                break;
            case 2:
                registreerNieuwAdress(scanner);
                break;
            case 0:
                return false;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
        return true;
    }

    public void toonGegevens() {
        System.out.println("Gegevens van vluchteling " + naam + ":");
        System.out.println("Naam: " + naam);
        System.out.println("Land van herkomst: " + (landVanHerkomst != null ? landVanHerkomst.getNaam() : "Onbekend"));
        System.out.println("Dossier: " + (dossier != null ? dossier.getPaspoortStatus() : "Geen dossier"));
        System.out.println("Verblijfsvergunning: " + (verblijfsvergunning ? "Ja" : "Nee"));
    }

    public void registreerNieuwAdress(Scanner scanner) {
        System.out.println("Voer uw nieuwe adres (Straat 00, 0123 AB) in:");
        String nieuwAdres = scanner.nextLine();
        System.out.println("Voer de gemeente in:");
        String gemeente = scanner.nextLine();

        String berichtInhoud = "Nieuw adres geregistreerd voor " + naam + ": " + nieuwAdres + ", " + gemeente;
        notifyObservers(berichtInhoud);

        System.out.println("Adres geregistreerd: " + nieuwAdres);

    }

    public String getNaam() {
        return naam;
    }

    public Land getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String bericht) {
        for (Observer observer : observers) {
            observer.update(bericht);
        }
    }
    
}
