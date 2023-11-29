import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class AlberoNatalizio {
    // OVERVIEW: classe che modella un albero natalizio, a cui è possibile
    // aggiungere decorazioni

    // attributes
    final double caricoMax;
    final double potenzaMax;
    double caricoTot;
    ArrayList<Decorazione> dec = new ArrayList<>();
    boolean puntaleInserito; // true se la lista di decorazioni contiene un puntale, false altrimenti

    // constructor
    public AlberoNatalizio(double caricoMax, double potenzaMax) {
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se caricoMax <= 0
        // lancia IllegalArgumentException se potenzaMax <= 0

        if (caricoMax <= 0)
            throw new IllegalArgumentException("caricoMax <= 0");
        if (potenzaMax <= 0)
            throw new IllegalArgumentException("potenzaMax <= 0");

        this.caricoMax = caricoMax;
        this.potenzaMax = potenzaMax;
        this.caricoTot = 0;
        this.puntaleInserito = false;

    }

    // methods
    public void addDecorazione(Decorazione d) throws IllegalArgumentException, WeightReachedException {
        // MODIFIES: this
        // EFFECTS: aggiunge d a this
        // lancia WeightReachedException se con il peso della decorazione aggiunta si
        // supera il carico massimo dell'albero
        // lancia IllegalArgumentException se d == null
        // lancia TopperExistsException se la decorazione che si cerca di aggiungere è
        // un `Puntale`, e un altro `Puntale` è già presente

        if (d == null)
            throw new IllegalArgumentException("decorazione == null");
        if (caricoTot + d.peso > caricoMax)
            throw new WeightReachedException("non si può aggiungere: Carico superato");
        if (d instanceof Puntale && this.puntaleInserito)
            throw new TopperExistsException("è già presente un altro puntale");

        if (d instanceof Puntale)
            this.puntaleInserito = true;
        dec.add((Decorazione) d.clone());
        caricoTot += d.peso;

    }

    public void remDecorazione(Decorazione d) {
        //MODIFIES: this
        //EFFECTS: rimuove d da this
        // lancia IllegalArgumentException se d == null
        //lancia NoSuchElementException se d non è presente nella lista

        if (d == null)
            throw new IllegalArgumentException("decorazione == null");
        if (!(dec.contains(d)))
            throw new NoSuchElementException("decorazione not in the list");

        if (d instanceof Puntale)
            this.puntaleInserito = false;
        dec.remove(d);
        
    

    }

    @Override
    public String toString() {
        String ret = "Albero (Carico: " + this.caricoMax + ", Potenza: " + this.potenzaMax + ")\n";
        for (Decorazione decorazione : dec) {
            ret += decorazione + "\n";
        }
        return ret;
    }


    public static void main(String[] args) {
        AlberoNatalizio albero = new AlberoNatalizio(Double.parseDouble(args[0]), Double.parseDouble(args[1]));

        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] campi = s.nextLine().split(" ");
            try {
                switch (campi[0]) {
                    case "Decorazione":
                        Decorazione decorazione = new Decorazione(campi[1], Double.parseDouble(campi[2]));
                        albero.addDecorazione(decorazione);
                        break;
                    case "Puntale":
                        Puntale puntale = new Puntale(campi[1], Double.parseDouble(campi[2]));
                        albero.addDecorazione(puntale);
                        break;
                    
                    case "DecorazioneElettrica":
                        DecorazioneElettrica decElettrica = new DecorazioneElettrica(campi[1], Double.parseDouble(campi[2]), Double.parseDouble(campi[3]));
                        albero.addDecorazione(decElettrica);
                        break;
                
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("errore in input");
            } catch (IllegalArgumentException | WeightReachedException | TopperExistsException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(albero);
    }

}
