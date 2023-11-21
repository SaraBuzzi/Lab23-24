public class Persona {
    //OVERVIEW: classe che modella una persona attraverso il suo nome

    //attributes
    public final String nome;

    //constructor
    public Persona(String nome) {
        //MODIFIES: this
        //EFFECTS: inizializza this con il paramentro dato
        //lancia IllegalArgumentException se nome == null o vuoto

        if ( nome == null || nome.equals(" "))
            throw new IllegalArgumentException("Inserire un nome valido");

        this.nome = nome;

        assert repOk();
    }

    //methods
    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }

    public boolean repOk() {
        if ( nome == null || nome.equals(" "))
            return false;

        return true;
    }


}
