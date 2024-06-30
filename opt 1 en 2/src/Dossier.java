public class Dossier {
    private boolean paspoort;

    public Dossier(boolean paspoort) {
        this.paspoort = paspoort;

    }

    public String getPaspoortStatus() {
        return paspoort ? "Paspoort getoond: ja" : "Paspoort getoond: nee";
    }

}
