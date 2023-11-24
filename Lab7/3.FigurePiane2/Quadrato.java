public class Quadrato implements Figura{
     //OVERVIEW: classe che implementa oggetti che modellano figure di tipo quadrato
    //          classe non mutabile

    //attributes
    public final double lato;


    //constructor
    public Quadrato(double l) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this 
        //lancia IllegalArgumentException se l <= 0

        if (l <= 0) 
            throw new IllegalArgumentException("lato <= 0");

        
        this.lato = l;

        assert repOk();
    }

    //methods
    public double getLato() {
        return lato;
    }

    @Override
    public String toString() {
        return "Quadrato " + this.lato + " - Perimetro: " + this.perimetro() + " - Area: " + this.area();
    }

    @Override
    public double perimetro() {
        return (this.lato*4);
    }

    @Override
    public double area() {
        return Math.pow(this.lato, 2);
    }


    public boolean repOk() {
        if (lato <= 0) 
            return false;
        return true;
    }
    
}
