public class UtenzaPrepagata extends Utenza {
    // OVERVIEW: classe che modella un'utenza telefonica prepagata con un credito
    // estende la classe Utenza

    // attributes
    private double creditoResiduo = 0;

    // constructor
    public UtenzaPrepagata(String nome, String numero) throws IllegalArgumentException, NumberFormatException {
        // MODIFIES: this
        // EFFECTS: inizializza this
        super(nome, numero);
    }

    // methods
    public double getCreditoResiduo() {
        return creditoResiduo;
    }

    public void setCreditoResiduo(double creditoResiduo) throws IllegalArgumentException {
        // lancia IllegalArgumentException se creditoResiduo < 0

        if (creditoResiduo < 0)
            throw new IllegalArgumentException("credito < 0");

        this.creditoResiduo = creditoResiduo;

        assert repOk();
    }
    
    public void ricarica(double credito) {
        // MODIFIES: this
        // EFFECTS: aggiunge al credito di this il parametro credito

        this.creditoResiduo += credito;

        assert repOk();
    }

    public void conversazione(double secondi) throws TempoEsauritoException {
        // MODIFIES: this
        // EFFECTS: decrementa il credito residuo di this in base alla conversazioni
        // effettuata e aggiorna il numero di secondi di conversazione effettuati
        // lancia TempoEsauritoException se si cerca di effettuare conversazioni più
        // lunghe del credito residuo

        if (secondi > this.creditoResiduo) 
            throw new TempoEsauritoException("TempoEsauritoException: credito esaurito");

        this.setSecondiUsati(secondi);
        this.creditoResiduo -= secondi;

        assert repOk();
    }

    @Override
    public String toString() {
        return super.toString() + ", credito: " + this.creditoResiduo;
    }


    @Override
    public boolean repOk() {
        if (this.getSecondiUsati() > creditoResiduo)
            return false;
        if (creditoResiduo < 0)
            return false;
        return super.repOk();
    }





}
