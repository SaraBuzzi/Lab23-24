public class Paziente extends Persona {
    //OVERVIEW: classe in cui oggetti sono i pazienti di una clinica, con un codice identificativo
    
    //attributes
    public final String codiceId;
    
    //constructor
    public Paziente(String nome, String codiceId) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this con il nome da super() e un codice identificativo 
        //lancia IllegalArgumentException se codiceId == null o vuoto
    
        super(nome);

        if (codiceId == null || codiceId.equals(" "))
            throw new IllegalArgumentException("Inserire una specializzazione");
    

        this.codiceId = codiceId;

        assert repOk();
    }

    //methods
    public String getCodiceId() {
        return codiceId;
    }

    @Override
    public String toString() {
        return super.toString().replace("Nome", "Paziente: ") + "\nCodice identificativo: " + this.codiceId ;
    }

    @Override
    public boolean repOk() {
        if (codiceId == null || codiceId.equals(" "))
            return false;
    
        
        return true;
    }

}
