
import java.util.Scanner;

public class Cesare {
    public static void main(String[] args) {
        
        int chiave = Integer.parseInt(args[0]);
        System.out.println("Inserisci un testo su più righe (termina con CTRL+D):");

        String testoCifrato = cifraTesto(leggiTesto(), chiave);
        System.out.println("Testo cifrato: \n" + testoCifrato);

    }

    public static String leggiTesto() {
        String testo = "";
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            testo += s.nextLine() + "\n";
        }
        return testo;
    }

    public static char cifraCarattere(char c, int chiave) {
        return (char) (c + chiave);
    }

    public static String cifraTesto(String testo, int chiave) {
        String res = "";
        for (int i = 0; i < testo.length(); i++) {
            res += cifraCarattere(testo.charAt(i), chiave);
        }
        return res;
    }
}
