public class Cono extends Solido {
    //OVERVIEW: classe concreta che modella un Cono, estendendo la classe Solido 

    private final Double raggio;
    private final Double altezza;

    public Cono(Double raggio, Double altezza) {
        //MODIFIES: this
        //EFFECTS: inizializza l'oggetto Cono con super(tipo), raggio e altezza dati
        //lancia IllegalArgumentException se raggio<=0 o altezza <=0

        super("cono");
        if (raggio<=0 || altezza<=0) {
            throw new IllegalArgumentException("Inserire valori positivi");
        }
        this.raggio = raggio;
        this.altezza = altezza;
    }

    @Override
    public double volume() {
        return ((Math.PI*Math.pow(this.raggio, 2)*this.altezza))/3;
    }

    @Override
    public String toString() {
        return "Cono [raggio=" + raggio + ", altezza=" + altezza + "]";
    }

    
    
}
