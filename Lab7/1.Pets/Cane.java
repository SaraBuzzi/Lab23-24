public class Cane extends Pet{
    //OVERVIEW: classe che istanzia oggetti di tipo Cane
    //          estende la classe Pet

    //constructor
    public Cane(String nome) throws IllegalArgumentException {
        //MODIFIES: this  
        //EFFECTS: inzilizza this attraverso super()
        super(nome);
        this.verso = "bau";
        
    }

    //methods
    @Override
    public String toString() {
        return this.nome + " dice " + this.verso;
    }
    
}
