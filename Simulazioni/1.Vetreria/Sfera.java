

public class Sfera extends Contenitore{
    //OVERVIEW: classe che modella contenitori di tipo sfera
    //          classe che estende Contenitore

    //attributes
    private final double raggio;

    //constructor
    public Sfera(double liquido, String tipoLiquido, double raggio)
            throws IllegalArgumentException, ExceededCapacityException {
        //MODIFIES: this
        //EFFECTS: inizializza this inserendo la capienza massima (==volume) calcolata con il parametro raggio
        //lancia IllegalArgumentException se raggio <= 0

        super(Math.PI * (Math.pow(raggio,3)) * (4./3), liquido, tipoLiquido);

        if (raggio <= 0) 
            throw new IllegalArgumentException("raggio <= 0");
        
        this.raggio = raggio;

        assert repOk();
    }


    //methods
    @Override
    public String toString() {
        return super.toString().replace("Contenitore (capienza: ", "Sfera - raggio: " + this.raggio + " (capienza: ");
    }

    @Override
    public boolean repOk() {
        if (this.raggio <= 0) 
            return false;
        return super.repOk();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sfera s = null;
        try {
            s = new Sfera(getLiquido(), getTipoLiquido(), raggio);
        } catch (ExceededCapacityException e) {
            // Impossibile
        }
        return s;
    }
    
}
