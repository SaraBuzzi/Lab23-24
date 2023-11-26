public class ScontoCombinato implements PoliticaSconto{
     // OVERVIEW: Politica di Sconto Combinata da due ScontoSemplice.
    // Le due politiche di sconto ScontoSemplice devono avere stesso numeroArticoli
    // e prezzoArticolo.
    // Implementa PoliticaSconto

    //attributes
    ScontoSemplice politica1;
    ScontoSemplice politica2;

    //constructor
    public ScontoCombinato(ScontoSemplice politica1, ScontoSemplice politica2) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this
        //lancia IllegalArgumentException se politica1 == null o se politica2 == null

        if (politica1 == null)
            throw new IllegalArgumentException("politica 1 == null");
        if (politica2 == null)
            throw new IllegalArgumentException("politica 2 == null");
        
        this.politica1 = politica1;
        this.politica2 = politica2;

        assert repOk();
    }


    //methods
    @Override
    public double calcolaSconto() {
        //EFFECTS: restituisce il valore massimo di sconto tra le due politiche 

        double d1 = politica1.calcolaSconto();
        double d2 = politica2.calcolaSconto();

        if (d1 > d2)
            return d1;
        return d2;
    }

    @Override
    public String toString() {
        return "Politica di sconto combinato di " + this.calcolaSconto();
    }

    private boolean repOk() {
        if (politica1 == null)
            return false;
        if (politica2 == null)
            return false;
        return true;
    }
    
}
