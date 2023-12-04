public class TrattaBus extends Tratta {
    // OVERVIEW: classe che modella tratte in autobus
    //           estende la classe Tratta

    //attributes
    private final double quantFissoOre;

    //constructor
    public TrattaBus(String origine, String destinazione, double lunPercorso, double velMedia, double quantFissoOre) throws IllegalArgumentException{
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se quantFissoOre <= 0
        
        super(origine, destinazione, lunPercorso, velMedia);

        if (quantFissoOre <= 0)
            throw new IllegalArgumentException("quantitativo fisso non valido");

        this.quantFissoOre = quantFissoOre;
        
    }

    //methods
    public double getQuantFissoOre() {
        return this.quantFissoOre;
    }

    @Override
    public double inquina() {
        return this.durataInOre() * this.quantFissoOre;
    }

    @Override
    public String toString() {
        return "(Bus) " + super.toString() + ", qHr: " + this.quantFissoOre;
    }
    
}
