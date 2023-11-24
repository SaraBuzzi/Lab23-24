public class Cerchio implements Figura{
    //OVERVIEW: classe che implementa oggetti che modellano figure di tipo cerchio
    //          classe non mutabile

    //attributes
    public final double raggio;


    //constructor
    public Cerchio(double r) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this 
        //lancia IllegalArgumentException se r <=0

        if (r <= 0) 
            throw new IllegalArgumentException("base <= 0");
        
        this.raggio = r;

        assert repOk();
    }

    //methods
    public double getRaggio() {
        return raggio;
    }

    @Override
    public String toString() {
        return "Cerchio " + this.raggio + " - Perimetro: " + this.perimetro() + " - Area: " + this.area();
    }

    @Override
    public double perimetro() {
        return this.raggio*2*Math.PI;
    }

    @Override
    public double area() {
        return Math.PI*(Math.pow(this.raggio, 2));
    }


    public boolean repOk() {
        if (raggio <= 0) 
            return false;
        return true;
    }
    
}
