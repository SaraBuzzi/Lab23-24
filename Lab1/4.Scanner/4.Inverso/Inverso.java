import java.util.Scanner;

public class Inverso {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String testo = "";

        System.out.println("Inserisci un testo su più righe (termina con riga vuota):");

        while (s.hasNext()) {
            testo+=s.nextLine()+"\n";  
        }

        System.out.println("Testo invertito: ");
        
        for (int i = testo.length()-1; i >= 0; i--) {
            System.out.print(testo.charAt(i));
        }
        System.out.println();
    }
}
