import java.util.ArrayList;
import java.util.List;

public class Abbondanti {
    public static void main(String[] args) {
        int soglia = Integer.parseInt(args[0]);
        if (soglia <= 0) {
            System.out.println("La soglia inserita non è positiva");
        } else {
            System.out.print("Numeri abbondanti: ");
            stampaNumeriAbbondanti(numeriAbbondanti(soglia));
        }



    }

    public static List<Integer> elencoDivisoriPropri(int n) {
        ArrayList<Integer> div = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
            if (n%i == 0) {
                div.add(i);
            }
        }
        return div;
    }


    public static int sommaDivisoriPropri(int n) {
        int somma = 0;
        for (int i = 1; i < n; i++) {
            if (n%i == 0) {
                somma += i;
            }
        }
       
        return somma;
    }

    public static boolean abbondante(int n) {
        return n < sommaDivisoriPropri(n);
    }

    public static List<Integer> numeriAbbondanti (int limite) {
        ArrayList<Integer> abb = new ArrayList<Integer>();
        for (int i = 0; i < limite; i++) {
            if (abbondante(i)) {
                abb.add(i);
            }
        }
        return abb;
    }

    public static void stampaNumeriAbbondanti(List<Integer> numeri) {
        for (int i = 0; i < numeri.size(); i++) {
            System.out.print(numeri.get(i) + " ");
        }
    }

}
