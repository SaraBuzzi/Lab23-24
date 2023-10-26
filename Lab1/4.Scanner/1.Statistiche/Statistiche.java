import java.util.Scanner;

public class Statistiche {
    public static void main(String[] args) {
        System.out.println("Inserisci un testo su più righe (termina con Ctrl+D):");
        int contaRighe = 0;
        int contaParole = 0;
        double lunParole = 0;

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            String riga = s.nextLine();
            contaRighe++;
            String[] parole = riga.split(" ");
            contaParole += parole.length;
            for (String parola : parole) {
                lunParole += parola.length();
            }
        }

        System.out.println("Statistiche:");
        System.out.println("Numero linee: "+ contaRighe);
        System.out.println("Numero parole: "+ contaParole);
        System.out.println("Lunghezza media: " + lunParole/contaParole);
    }
}
