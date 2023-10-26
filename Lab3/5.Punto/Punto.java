public class Punto {
    //OVERVIEW: classe "Punto" i cui oggetti rappresentano punti nel piano cartesiano

    //attributi
    double puntoX;
    double puntoY;

    //construttori
    public Punto(double x, double y) {
        //MODIFIES: this
        //EFFECTS: costruisce l'oggetto punto di coordinate (x,y)

        this.puntoX = x;
        this.puntoY = y;
    }

    public Punto(double x) {
        //MODIFIES: this
        //EFFECTS: costruisce l'oggetto punto di coordinate (x,x)

        this.puntoX = x;
        this.puntoY = x;
    }

    public Punto() {
        //MODIFIES: this
        //EFFECTS: costruisce l'oggetto punto di coordinate (0,0)

        this.puntoX = 0;
        this.puntoY = 0;
    }

    //metodi

    public double getX() {
        return this.puntoX;
    }

    public double getY() {
        return this.puntoY;
    }

    public void setX(double x) {
        //MODIFIES: this
        //EFFECTS: modifica l'ascissa del punto, rendendola uguale a x
        this.puntoX = x;
    }

    public void setY(double y) {
        //MODIFIES: this
        //EFFECTS: modifica l'ascissa del punto, rendendola uguale a x
        this.puntoY = y;
    }

    public void setXY(double x, double y) {
        //MODIFIES: this
        //EFFECTS: modifica le coordinate del punto, rendendole (x,y)
        this.puntoX = x;
        this.puntoY = y;
    }

    public String toString() {
        return "Punto: (" + this.puntoX + " ; " + this.puntoY + ")";
    }

    public boolean equals(Object o) {
        //EFFECTS: resituisce true se il punto p ha le stesse coordinate dell'oggetto su cui il metodo viene chiamato
        return this.equals(o);
    }

    public double distanza(Punto p) {
        //MODIFIES: this
        //EFFECTS: restituisce la distanza euclidea fra il punto p e il punto cu cui viene invocato il metodo
        double diffX = this.puntoX - p.puntoX;
        double diffY = this.puntoY - p.puntoY;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }


    
}
