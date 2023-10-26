import java.util.Scanner;

public class Farfallino {
    public static void main(String[] args) {

        System.out.println("Inserisci un testo su più righe (termina con CTRL+D):");
        String testo = "";
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            testo += s.nextLine() + "\n";
        }
        
        System.out.println("Risultato: \n" + traduci(testo));

    }

    public static String traduci(String testo) {
        char[] vocali = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        for (char vocale : vocali) {
            if (vocale < 'a') {
                testo = testo.replace("" + vocale, vocale + "F" + vocale);
            } else {
                testo = testo.replace("" + vocale, vocale + "f" + vocale);
            }
        }
        return testo;
    }
}
