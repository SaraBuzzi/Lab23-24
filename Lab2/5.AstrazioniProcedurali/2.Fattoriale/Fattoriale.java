import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Fattoriale {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Fattoriali: ");
        stampaFattoriali(listaFattoriali(n));
    }

    public static int fattoriale(int n) {
        int fatt = 1;
        for (int i = 1; i <= n; i++) {
            fatt*=i;
        }
        return fatt;
    }

    public static List<Integer> listaFattoriali(int n) {
        ArrayList<Integer> lista = new ArrayList<Integer>() ;
        for (int i = 1; i <= n; i++) {
            lista.add(fattoriale(i));
        }
        return lista;
    }

    public static void stampaFattoriali(List<Integer> lista) {
        for (int i = 1; i <= lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i-1));
        }
    }
}
