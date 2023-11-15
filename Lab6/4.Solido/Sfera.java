public class Sfera extends Solido {
//OVERVIEW: classe concreta che modella una Sfera, estendendo la classe Solido 

    private final Double raggio;

    public Sfera(double raggio) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza l'oggetto Sfera con super(tipo) e raggio
        //lancia IllegalArgumentException se raggio<=0 

        super("sfera");
        if (raggio<=0) {
            throw new IllegalArgumentException("Inserire valori positivi");
        }
        this.raggio = raggio;
        
    }
    

    @Override
    public double volume() {
        return 4/3*(Math.PI*Math.pow(this.raggio,3));
    }


    @Override
    public String toString() {
        return "Sfera [raggio=" + raggio + "]";
    }

    



    
}
