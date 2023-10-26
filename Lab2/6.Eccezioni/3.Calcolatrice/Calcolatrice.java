import java.util.InputMismatchException;
import java.util.Scanner;

public class Calcolatrice {
    public static void main(String[] args) throws InputMismatchException, DivisioneByZeroException {
        System.out.println("Inserisci <operando1> <operatore> <operando2>. es. 4 + 3");
        Scanner s = new Scanner(System.in);
        String[] r = s.nextLine().split(" ");
        if (r.length != 3) {
            throw new InputMismatchException("Non sono stati inseriti tutti gli input richiesti");
        }
        try {

            double a = Double.parseDouble(r[0]);
            double b = Double.parseDouble(r[2]);
            try {
                double res = calculate(a, b, r[1]);
                System.out.println("Il risultato è " + res);
            } catch (InputMismatchException | DivisioneByZeroException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            } 
        } catch (InputMismatchException e) {
            System.out.println("Gli operandi devono essere numeri reali");
            System.exit(1);
        }

    }

    public static double calculate(double a, double b, String o) throws InputMismatchException, DivisioneByZeroException{
        double res;
        switch (o) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a-b;
                break;
            case "*":
                res = a*b;
                break;
            case "/":
                if (b == 0) {
                    throw new DivisioneByZeroException("Non è possibile dividere per zero");
                } else {
                    res = a / b;
                }
            default:
                throw new InputMismatchException("Operatore non riconosciuto");
        }

        return res;
    }
}
