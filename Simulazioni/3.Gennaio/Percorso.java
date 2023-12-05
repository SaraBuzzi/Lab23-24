import java.util.ArrayList;
import java.util.Iterator;

public class Percorso implements Iterable<Tratta> {
    // OVERVIEW: classe che modella un percorso costituito da una sequenza di
    // tratte. La prima tratta parte da un luogo d'origine e arriva al punto di
    // partenza della tratta successiva e così via fino all'ultima tratta.

    // attributes
    ArrayList<Tratta> percorso = new ArrayList<>();

    // constructor
    public Percorso() {
        // EFFECTS: inizializza un percorso vuoto
    }

    public Percorso(Percorso p) throws TrattaNonValidaException {
        // MODIFIES: this
        // EFFECTS: inizializza this con tutte le tratte contenute in p
        //

        for (Tratta tratta : p) {
            this.addTratta(tratta);
        }
    }

    // methods
    public void addTratta(Tratta t) throws TrattaNonValidaException {
        // MODIFIES: this
        // EFFECTS: aggiunge la tratta t a this
        // lancia TrattaNonValidaException se il luogo d'origine di t != al luogo di
        // destinazione dell'ultima tratta

        if (!percorso.isEmpty() && !(percorso.get(percorso.size() - 1).getDestinazione().equals(t.getOrigine())))
            throw new TrattaNonValidaException("tratta non continua il percorso");

        percorso.add(t);

        assert repOk();

    }

    public double durataTot() {
        // EFFECTS: restituisce la durata totale delle tratte del percorso

        double ret = 0;
        for (Tratta tratta : percorso) {
            ret += tratta.durataInOre();
        }
        return ret;
    }

    public double inquinaTot() {
        // EFFECTS: restituisce la CO2 prodotta totale delle tratte del percorso

        double ret = 0;
        for (Tratta tratta : percorso) {
            ret += tratta.inquina();
        }
        return ret;
    }

    public void ordina() {
        percorso.sort(null);
    }

    @Override
    public Iterator<Tratta> iterator() {

        return new Iterator<>() {

            Iterator<Tratta> i = percorso.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Tratta next() {
                return i.next();
            }

        };
    }

    @Override
    public String toString() {
        String ret = "Percorso (durata: " + this.durataTot() + ", co2: " + this.inquinaTot() + ")\n";

        for (Tratta tratta : percorso) {
            ret += tratta + "\n" ;
        }
        return ret;
    }

    public boolean repOk() {
        if (percorso == null)
            return false;
        for (int i = 0; i < percorso.size(); i++) {
            if (percorso.get(i) == null)
                return false;
            if (i != 0 && !(percorso.get(i - 1).getDestinazione().equals(percorso.get(i).getOrigine())))
                return false;
        }
        return true;
    }

}
