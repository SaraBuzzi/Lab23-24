public class Punto2D implements Punto{
    // OVERVIEW: classe che modella un punto in due dimensioni, x e y (numeri razionali)
    //           classe immutabile.

    //attributi
    public final double x,y;  //i valori non potranno essere modificati

    //costruttore
    public Punto2D(double x, double y) {
        //MODIFIES: this
        //EFFECTS: inizializza un punto 2D con i valori x e y
        this.x = x;
        this.y = y;
        
    }

    @Override
    public String toString() {
        return "Punto - x:" + this.x + ", y:" + this.y;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Punto2D other = (Punto2D) obj;
        if (this.x != other.x)
            return false;
        if (this.y != other.y)
            return false;
        return true;
    }

    //non ho bisogno della repOk perchè non c'è modo di sbagliare è IMMUTABILE

    @Override
    public double getX() {
        return x;
    }




    @Override
    public double getY() {
        return y;
    }

    


}
