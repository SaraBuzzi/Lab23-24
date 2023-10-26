import java.util.InputMismatchException;

public class Famiglia {
    //OVERVIEW: modella una famiglia con un certo numero di persone e un reddito complessivo

    private double reddito;
    private int dimensione;

    //costruttori
    public Famiglia(double reddito, int dimensione) throws InputMismatchException {
        //MODIFIES: this
        //EFFECTS: inizializza un oggetto Famiglia 
        // if dimensione < 0 throws InputMismatchException
        if (dimensione < 0) {
            throw new InputMismatchException();
        }
        this.reddito = reddito;
        this.dimensione = dimensione;
    }

    //metodi
    public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException {
        //MODIFIES: this
        //EFFECTS: controlla se appartiene alla soglia di povertà
        // if costoCasa < 0 and costoCibo < 0 throws InputMismatchException
        if (costoCasa<0 && costoCibo<0) {
            throw new InputMismatchException();
        }
        return ((costoCasa+costoCibo)*this.dimensione) > (this.reddito/2);

    }

    public String toString() {
        return this.dimensione + " persone con reddito complessivo di " + this.reddito + "\n";
    }
}
