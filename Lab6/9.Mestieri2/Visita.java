public class Visita {
    //OVERVIEW: classe che definisce una visita tra un Paziente e un Dottore

    //attributes
    String nomeDottore;
    String codicePaziente;

    //constructor
    public Visita(String nomeDottore, String codicePaziente) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this con i parametri passati
        //lancia IllegalArgumentException se nomeDottore == null o vuoto
        //lancia IllegalArgumentException se codicePaziente == null o vuoto

        if (nomeDottore == null || nomeDottore.equals(" ")) 
            throw new IllegalArgumentException("Inserire il nome del dottore");
        if (codicePaziente == null || codicePaziente.equals(" "))
            throw new IllegalArgumentException("Inserire il codice identificativo del paziente");
        
        this.nomeDottore = nomeDottore;
        this.codicePaziente = codicePaziente;
   }

   //methods
    public String getNomeDottore() {
        return nomeDottore;
    }

    public void setNomeDottore(String nomeDottore) {
        this.nomeDottore = nomeDottore;
    }

    public String getCodicePaziente() {
        return codicePaziente;
    }

    public void setCodicePaziente(String codicePaziente) {
        this.codicePaziente = codicePaziente;
    }

   public boolean repOk() {
        if (nomeDottore == null || nomeDottore.equals(" ")) 
            return false;
        if (codicePaziente == null || codicePaziente.equals(" "))
            return false;
        
        return true;  
   }

   @Override
   public String toString() {
        return "Visita del paziente " + this.codicePaziente + ", effettuata dal dottor " + this.nomeDottore;
   }


}
