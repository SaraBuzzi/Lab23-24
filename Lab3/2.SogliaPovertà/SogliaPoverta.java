import java.util.ArrayList;
import java.util.Scanner;

public class SogliaPoverta {
    public static void main(String[] args) {
        double costoVitto = Double.parseDouble(args[0]);
        double costoAll = Double.parseDouble(args[1]);

        ArrayList<Famiglia> lista = new ArrayList<Famiglia>();

        System.out.println("Inserisci il reddito e la dimensione di una familgia\n (Ctrl+d per terminare la lettura)");
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            System.out.println("Inserisci il reddito e la dimensione di una familgia\n (Ctrl+d per terminare la lettura)");
            Famiglia fam = new Famiglia(s.nextInt(), s.nextInt());
            if (fam.sottoSogliaPoverta(costoVitto, costoAll)) {
                lista.add(fam);
            }
        }

        System.out.println(lista.size() + " famiglie sotto la soglia di poverta':");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Famiglia " + (i+1) + ": " + lista.get(i).toString());

    }
}
}
