public abstract class Pet {
    //OVERVIEW: classe astratta che definisce un animale domestico

    //attributes
    String nome;
    String verso = "";

    //constructor
    public Pet(String nome) throws IllegalArgumentException {
        //MODIFIES:
        //EFFECTS:
        //lancia IllegalArgumentException se nome == null o vuoto
        //lancia IllegalArgumentException se verso == null 

        if (nome == null || nome.equals(" "))
            throw new IllegalArgumentException("nome null o vuoto");
        if (verso == null)
            throw new IllegalArgumentException("verso null");   
        this.nome = nome;

        assert repOk();
    }

    //methods
    public String getNome() {
        return this.nome;
    }

    public String getVerso() {
        return this.verso;
    }

    public void verso(){
        System.out.println(this.verso);
    }

    public boolean repOk() {
        if (nome == null || nome.equals(" "))
            return false;
        if (verso == null)
            return false;   

        return true;
    }

    @Override
    public String toString() {
        return "Nome animale: " + this.nome;
    }

}
