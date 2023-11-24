public class Rettangolo implements Figura {
    //OVERVIEW: classe che implementa oggetti che modellano figure di tipo rettangolo
    //          classe non mutabile

    //attributes
    public final double base;
    public final double altezza;


    //constructor
    public Rettangolo(double b, double h) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this 
        //lancia IllegalArgumentException se b <= 0 o h <=0

        if (b <= 0) 
            throw new IllegalArgumentException("base <= 0");
        if (h <= 0)
            throw new IllegalArgumentException("altezza <= 0");
        
        this.altezza = h;
        this.base = b;

        assert repOk();
    }

    //methods
    public double getBase() {
        return base;
    }

    public double getAltezza() {
        return altezza;
    }

    @Override
    public String toString() {
        return "Rettangolo " + this.base + " " + this.altezza + " - Perimetro: " + this.perimetro() + " - Area: " + this.area();
    }

    @Override
    public double perimetro() {
        return (this.altezza*2)+(this.base*2);
    }

    @Override
    public double area() {
        return this.altezza*this.base;
    }


    public boolean repOk() {
        if (base <= 0) 
            return false;
        if (altezza <= 0)
            return false;
        return true;
    }
    
}
