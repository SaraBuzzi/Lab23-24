public class Puntale extends Decorazione{
    //OVERVIEW: classe che modella un puntale
    //          classe che estende Decorazione

    //constructor
    public Puntale(String nome, double peso) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this

        super(nome, peso);
    }

    //methods
    @Override
    public String toString() {
        return super.toString() + ", puntale";
    }


}
