public class ScontoSemplice implements PoliticaSconto {
    // OVERVIEW: classe che implementa una politica di sconto semplice

    // attributes
    public int numeroArticoli;
    public double prezzoArticolo;

    // constructor
    public ScontoSemplice(int numeroArticoli, double prezzoArticolo) {
        // MODIFIES: this
        // EFEFCTS: inizializza l'oggetto this
        //lancia IllegalArgumentException se numeroArticoli <= 0 o prezzoArticolo <= 0

        if (numeroArticoli <= 0)
            throw new IllegalArgumentException("Numeri Articoli non valido");
        if (prezzoArticolo < 0)
            throw new IllegalArgumentException("Prezzo non valido");

        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;

        assert repOk();
    }


    // methods
    public double calcolaSconto() {
        //EFFECTS: restituisce il prezzo degli articoli senza sconto
        return prezzoArticolo * numeroArticoli;
    }
    

    public String toString() {
        return "Sconto generico su " + this.numeroArticoli + " da " + this.prezzoArticolo + " ciascuno";

    }


    public boolean repOk() {
        
        if (numeroArticoli <= 0)
            return false;
        if (prezzoArticolo < 0)
            return false;
        return true;
    }

}

