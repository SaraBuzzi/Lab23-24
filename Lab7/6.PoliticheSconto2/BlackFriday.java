import java.time.LocalDate;

public class BlackFriday implements PoliticaSconto {
    // OVERVIEW: classe che applica uno sconto in percentuale pari alla data del
    // giorno corrente
    // implementa l'interfaccia PoliticaSconto

    // attributes
    private int numeroArticoli;
    private int prezzoArticolo;
    private int sconto;

    // constructor
    public BlackFriday(int numeroArticoli, int prezzoArticolo) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se numeroArticoli <= 0 o prezzoArticolo <= 0

        if (numeroArticoli <= 0)
            throw new IllegalArgumentException("Numeri Articoli non valido");
        if (prezzoArticolo < 0)
            throw new IllegalArgumentException("Prezzo non valido");
        
        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;
        this.sconto = LocalDate.now().getDayOfMonth();

        assert repOk();

    }

    @Override
    public double calcolaSconto() {
       return ((numeroArticoli*prezzoArticolo) *sconto) /100;
    }

    @Override
    public double getNumeroArticoli() {
        return this.numeroArticoli;
    }

    @Override
    public double getPrezzoArticolo() {
        return this.prezzoArticolo;
    }

    public boolean repOk() {
        if (numeroArticoli <= 0)
            return false;
        if (prezzoArticolo < 0)
            return false;
        return true;

    }

}
