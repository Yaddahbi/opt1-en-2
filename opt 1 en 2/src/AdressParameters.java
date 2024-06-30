public class AdressParameters {
    private String straat;
    private int nummer;
    private String postcode;
    private Gemeente gemeente;

    public AdressParameters(String straat, int nummer, String postcode, Gemeente gemeente) {
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public int getNummer() {
        return nummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }
}