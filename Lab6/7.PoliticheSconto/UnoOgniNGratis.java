public class UnoOgniNGratis extends ScontoSemplice {
    //OVERVIEW: classe che modella una politica di sconto tale che ogni n-esimo articolo sia gratuito
    //          classe che estende PoliticaSconto

    //attributes
    int n;

    //constructor
    public UnoOgniNGratis(int numeroArticoli, double prezzoArticolo, int n) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this con i valori di super() più l'attributo n
        //lancia IllegalArgumentException se n<=0
        super(numeroArticoli, prezzoArticolo);

        if (n<=0)
            throw new IllegalArgumentException("Inserire un valore positivo");

       this.n = n;

       assert repOk();
    }

    //methods
    @Override
    public double calcolaSconto() {
        //EFFECTS: restituisce uno sconto totale ogni n-esimo articolo acquistato

        return (numeroArticoli / n) * prezzoArticolo;
    }

    @Override
    public boolean repOk() {

        if (n<=0)
            return false;
        return super.repOk();
    }

    @Override
    public String toString() {
        return "Sconto di " + this.calcolaSconto() + ". Uno ogni " + this.n + " gratis";
    }
    
}
