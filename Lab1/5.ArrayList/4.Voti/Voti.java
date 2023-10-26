import java.util.ArrayList;
import java.util.Scanner;

public class Voti {
    public static void main(String[] args) {
        System.out.println("Inserisci i voti:");
        filtraVoti(leggiNumeri());
    }

    public static ArrayList<Integer> leggiNumeri() {
        ArrayList<Integer> num = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int voto = s.nextInt();
            num.add(voto);
        }
        return num;
    }

    public static void filtraVoti(ArrayList<Integer> l) {
        ArrayList<Integer> suff = new ArrayList<Integer>();
        ArrayList<Integer> insuff = new ArrayList<Integer>();

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) >= 60) {
                suff.add(l.get(i));
            } else {
                insuff.add(l.get(i));
            }
        }
        System.out.println("Voti sufficienti: " + suff + "\nVoti insufficienti: " + insuff);
    }
}
