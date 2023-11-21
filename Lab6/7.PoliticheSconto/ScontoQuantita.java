public class ScontoQuantita extends PoliticaSconto {
    // OVERVIEW: classe che calcolo lo sconto in base alla quantità di articoli
    // acquistati
    // estende PoliticaSconto

    // attributes
    private final int minimo;
    private final double percentuale;

    //constructor
    public ScontoQuantita(int numeroArticoli, double prezzoArticolo, int minimo, double percentuale)
            throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this con i valori di super() e quelli passati come
        // parametri
        // lancia IllegalArgumentException se minimo<0 o percentuale<0
        super(numeroArticoli, prezzoArticolo);

        if (minimo < 0 || percentuale < 0)
            throw new IllegalArgumentException("Inserire valori positivi");

        this.minimo = minimo;
        this.percentuale = percentuale;

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

}
