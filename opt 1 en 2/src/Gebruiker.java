import java.util.Scanner;

abstract class Gebruiker {
    public void uitvoeren() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            toonOpties();
            if (scanner.hasNextInt()) {
                int keuze = scanner.nextInt();
                scanner.nextLine();
                switch (keuze) {
                    case 0:
                    case 1:
                    case 2:
                        running = verwerkOptie(keuze, scanner);
                        break;
                    default:
                        System.out.println("Ongeldige keuze. Probeer opnieuw.");
                        break;
                }
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    protected abstract void toonOpties();
    protected abstract boolean verwerkOptie(int keuze, Scanner scanner);
}
