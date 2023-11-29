

public class Contenitore implements Comparable<Contenitore> {
    // OVERVIEW: classe che modella oggetti che possono contenere una certa quantità
    // di liquido, fino ad un massimo pari al proprio volume

    // attributes
    double capienza;
    double liquido;
    final String tipoLiquido;
    boolean pieno; // true se il contenitore è pieno, false altrimenti

    // constructor
    public Contenitore (double capienza, double liquido, String tipoLiquido) throws IllegalArgumentException, ExceededCapacityException{
        //MODIFIES: this
        //EFFECTS: inizializza this con la sua capienza massima, la quantità di liquido presente nel contenitore, il tipo di liquido e se il contenitore è pieno o no
        //lancia IllegalArgumentException se capienza<=0
        //lancia IllegalArgumentException se liquido<0
        //lancia IllegalArgumentException se tipoLiquido == null
        //lancia ExceededCapacityException se liquido > capienza

        if (liquido <= 0)
            throw new IllegalArgumentException("liquido < 0");
        if (tipoLiquido == null)
            throw new IllegalArgumentException("tipoLiquido == null");
        if (liquido > capienza) 
            throw new ExceededCapacityException("il liquido inserito supera la capienza massima del contenitore");

        this.liquido = liquido;
        this.tipoLiquido = tipoLiquido;
        this.pieno = false;

        assert repOk();

    }

    // methods
    public double getCapienza() {
        return capienza;
    }

    public double getLiquido() {
        return liquido;
    }

    public void setLiquido(double liquido) throws ExceededCapacityException {
        // lancia ExceededCapacityException se liquido > this.capienza
        if (liquido > this.capienza)
            throw new ExceededCapacityException("il liquido inserito supera la capienza massima del contenitore");
        this.liquido = liquido;
    }

    public String getTipoLiquido() {
        return tipoLiquido;
    }

    public boolean isPieno() {
        return pieno;
    }

    public void setPieno(boolean pieno) {
        this.pieno = pieno;
    }


    public void addLiquido(double liquido) throws ExceededCapacityException {
        //MODIFIES: this.liquido
        //EFFECTS: aggiunge a this.liquido la quantità inserità 
        // lancia ExceededCapacityException se liquido > this.capienza
        
        this.setLiquido(liquido + this.getLiquido());
    }

    public void versa(Contenitore c) throws IncompatibleLiquidsException{
        //MODIFIES: this
        //EFFECTS: versa il liquido del contenitore c in this
        // liquido > this.capienza
        //lancia IncompatibleLiquidsException se i liquidi dei due contenitori non sono compatibili

        if (!(this.tipoLiquido.equals(c.tipoLiquido)))
            throw new IncompatibleLiquidsException("liquidi non compatibili");
        
        double liquidoDueContenitori = c.liquido + this.liquido;
        //il contenitore di destinazione ha sufficiente capienza rimanente
        try {
            this.addLiquido(c.liquido);
            if (this.liquido == this.capienza) {
                this.setPieno(true); // il contenitore this è pieno
            }

        } catch (ExceededCapacityException e) {
            try {
                this.setLiquido(this.capienza);
                this.setPieno(true);
                c.setLiquido(liquidoDueContenitori-this.capienza);
            } catch (ExceededCapacityException f) {
                //impossibile
            }
            
        }

    }


    @Override
    public int compareTo(Contenitore o) {
        return Double.compare(this.capienza, o.capienza); //ordine decrescente??
    }

    @Override
    public String toString() {
        return "Contenitore (capienza: " + this.capienza + ", contenuto: " + this.liquido + ", liquido: " + this.tipoLiquido + ")";
    }

    public boolean repOk() {
        if (this.capienza <= 0)
            return false;
        if (this.liquido < 0)
            return false;
        if (this.tipoLiquido == null)
            return false;
        if (this.liquido > this.capienza)
            return false;

        return true;
    }
}
