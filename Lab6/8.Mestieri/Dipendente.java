public class Dipendente extends Persona {
    //OVERVIEW: classe che modella le schede dei dipendenti di un'azienda
    //          classe che estende Persona

    //attributes
    private double retribuzioneAnnuale;
    private final int annoAssunzione;
    private String codiceId;

    //constructor
    public Dipendente(String nome, double retribuzioneAnnuale, int annoAssunzione, String codiceId) {
        //MODIFIES: this
        //EFFECTS: inizializza this con i parametri passati
        //lancia IllegalArgumentExeption se retribuzioneAnnuale <= 0
        //lancia IllegalArgumentExeption se annoAssunzione <= 0
        //lancia IllegalArgumentExeption se codiceId == null o vuoto

        super(nome);

        if (retribuzioneAnnuale <= 0)
            throw new IllegalArgumentException("Retribuzione annuale <= 0");
        if (annoAssunzione <= 0)
            throw new IllegalArgumentException("Anno di assunzione <= 0");
        if (codiceId == null || codiceId.equals(" "))
            throw new IllegalArgumentException("Codice ID nullo o vuoto");

        this.retribuzioneAnnuale = retribuzioneAnnuale;
        this.annoAssunzione = annoAssunzione;
        this.codiceId = codiceId;

        assert repOk();
    }


    //methods
    public double getRetribuzioneAnnuale() {
        return retribuzioneAnnuale;
    }

    public void setRetribuzioneAnnuale(double retribuzioneAnnuale) {
        this.retribuzioneAnnuale = retribuzioneAnnuale;
    }

    public int getAnnoAssunzione() {
        return annoAssunzione;
    }

    public String getCodiceId() {
        return codiceId;
    }

    public void setCodiceId(String codiceId) {
        this.codiceId = codiceId;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCodice ID: " + this.codiceId + "\nAnno di assunzione : " + this.annoAssunzione + "\nRetribuzione annuale: " + this.retribuzioneAnnuale;
    }

    @Override
    public boolean repOk() {
        if (retribuzioneAnnuale <= 0)
            return false; 
        if (annoAssunzione <= 0)
            return false; 
        if (codiceId == null || codiceId.equals(" "))
            return false;
        
        return true;
    }
    
}
