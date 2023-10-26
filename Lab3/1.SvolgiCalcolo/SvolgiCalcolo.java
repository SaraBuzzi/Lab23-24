import java.util.InputMismatchException;
import java.util.Scanner;

public class SvolgiCalcolo {
    public static void main(String[] args) {
        CalcolatriceConMemoria calcolatrice;
        /*
        try {
            calcolatrice = new CalcolatriceConMemoria(Double.parseDouble(args[0]));
        } catch(ArrayIndexOutOfBoundsException e) {
            calcolatrice = new CalcolatriceConMemoria();
        }
         */
        //due modi di fare lo stesso controllo
        //dal punto di vista computazionale l'if è più leggero (è meglio)

         if (args.length > 0 ) {
            calcolatrice = new CalcolatriceConMemoria(Double.parseDouble(args[0]));
        } else {
            calcolatrice = new CalcolatriceConMemoria();
        }

        System.out.println("Calcolatrice inizializzata, valore: " + calcolatrice.getMem());
        
        stampa(); 
        
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            char operator = s.next().charAt(0);
            if (operator == '=') {
                break;
            }
            double op2 = s.nextDouble();

            try {
                calcolatrice.operate(operator, op2);
            } catch(DivideByZeroException e) {
                System.out.println(e.getMessage());
                stampa();
            } catch (InputMismatchException f) {
                System.out.println(f.getMessage());
                stampa();
            }
             
            System.out.println("valore in memoria: " + calcolatrice.getMem());        
        }
        System.out.println("Il risultato finale è " + calcolatrice.getMem());

    }

    public static void stampa() { 
        //MODIFIES: System.out
        //EFFECTS: stampe di intestazioni
        System.out.println("Inserisci <operatore> <operando>. es: + 3\nPer terminare inserire il carattere '='.");
        
    }
}
