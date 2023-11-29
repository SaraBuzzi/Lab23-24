import javax.swing.DefaultDesktopManager;

public class DecorazioneElettrica extends Decorazione implements Comparable<DecorazioneElettrica>{
    //OVERVIEW: classe che modella decorazioni elettriche
    //          classe che estende Decorazione
    //attributes
    double potenza;
    boolean interuttore;

    //constructor
    public DecorazioneElettrica(String nome, double peso, double potenza) throws IllegalArgumentException {
        //MODIFIES:this
        //EFFECTS: inziializza this
        //lancia IllegalArgumentException se potenza <= 0

        super(nome, peso);
        
        if (potenza <= 0)
            throw new IllegalArgumentException("potenza <= 0");

        this.potenza = potenza;
        this.interuttore = false;

        assert repOk();
    }

    //methods
    public double getPotenza() {
        return potenza;
    }

    public void setPotenza(double potenza) throws IllegalArgumentException{

        if (potenza <= 0)
            throw new IllegalArgumentException("potenza <= 0");

        this.potenza = potenza;
    }

    public boolean isInteruttore() {
        return interuttore;
    }

    public void setInteruttore(boolean interuttore) {
        this.interuttore = interuttore;
    }


  
    @Override
    public String toString() {
        if (this.interuttore)
            return super.toString() + " potenza: " + this.potenza + ", accesa";
        return super.toString() + " potenza: " + this.potenza + ", spenta";
    }

    
    public boolean repOk() {
        if (potenza <= 0)
            return false;
        return true;
    }

    @Override
    public int compareTo(DecorazioneElettrica d) {
        return Double.compare(d.potenza, this.potenza);
    }

    @Override
    protected DecorazioneElettrica clone() {
        DecorazioneElettrica d = new DecorazioneElettrica(nome, peso, potenza);
        return d ;
    }

    
}
