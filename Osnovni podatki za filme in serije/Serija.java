public class Serija {
    private String naziv;
    private String letnice;
    private double ocena;
    private int steviloSezon;
    private int steviloEpizod;

    public Serija(String naziv, String letnice, double ocena, int steviloSezon, int steviloEpizod) {
        this.naziv = naziv;
        this.letnice = letnice;
        this.ocena = ocena;
        this.steviloSezon = steviloSezon;
        this.steviloEpizod = steviloEpizod;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getLetnice() {
        return letnice;
    }

    public double getOcena() {
        return ocena;
    }

    public int getDodatno1() {
        return steviloSezon;
    }

    public int getDodatno2() {
        return steviloEpizod;
    }
}
