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

    //metodi

    public double getX() {
        return this.puntoX;
    }

    public double getY() {
        return this.puntoY;
    }

    public void setXY(double x, double y) {
        //MODIFIES: this
        //EFFECTS: modifica le coordinate del punto, rendendole (x,y)
        this.puntoX = x;
        this.puntoY = y;
    }


    public Punto scostaPunto(Punto p, double x, double y) {
        return new Punto(p.getX()+x, p.getY()+y);
    }

    public double distanza(Punto p) {
        //MODIFIES: this
        //EFFECTS: restituisce la distanza euclidea fra il punto p e il punto cu cui viene invocato il metodo
        double diffX = this.puntoX - p.puntoX;
        double diffY = this.puntoY - p.puntoY;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }


    
}
