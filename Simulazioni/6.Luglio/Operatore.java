import java.util.ArrayList;
import java.util.Iterator;

public class Operatore implements Iterable<Utenza> {
    // OVERVIEW: classe che modella un elenco di utenze

    // attributes
    ArrayList<Utenza> utenze = new ArrayList<>();
    private final String nome;

    // constructor
    public Operatore(String nome) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se nome == null o vuoto

        if (nome == null || nome.equals(" "))
            throw new IllegalArgumentException("nome null o vuoto");
        
        this.nome = nome;
    }

    // methods
    public void addUtenza(Utenza u) throws UtenzaNonValidaException {
        // MODIFIES: this
        // EFFECTS: aggiunge l'utenza u a this
        // lancia UtenzaNonValidaException se u è già presente in this

        if (utenze.contains(u))
            throw new UtenzaNonValidaException("UtenzaNonValidaException: utenza esiste");

        utenze.add((Utenza) u.clone());

        assert repOk();
    }

    public Utenza getUtenza(String numero) throws UtenzaNonValidaException {
        // EFFECTS: restituisce l'utenza in this identificata dal numero passato come
        // parametro
        // lancia UtenzaNonValidaException se non esiste un utenza con il numero passato

        for (Utenza utenza : utenze) {
            if (utenza.getNumero().equals(numero))
                return utenza;
        }

        throw new UtenzaNonValidaException("UtenzaNonValidaException: utenza non esiste");
    }

    public boolean repOk() {
        if (utenze == null)
            return false;

        for (Utenza utenza : utenze) {
            if (utenza == null)
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String ret = "Utenza di " + this.nome + ":";
        for (Utenza utenza : this) {
            ret += "\n\t" + utenza;
        }
        return ret;
    }


    @Override
    public Iterator<Utenza> iterator() {
        // EFFECTS: restituisce un iteratore di this

        utenze.sort(null);
        return new Iterator<>() {

            Iterator<Utenza> i = utenze.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Utenza next() {
                return i.next();
            }

        };
    }

}
