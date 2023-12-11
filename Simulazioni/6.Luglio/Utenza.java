public abstract class Utenza implements Comparable<Utenza>, Cloneable {
    // OVERVIEW: classe astratta che modella un utenza telefonica

    // attributes
    private final String numero;
    private final String nome;
    private double secondiUsati = 0;

    // constructor
    public Utenza(String nome, String numero) throws IllegalArgumentException, NumberFormatException {
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se nome == null o vuoto
        // lancia IllegalArgumentException se cognome == null o vuoto
        // lancia IllegalArgumentException se numero == null e se non è di 10 cifre
        // lancia NumberFormatException se numero non è composto da cifre (= non è un numero!)

        if (nome == null || nome.equals(" "))
            throw new IllegalArgumentException("nome null o vuoto");
        if (numero == null || numero.length() != 10)
            throw new IllegalArgumentException("numero null o non di 10 cifre");
        try {
            Long num = Long.parseLong(numero);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("numero non composto da cifre");
        }
        
        this.nome = nome;
        this.numero = numero;
    }

    // methods
    public abstract void conversazione(double secondi);

    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public double getSecondiUsati() {
        return secondiUsati;
    }


    public void setSecondiUsati(double secondi) {
        this.secondiUsati += secondi;

        assert repOk();
    }

    @Override
    public String toString() {
        return "Utenza di " + this.getNome() + ", numero: " + this.getNumero() + "; durata: " + this.getSecondiUsati();
    }


    @Override
    public int compareTo(Utenza obj) {
        return Double.compare(this.secondiUsati, obj.getSecondiUsati()); // ordine crescente?
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utenza other = (Utenza) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    public boolean repOk() {
        return secondiUsati > 0;
    }

    @Override
    public Utenza clone() {
        Utenza u = null;
        try {
            u = (Utenza) super.clone();
        } catch (CloneNotSupportedException e) {
           System.out.println(e.getMessage());
        }
        return u;
    }


    
}
