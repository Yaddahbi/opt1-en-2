package src;

import java.util.Scanner;

public class GegevensInvoer {
    private Scanner scanner;

    public GegevensInvoer() {
        scanner = new Scanner(System.in);
    }

    public Gegevens invoerenGegevens() {
        System.out.println("Voer uw omzet in:");
        double omzet = scanner.nextDouble();

        System.out.println("Voer uw btw-percentage in:");
        double btw = scanner.nextDouble();

        System.out.println("Voer uw inkomen in:");
        double inkomen = scanner.nextDouble();

        System.out.println("Voer uw aftrekposten in:");
        double aftrekposten = scanner.nextDouble();

        System.out.println("Voer uw heffingskorting in:");
        double heffingskorting = scanner.nextDouble();

        System.out.println("Voer uw vermogen in:");
        double vermogen = scanner.nextDouble();

        return new Gegevens(omzet, btw, inkomen, aftrekposten, heffingskorting, vermogen);
    }
}