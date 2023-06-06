public class Film {
    private String naziv;
    private int leto;
    private double ocena;
    private String zvezdniIgraleci;
    private String reziser;

    public Film(String naziv, int leto, double ocena, String zvezdniIgraleci, String reziser) {
        this.naziv = naziv;
        this.leto = leto;
        this.ocena = ocena;
        this.zvezdniIgraleci = zvezdniIgraleci;
        this.reziser = reziser;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getLeto() {
        return leto;
    }

    public double getOcena() {
        return ocena;
    }

    public String getDodatno1() {
        return zvezdniIgraleci;
    }

    public String getDodatno2() {
        return reziser;
    }
    
}