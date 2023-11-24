import java.util.NoSuchElementException;

public class Triangolo implements Figura {
    //OVERVIEW: classe che implementa oggetti che modellano figure di tipo triangolo
    //          classe non mutabile

    //attributes
    public final double lato1,lato2,lato3;


    //constructor
    public Triangolo(double l1, double l2, double l3) throws IllegalArgumentException, NoSuchElementException{
        //MODIFIES: this
        //EFFECTS: inizializza this 
        //lancia IllegalArgumentException se l1, l2 o l3 sono <= 0
        //lancia NoSuchElementException se i tre lati non formano un triangolo

        if (l1 <= 0) 
            throw new IllegalArgumentException("lato1 <= 0");
        if (l2 <= 0)
            throw new IllegalArgumentException("lato2 <= 0");
        if (l3 <= 0)
            throw new IllegalArgumentException("lato3 <= 0");
        
        if (l1 + l2 <= l3 || l1 + l3 <= l2 || l2 + l3 <= l1)
            throw new NoSuchElementException("I 3 lati non formano un triangolo");
        
        this.lato1 = l1;
        this.lato2 = l2;
        this.lato3 = l3;

        assert repOk();
    }

    //methods
    public double getLato1() {
        return lato1;
    }

    public double getLato2() {
        return lato2;
    }

    public double getLato3() {
        return lato3;
    }

    

    @Override
    public String toString() {
        return "Triangolo " + this.lato1 + " " + this.lato2 + " " + this.lato3 + " - Perimetro: " + this.perimetro() + " - Area: " + this.area();
    }

    @Override
    public double perimetro() {
        return this.lato1 + this.lato2 + this.lato3;
    }

    @Override
    public double area() {
        double s = perimetro()/2;
        return Math.sqrt(s * (s - lato1) * (s - lato2) * (s - lato3)); 
    }


    public boolean repOk() {
        if (lato1 <= 0) 
            return false;
        if (lato2 <= 0)
            return false;
        if (lato3 <= 0)
            return false;
        if (lato1 + lato2 <= lato3 || lato1 + lato3 <= lato2 || lato2 + lato3 <= lato1)
            return false;
        return true;
    }
    
}
