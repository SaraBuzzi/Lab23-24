public class Cavia extends Pet{
    //OVERVIEW: classe che istanzia oggetti di tipo Cavia
    //          estende la classe Pet

    //constructor
    public Cavia(String nome) throws IllegalArgumentException {
        //MODIFIES: this  
        //EFFECTS: inzilizza this attraverso super()
        super(nome); 
        this.verso = "squit";
    }

    //methods
    @Override
    public String toString() {
        return this.nome + " dice " + this.verso;
    }
}
