import java.util.ArrayList;
import java.util.Scanner;

public class Percorso {
    // OVERVIEW: classe Percorso che modelli un percorso costituito da una sequenza
    // di dati di tipo Punto

    // attributi
    ArrayList<Punto> seq;

    // costruttori
    public Percorso() {
        seq = new ArrayList<>();
    }

    // metodi
    public void addPunto(Punto p) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: aggiunge p a this
        // lancia IllegalArgumentException se p == null

        if (p == null) {
            throw new IllegalArgumentException("Punto non valido");
        }

        seq.add(p);
    }

    public void delPunto() throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: rimuove da this il suo l'ultimo elemento
        // lancia IllegalArgumentException se this.size() == 0

        if (seq.size() == 0) {
            throw new IllegalArgumentException("Lista vuota");
        }

        seq.remove(seq.size() - 1);
    }

    public double distPunti(int i, int j) {
        // EFFECTS: restituisce la distanza dei punti della lista dall'indice i a quello
        // j
        // lancia IllegalArgumentException se i o j non appartengono al range [0,
        // this.size()-1]

        if (i < 0 || j < 0 || i > seq.size() - 1 || j > seq.size() - 1) {
            throw new IllegalArgumentException("Indici inseriti non validi");
        }

        double dist = 0;
        for (int k = i; k < j; k++) {
            dist += seq.get(k).distanza(seq.get(k + 1));
        }

        return dist;
    }

    public double lunghezzaTotale() {
        return distPunti(0, seq.size() - 1);
    }

    public int getSize() {
        return seq.size();
    }

    public static void main(String[] args) {

        System.out.println("Inserisci le coordinate di un punto per riga nel formato <x y> (termina con CTRL+D)");
        Scanner s = new Scanner(System.in);

        Percorso p = new Percorso();
        while (s.hasNext()) {
            try {
                p.addPunto(new Punto(s.nextDouble(), s.nextDouble()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            
        }

        for (int i = 0; i < p.getSize()-1 ; i++) {
            System.out.println("Tratto " + (i+1) + ": distanza " + p.distPunti(i, i+1));
        }
        System.out.println("Totale: " + p.lunghezzaTotale());

    }

}
