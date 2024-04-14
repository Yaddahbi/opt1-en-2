package src;

public class Gegevens {
        private double omzet;
        private double btw;
        private double inkomen;
        private double aftrekposten;
        private double heffingskorting;
        private double vermogen;
    
        public Gegevens(double omzet, double btw, double inkomen, double aftrekposten, double heffingskorting, double vermogen) {
            this.omzet = omzet;
            this.btw = btw;
            this.inkomen = inkomen;
            this.aftrekposten = aftrekposten;
            this.heffingskorting = heffingskorting;
            this.vermogen = vermogen;
        }
    
        public double getOmzet() {
            return omzet;
        }
    
        public double getBtw() {
            return btw;
        }
    
        public double getInkomen() {
            return inkomen;
        }
    
        public double getAftrekposten() {
            return aftrekposten;
        }
    
        public double getHeffingskorting() {
            return heffingskorting;
        }
    
        public double getVermogen() {
            return vermogen;
        }
    }

