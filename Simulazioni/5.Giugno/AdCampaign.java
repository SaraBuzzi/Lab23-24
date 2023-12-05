public abstract class AdCampaign implements Comparable<AdCampaign> {
    // OVERVIEW: classe astratta che definisce una campagnia pubblciictaria,
    // identificata da un nome

    //attributes
    public final String nome;
    private boolean aperta = true; // true == campagna aperta, false == campagna chiusa

    //constructor
    public AdCampaign(String nome) {
        //MODIFIES: this
        //EFFECTS: inzializza this
        // lancia IllegalArgumentException se nome == null o vuoto

        if (nome == null || nome.equals(" "))
            throw new IllegalArgumentException("nome inserito non valido");

        this.nome = nome;

    }

    //methods
    public abstract double performance();

    public void chiudi() {
        //MODIFIES: this
        //EFFECTS: chiude la campagna modificando il parametro aperta a false

        this.aperta = false;
    }


    public String getNome() {
        return nome;
    }

    public boolean isAperta() {
        return aperta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AdCampaign)
            if (this.nome.equals(((AdCampaign) obj).getNome()))
                return true;
        return false;
    }

    public abstract Object clone();


    @Override
    public String toString() {
        return "AdCampaign nome: " + this.nome + " performance: " + this.performance();
    }


    @Override
    public int compareTo(AdCampaign o) {
        return Double.compare(o.performance(), this.performance());
    }

   // CI VUOLE IL CLONE PER LA ADD????

    
}
