

public class DecorazioneElettrica extends Decorazione implements Comparable<DecorazioneElettrica>{
    //OVERVIEW: classe che modella decorazioni elettriche
    //          classe che estende Decorazione
    //attributes
    final double potenza;
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

    }

    //methods
    public double getPotenza() {
        return potenza;
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

    

    @Override
    public int compareTo(DecorazioneElettrica d) {
        return Double.compare(this.potenza, d.getPotenza() ); //ordine crescente
    }


    
}
