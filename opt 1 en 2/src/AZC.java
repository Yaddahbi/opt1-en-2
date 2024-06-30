

public class AZC implements Observer {
    private String naam;
    private Adress adress;
    private Berichtenbox berichtenbox;

    public AZC(String naam, Adress adress) {
        this.naam = naam;
        this.adress = adress;
        this.berichtenbox = new Berichtenbox(); // Initialiseer Berichtenbox
    }

    public String getNaam() {
        return naam;
    }

    public Adress getAdress() {
        return adress;
    }

    public Berichtenbox getBerichtenbox() {
        return berichtenbox;
    }

    @Override
    public void update(String bericht) {
        berichtenbox.update(bericht);
    }


    public void toonNietVerwerkteBerichten() {
        System.out.println("Niet verwerkte berichten in " + naam + ":");
        berichtenbox.toonNietVerwerkteBerichten();
    }
}
