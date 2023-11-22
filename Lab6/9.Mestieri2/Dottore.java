public class Dottore extends Persona {
    //OVERVIEW: classe in cui oggetti sono medici di una clinica, con una specializzazione e una parcella per le visite
    //          classe che estende Persona
    
    //attributes
    public final String specializ;
    public final double parcella;
    
    //constructor
    public Dottore(String nome, String specializ, double parcella) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this con il nome da super(), una specializzazione e una parcella passati come valori
        //lancia IllegalArgumentException se specializ == null o vuoto
        //lancia IllegalArgumentException se parcella <= 0
        
        super(nome);

        if (specializ == null || specializ.equals(" "))
            throw new IllegalArgumentException("Inserire una specializzazione");
        if (parcella <= 0)
            throw new IllegalArgumentException("Inserire una parcella");

        this.specializ = specializ;
        this.parcella = parcella;

        assert repOk();
    }

    //methods
    public String getSpecializ() {
        return specializ;
    }

    public double getParcella() {
        return parcella;
    }

    @Override
    public String toString() {
        return super.toString().replace("Nome", "Dottore: ") + "\nSpecializzazione: " + this.specializ + "\nParcella: " + this.parcella;
    }

    @Override
    public boolean repOk() {
        if (specializ == null || specializ.equals(" "))
            return false;
        if (parcella <= 0)
            return false;
        
        return true;
    }

    

    
    
}
