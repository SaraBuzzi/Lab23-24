public class UnoOgniNGratis implements PoliticaSconto {
    //OVERVIEW: classe che modella una politica di sconto tale che ogni n-esimo articolo sia gratuito
    //          classe che estende PoliticaSconto

    //attributes
    public final int numeroArticoli;
    public final double prezzoArticolo;
    private int n;

    //constructor
    public UnoOgniNGratis(int numeroArticoli, double prezzoArticolo, int n) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this con i valori di super() più l'attributo n
        //lancia IllegalArgumentException se numArticoli <= 0, prezzoArticolo <= 0 o n<=0
        
        if (numeroArticoli <= 0)
            throw new IllegalArgumentException("Numeri Articoli non valido");
        if (prezzoArticolo < 0)
            throw new IllegalArgumentException("Prezzo non valido");
        if (n<=0)
            throw new IllegalArgumentException("Inserire un valore positivo");

        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;
        this.n = n;

       assert repOk();
    }

    //methods
    @Override
    public double calcolaSconto() {
        //EFFECTS: restituisce uno sconto totale ogni n-esimo articolo acquistato

        return (numeroArticoli / n) * prezzoArticolo;
    }

    public boolean repOk() {

        if (numeroArticoli <= 0 || prezzoArticolo <= 0 || n<=0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sconto di " + this.calcolaSconto() + ". Uno ogni " + this.n + " gratis";
    }

    @Override
    public double getNumeroArticoli() {
        return this.numeroArticoli;

    @Override
    public double getPrezzoArticolo() {
        return this.prezzoArticolo;
    }
    
}
