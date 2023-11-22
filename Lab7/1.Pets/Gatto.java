public class Gatto extends Pet{
    //OVERVIEW: classe che istanzia oggetti di tipo Gatto
    //          estende la classe Pet

    //constructor
    public Gatto(String nome) throws IllegalArgumentException {
        //MODIFIES: this  
        //EFFECTS: inzilizza this attraverso super()
        super(nome); 
        this.verso = "miao";
    }
    
    //methods
    @Override
    public String toString() {
        return this.nome + " dice " + this.verso;
    }
}
