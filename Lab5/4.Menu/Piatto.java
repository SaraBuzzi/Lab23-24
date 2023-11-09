public class Piatto {
    //OVERVIEW: classe che rappresenti un piatto di un meno con il suo nome, tipo (primo, secondo) e costo

    //attributi
    String nome;
    String tipo;
    int costo;

    //costruttori
    public Piatto(String n, String b, int d) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza un oggetto di tipo Piatto con i valori n (nome), b (tipo) e d(costo)
        //lancia IllegalArgumentExeption se n == null o è vuoto
        //lancia IllegalArgumentExeption se b == null, vuoto, != primo o != secondo
        //lancia IllegalArgumentException se d <= 0

        if (n == null || n.equals("")) {
            throw new IllegalArgumentException("Inserire un nome valido");
        }

        if (b == null || !(b.equals("primo") || b.equals("secondo"))) {
            throw new IllegalArgumentException("Inserire il tipo del piatto");
        }

        if (d <= 0) {
            throw new IllegalArgumentException("Inserire un costo valido");
        }

        this.nome = n ;
        this.tipo = b;
        this.costo = d;
    }

    //metodi
    @Override 
    public String toString() {
        return this.nome + " " + this.tipo + " " + this.costo + "€";
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCosto() {
        return costo;
    }


    
}


