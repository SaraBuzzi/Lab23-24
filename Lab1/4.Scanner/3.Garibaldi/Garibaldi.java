import java.util.Scanner;

public class Garibaldi {
    public static void main(String[] args) {
        System.out.println("Inserisci un testo su più righe (termina con CTRL+D):");
        String testo = "";

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            testo += s.nextLine() + "\n";
        }

        System.out.println("Risultato trasformazione: \n" + traduci(testo));

    }

    public static String traduci(String testo) {
        char[] vocali = {'a', 'e', 'i', 'o', 'u'};
        for (char vocale : vocali) {
            testo = testo.replace("" + vocale, "u");
        }
        return testo;
    }
}
