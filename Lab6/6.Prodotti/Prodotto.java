public class Prodotto {
    //OVERVIEW: classe che modelli prodotti di un negozio, registrandoli con il loro nome e costo
    //          classe immutabile

    //attributes
    final String nome;
    public double costo;
    public int percentuale;

    //constructor
    public Prodotto(String nome, double costo) {
        //MODIFIES: this
        //EFFECTS: inizializza this con nome e costo passati come parametri
        //lancia IllegalArgumentException se nome == null o vuoto 
        //lancia IllegalArgumentException se costo <= 0

        if (nome == null || nome.equals("")) 
            throw new IllegalArgumentException("Nome inserito non valido");
        
        if (costo <= 0) 
            throw new IllegalArgumentException("Costo inserito non valido");
        
        this.nome = nome;
        this.costo = costo;

        assert repOk();
    }


    //methods
    public String getNome() {
        return nome;
    }


    public double getCosto() {
        return costo;
    }

    public int getPercentuale() {
        return percentuale;
    }


    public void setCosto(double costo) {

        if (costo <= 0) 
            throw new IllegalArgumentException("Costo inserito non valido");
        this.costo = costo;
    }

    public double sconto() {
        //EFFECTS: restituisce il valore del prodotto scontato del 5%
        return this.costo - (this.costo*5)/100;
    }


    @Override
    public String toString() {
        return "Prodotto " + nome + " al prezzo " + costo ;
    }


    private boolean repOk() {

        if (nome == null || nome.equals("")) 
            return false;
        
        if (costo <= 0) 
           return false;
        
        return true;
        
    }



}
