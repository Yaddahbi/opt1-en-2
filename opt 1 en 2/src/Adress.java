public class Adress {
    private String straat;
    private int nummer;
    private String postcode;
    private Gemeente gemeente;

    public Adress(AdressParameters parameters) {
        this.straat = parameters.getStraat();
        this.nummer = parameters.getNummer();
        this.postcode = parameters.getPostcode();
        this.gemeente = parameters.getGemeente();
    }

    public Gemeente getGemeente() {
        return gemeente;
    }
    @Override
    public String toString() {
        return straat + " " + nummer + ", " + postcode + " " + gemeente.getNaam();
    }
}
