import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class AlberoNatalizio implements Iterable<Decorazione> {
    // OVERVIEW: classe che modella un albero natalizio, a cui è possibile
    // aggiungere decorazioni

    // attributes
    final double caricoMax;
    final double potenzaMax;
    ArrayList<Decorazione> listaDecorazioni = new ArrayList<>();

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
    

        assert repOk();

    }

    // methods
    public double getCaricoCorrente() {
        // EFFECTS: ritorna la somma dei pesi delle decorazioni presenti sull'albero
        double ret = 0;
        for (Decorazione decorazione : listaDecorazioni) {
            ret += decorazione.getPeso();
        }
        return ret;
    }

    public double getPotenzaCorrente() {
        // EFFECTS: ritorna la somma delle potenze delle decorazioni accese presenti
        // sull'albero
        double ret = 0;
        for (Decorazione decorazione : listaDecorazioni) {
            if (decorazione instanceof DecorazioneElettrica) {
                if (((DecorazioneElettrica) decorazione).isInteruttore()) {
                    ret += ((DecorazioneElettrica) decorazione).getPotenza();
                }
            }
        }
        return ret;
    }

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
        if (this.getCaricoCorrente() + d.getPeso() > caricoMax)
            throw new WeightReachedException("non si può aggiungere: Carico superato");
        if (d instanceof Puntale && this.contaPuntali() > 0)
            throw new TopperExistsException("è già presente un altro puntale");


        listaDecorazioni.add((Decorazione) d.clone());

        assert repOk();

    }

    public void remDecorazione(Decorazione d) {
        // MODIFIES: this
        // EFFECTS: rimuove d da this
        // lancia IllegalArgumentException se d == null
        // lancia NoSuchElementException se d non è presente nella lista

        if (d == null)
            throw new IllegalArgumentException("decorazione == null");
        if (!(listaDecorazioni.contains(d)))
            throw new NoSuchElementException("decorazione not in the list");

        
        listaDecorazioni.remove(d);

        assert repOk();

    }

    public int contaPuntali() {
        //EFFECTS: restituisce il numero di puntali presenti sull'albero
        int count = 0;
        for (Decorazione decorazione : listaDecorazioni) {
            if (decorazione instanceof Puntale) {
                count++;
            }
        }
        return count;
    }

    public void accendi() {
        // MODIFIES: this
        // EFFECTS: "accende" le decorazioni elettriche dell'albero (dalla meno
        // richiedente alla più richiedente), rispettando la potenza massima permessa

        ArrayList<DecorazioneElettrica> listaDecorazioniElett = new ArrayList<>();
        for (Decorazione decorazione : listaDecorazioni) {
            if (decorazione instanceof DecorazioneElettrica) {
                listaDecorazioniElett.add((DecorazioneElettrica) decorazione);
            }
        }

        listaDecorazioniElett.sort(null);
        
        double potenzaCorrente = 0;
        for (DecorazioneElettrica decorazioneElettrica : listaDecorazioniElett) {
            if (potenzaCorrente + decorazioneElettrica.getPotenza() <= this.potenzaMax) {
                decorazioneElettrica.setInteruttore(true);
                potenzaCorrente += decorazioneElettrica.getPotenza();
            }     
        }

        assert repOk();
    }

    @Override
    public String toString() {
        String ret = "Albero (Carico: " + this.caricoMax + ", Potenza: " + this.potenzaMax + ")\n";
        for (Decorazione decorazione : listaDecorazioni) {
            ret += decorazione + "\n";
        }
        return ret;
    }

    @Override
    public Iterator<Decorazione> iterator() {
        return new Iterator<Decorazione>() {

            Iterator<Decorazione> i = listaDecorazioni.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Decorazione next() {
                return i.next();
            }

        };
    }

    public boolean repOk() {
        if (listaDecorazioni == null)   
            return false;
        for (Decorazione decorazione : listaDecorazioni) {
            if (decorazione == null)
                return false;
        }

        if (this.getCaricoCorrente() > this.caricoMax) 
            return false;
        if (this.getPotenzaCorrente() > this.potenzaMax)
            return false;

        if (this.contaPuntali() > 1) 
            return false;

            
        return true;

        
    }


}
