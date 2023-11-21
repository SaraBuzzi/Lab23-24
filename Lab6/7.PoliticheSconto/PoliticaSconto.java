public abstract class PoliticaSconto {
    //OVERVIEW: classe astratta che calcolo uno sconto 

    public int numeroArticoli;
    public double prezzoArticolo;

    public PoliticaSconto(int numeroArticoli, double prezzoArticolo ) {
        //MODIFIES: this
        //EFEFCTS: inizializza l'oggetto this

        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;
    }
    
    public abstract double calcolaSconto();
}

