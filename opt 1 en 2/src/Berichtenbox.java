import java.util.ArrayList;

public class Berichtenbox implements Observer {
    private ArrayList<String> berichten = new ArrayList<>();

    @Override
    public void update(String bericht) {
        System.out.println("Bericht toegevoegd aan berichtenbox: " + bericht);
        berichten.add(bericht);
    }

    public void toonNietVerwerkteBerichten() {
        for (String bericht : berichten) {
            System.out.println(bericht);
        }
    }
}

