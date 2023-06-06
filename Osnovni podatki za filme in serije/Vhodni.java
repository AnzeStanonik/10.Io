import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Vhodni {
    public static void main(String[] args) {
        Path pot = Paths.get("Datoteke\\datoteka.csv");
        ArrayList<Object> objekti = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pot.toFile()), StandardCharsets.UTF_8))) {
            if (br.ready()) {
                String vrstica = null;
                int stevec = 0;
                while ((vrstica = br.readLine()) != null) {
                    if (stevec++ < 1) {
                        continue;
                    }
                    String[] vrednosti = vrstica.split(",");
                    if(vrednosti[0].equals("film")) {
                        Film objekt = new Film(vrednosti[0], Integer.parseInt(vrednosti[1]), Double.parseDouble(vrednosti[2]), vrednosti[3], vrednosti[4]);
                        objekti.add(objekt);
                        System.out.println(objekt);
                    }else if (vrednosti[0].equals("serija")) {
                        Serija objekt = new Serija(vrednosti[0], vrednosti[1], Double.parseDouble(vrednosti[2]), Integer.parseInt(vrednosti[3]), Integer.parseInt(vrednosti[4]));
                        objekti.add(objekt);
                        System.out.println(objekt);
                    }else {
                        System.out.println("V datoteki podatki niso ustrezni za branje!");
                        System.exit(1);
                    } 
                }
            }
        } catch (IOException e) {
            System.out.println("zgodila se je napaka: " + e.getMessage());
        }
        objekti.add(new Film("The Matrix Resurrections", 2021, 5.7, "Keanu Reeves|Carrie-Anne Moss|Yahya Abdul-Mateen II","Lana Wachowski"));
        objekti.add(new Serija("Breaking Bad", "2008-2013", 9.5, 5, 6));
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(pot, StandardCharsets.UTF_8))) {
                pw.println("naziv,leto,ocena,dodatno1,dodatno2");
                for (Object objekt : objekti) {
                    if (objekt instanceof Film) {
                        Film objekt1 = (Film) objekt;
                        pw.println("film," + objekt1.getNaziv() + "," + objekt1.getLeto() + "," + objekt1.getOcena() + "," + objekt1.getDodatno1() +  "," + objekt1.getDodatno2());
                    } else {
                        Serija objekt2 = (Serija) objekt;
                        pw.println("serija," + objekt2.getNaziv() + "," + objekt2.getLetnice() + "," + objekt2.getOcena() + "," + objekt2.getDodatno1() + "," + objekt2.getDodatno2());
                    }
                }
            }catch (IOException e) {
            System.out.println("zgodila se je napaka: " + e.getMessage());
        }
    }
}
