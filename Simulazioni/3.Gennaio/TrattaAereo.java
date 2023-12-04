public class TrattaAereo extends Tratta {
    // OVERVIEW: classe che modella una tratta in aereo
    //           estende la classe Tratta

    //attributes
    private final double quantFissoKM;
    private final double fissoDecollo;

    //constructor
    public TrattaAereo(String origine, String destinazione, double lunPercorso, double velMedia, double quantFissoKM, double fissoDecollo) throws IllegalArgumentException{
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se quantFissoKM <= 0
        // lancia IllegalArgumentException se fissoDecollo <= 0
        
        super(origine, destinazione, lunPercorso, velMedia);

        if (quantFissoKM <= 0)
            throw new IllegalArgumentException("quantitativo fisso non valido");
        if (fissoDecollo <= 0)
            throw new IllegalArgumentException("fisso per il decollo non valido");

        this.quantFissoKM = quantFissoKM;
        this.fissoDecollo = fissoDecollo;
        
    }

    //methods
    public double getQuantFisso() {
        return this.quantFissoKM;
    }

    @Override
    public double inquina() {
        return this.fissoDecollo + this.quantFissoKM * this.getLunPercorso();
    }

    @Override
    public String toString() {
        return "(Aereo) " + super.toString() + ", qKm: " + this.quantFissoKM + ", qFix: " + this.fissoDecollo;
    }
}
