public class UtenzaSoglia extends UtenzaPrepagata {
    // OVERVIEW: classe che modella un'utenza telefonica con una soglia
    // estende la classe UtenzaPrepagata (così da utilizzare il parametro credito
    // residuo come soglia che decrementa)

    // attributes
    private final double sogliaSettimanale;

    // constructor
    public UtenzaSoglia(String nome, String numero, double sogliaSettimanale)
            throws IllegalArgumentException, NumberFormatException {
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se sogliaSettimanale <= 0

        super(nome, numero);

        if (sogliaSettimanale < 0)
            throw new IllegalArgumentException("soglia < 0");

        this.sogliaSettimanale = sogliaSettimanale;
        this.reset();

        assert repOk();

    }

    // methods
    public void reset() {
        // MODIFIES: this
        // EFFECTS: resetta la soglia di secondi disponibili settimanalmente

        this.setCreditoResiduo(sogliaSettimanale);
    }

    @Override
    public String toString() {
        return super.toString() + ", soglia: " + this.sogliaSettimanale;
    }
 
    @Override 
    public boolean repOk() {
        if (this.sogliaSettimanale < 0)
            return false;
        return super.repOk();
    }


}
