import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Mazzo implements Iterator<Carta>{
    //OVERVIEW: classe che modella un mazzo di 52 carte (13 valori per i quattro semi)

    //attributes
    ArrayList<Carta> mazzo = new ArrayList<>();

    //constructor
    public Mazzo() {
        //MODIFIES: this
        //EFFECTS: inzializza il mazzo con tutte le 52 carte possibili

        for (int num = 1; num <= 13; num++) {
            for (int seme = 1; seme <= 4; seme++) {
                mazzo.add(new Carta(num, seme));
            }
        }

        assert repOk();
       
       
    }

    //methods
    public void mischia() {
        //MODIFIES: this
        //EFFECTS: mischia il mazzo mettendo le carte in ordine casuale

        Collections.shuffle(mazzo);
    }

    public void ordina() {
        //MODIFIES: this
        //EFFECTS: riordina il mazzo mettendo le carte nel loro ordine naturale

        mazzo.sort(null);
    }

    public void addCarta(Carta c) throws CardExistsException, CardNotValidException{
        //MODIFIES: this
        //EFFECTS: inserisce c nel mazzo
        //lancia CardExistsException se c è già nel mazzo
        //lancia CardNotValidException se c non è valida

        if (c.getNum() < 1 || c.getNum() > 13)
            throw new CardNotValidException("card number not valid");
        if (c.getSemeNumero() < 1 || c.getSemeNumero() > 4) 
            throw new CardNotValidException("card suits not valid");
        if (!(this.mazzo.contains(c))) 
            throw new CardExistsException("card already in the deck");

        assert repOk();

    }

    @Override
    public String toString() {
        String ret = "Mazzo";
        for (Carta carta : mazzo) {
            ret += "\n\t" + carta;
        }
        return ret;
    }

    public boolean repOk() {
        for (Carta carta : mazzo) {
            if (carta == null)
                return false;
            if (carta.getNum() < 1 || carta.getNum() > 13 )
                return false;
            if (carta.getSemeNumero() < 1 || carta.getSemeNumero() > 4)
                return false;
        }


        return true;
    }

    int curr = 0;

    @Override
    public boolean hasNext() {
        curr++;
        return this.mazzo.size() > 0;
    }

    @Override
    public Carta next() throws NoSuchElementException {
        if (!(hasNext())) {
            throw new NoSuchElementException("there are no cards left in the deck");
        }
        return this.mazzo.remove(curr);
    }

    
    


}
