public interface PoliticaSconto {
    //OVERVIEW: classe astratta che calcolo uno sconto 
    
    public double calcolaSconto();

    public double getNumeroArticoli();

    public double getPrezzoArticolo();

    public default double prezzoTotaleListino() {
        return getNumeroArticoli() * getPrezzoArticolo();
    }
    
}

