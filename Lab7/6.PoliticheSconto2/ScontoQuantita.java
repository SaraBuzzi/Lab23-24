public class ScontoQuantita implements PoliticaSconto {
    // OVERVIEW: classe che calcolo lo sconto in base alla quantità di articoli
    // acquistati
    // estende PoliticaSconto

    // attributes
    public final int numeroArticoli;
    public final double prezzoArticolo;
    public final int minimo;
    public final double percentuale;

    //constructor
    public ScontoQuantita(int numeroArticoli, double prezzoArticolo, int minimo, double percentuale)
            throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this con i valori di super() e quelli passati come
        // parametri
        // lancia IllegalArgumentException se numArticoli <= 0, prezzoArticolo <= 0, minimo<0 o percentuale<=0
                

        if (numeroArticoli <= 0)
            throw new IllegalArgumentException("Numeri Articoli non valido");
        if (prezzoArticolo < 0)
            throw new IllegalArgumentException("Prezzo non valido");
        if (minimo < 0)
            throw new IllegalArgumentException("Minimo non valido");
        if (percentuale <= 0)
            throw new IllegalArgumentException("Percentuale non valida");


        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;
        this.minimo = minimo;
        this.percentuale = percentuale;

        assert repOk();

    }

    //methods
    @Override
    public double calcolaSconto() {
        // EFFECTS: se la quantità di un articolo acquistato è maggiore o uguale al
        // minimo,restituisce lo sconto di percentuale sul totale.

        if (numeroArticoli >= minimo) {
            return (numeroArticoli*prezzoArticolo) * percentuale/100;
        }
        return 0;
    }

    public boolean repOk() {

        if (numeroArticoli <= 0 || prezzoArticolo <= 0 || minimo < 0 || percentuale < 0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sconto di " + this.calcolaSconto() + " calcolato su " + this.numeroArticoli + "articoli";
    }

    @Override
    public double getNumeroArticoli() {
        return this.numeroArticoli;
    }

    @Override
    public double getPrezzoArticolo() {
        return this.prezzoArticolo;
    }
}
