import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MazzoRidotto extends Mazzo {
    // OVERVIEW: classe che modella un mazzo ridotto di 40 carte (10 valori per i
    // quattro semi)

    // attributes
    ArrayList<Carta> mazzoRidotto = new ArrayList<>();

    // constructor
    public MazzoRidotto() {
        // MODIFIES: this
        // EFFECTS: inzializza il mazzo con tutte le 52 carte possibili

        for (int num = 1; num <= 10; num++) {
            for (int seme = 1; seme <= 4; seme++) {
                mazzoRidotto.add(new Carta(num, seme));
            }
        }

        assert repOk();

    }

    // methods
    public void mischia() {
        // MODIFIES: this
        // EFFECTS: mischia il mazzo mettendo le carte in ordine casuale

        Collections.shuffle(mazzoRidotto);
    }

    public void ordina() {
        // MODIFIES: this
        // EFFECTS: riordina il mazzo mettendo le carte nel loro ordine naturale

        mazzoRidotto.sort(new Comparator<Carta>() {

            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.getSemeNumero() < o2.getSemeNumero())
                    return 1;
                if (o1.getSemeNumero() > o2.getSemeNumero())
                    return -1;
                if (o1.getNum() > o2.getNum())
                    return 1;
                if (o1.getNum() < o2.getNum())
                    return -1;
                return 0;
            }
        });
    }

    public void addCarta(Carta c) throws CardExistsException, CardNotValidException {
        // MODIFIES: this
        // EFFECTS: inserisce c nel mazzo
        // lancia CardExistsException se c è già nel mazzo
        // lancia CardNotValidException se c non è valida

        if (c.getNum() < 1 || c.getNum() > 10 || c.getSemeNumero() < 1 || c.getSemeNumero() > 4)
            throw new CardNotValidException("card not valid");
        if (!(this.mazzoRidotto.contains(c)))
            throw new CardExistsException("card already in the deck");

        assert repOk();

    }

    @Override
    public String toString() {
        String ret = "Mazzo ridotto";
        for (Carta carta : mazzoRidotto) {
            ret += "\n\t" + carta;
        }
        return ret;
    }

    public boolean repOk() {
        for (Carta carta : mazzoRidotto) {
            if (carta == null)
                return false;
            if (carta.getNum() < 1 || carta.getNum() > 10 )
                return false;
            if (carta.getSemeNumero() < 1 || carta.getSemeNumero() > 4)
                return false;
        }

        return true;
    }



}
