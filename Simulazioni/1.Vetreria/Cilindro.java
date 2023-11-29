

public class Cilindro extends Contenitore{
    //OVERVIEW: classe che modella contenitori di tipo cilindro
    //          classe che estende Contenitore

    //attributes
    private final double raggio;
    private final double altezza;

    //constructor
    public Cilindro(double liquido, String tipoLiquido, double raggio, double altezza)
            throws IllegalArgumentException, ExceededCapacityException {
        //MODIFIES: this
        //EFFECTS: inizializza this inserendo la sua capienza massima (==volume) calcolata con i parametri raggio e altezza
        //lancia IllegalArgumentException se raggio <= 0 o altezza <= 0

        super((Math.PI * altezza * (Math.pow(raggio,2))), liquido, tipoLiquido);

        if (raggio <= 0) 
            throw new IllegalArgumentException("raggio <= 0");
        if (altezza <= 0)
            throw new IllegalArgumentException("altezza <= 0");

        this.raggio = raggio;
        this.altezza = altezza;

        assert repOk();
    }

    //methods
    @Override
    public String toString() {
        return super.toString().replace("Contenitore (capienza: ", "Cilindro - altezza: " + this.altezza + ", raggio: " + this.raggio + " (capienza: ");
    }

    @Override
    public boolean repOk() {
        if (this.raggio <= 0) 
            return false;
        if (this.altezza <= 0)
            return false;
        return super.repOk();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        

    }
    
}
