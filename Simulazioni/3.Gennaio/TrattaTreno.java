public class TrattaTreno extends Tratta {
    // OVERVIEW: classe che modella una tratta in treno
    //           estende la classe Tratta

    //attributes
    private final double quantFissoKM;

    //constructor
    public TrattaTreno(String origine, String destinazione, double lunPercorso, double velMedia, double quantFissoKM) throws IllegalArgumentException{
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se quantFissoKM <= 0
        
        super(origine, destinazione, lunPercorso, velMedia);

        if (quantFissoKM <= 0)
            throw new IllegalArgumentException("quantitativo fisso non valido");

        this.quantFissoKM = quantFissoKM;
        
    }

    //methods
    public double getQuantFisso() {
        return this.quantFissoKM;
    }

    @Override
    public double inquina() {
        return this.getLunPercorso() * this.quantFissoKM;
    }

    @Override
    public String toString() {
        return "(Treno) " + super.toString() + ", qKm: " + this.quantFissoKM;
    }

}
