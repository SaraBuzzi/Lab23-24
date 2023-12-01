public class Decorazione implements Cloneable{
    //OVERVIEW: classe che modella oggeti che rappresentano decorazioni natalizie

    //attributes
    private final String nome;
    private final double peso;

    //constructor
    public Decorazione(String nome, double peso) throws IllegalArgumentException{
        //MODIFIES:
        //EFFECTS:
        //lancia IllegalArgumentException se nome == null o vuoto
        //lancia IllegalArgumentException se peso <=0

        if (nome == null || nome.equals(" ")) 
            throw new IllegalArgumentException("nome == null o vuoto");
        if (peso <= 0)
            throw new IllegalArgumentException("peso <= 0");

        this.nome = nome;
        this.peso = peso;

    }

    //methods
    public String getNome() {
        return this.nome;
    }

    public double getPeso() {
        return this.peso;
    }

    @Override
    public String toString() {
        return "Decorazione: " + this.nome + "; peso: " + this.peso;
    }

    @Override
    protected Decorazione clone() {
        Decorazione d = new Decorazione(nome, peso);
        return d;
    }

    

    
    

}
