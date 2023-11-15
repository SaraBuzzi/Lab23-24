public class Punto3D implements Punto{
    //OVERVIEW: modella una classe che estende Punto2D con aggiunta di coordinata z 


    //attributi
    final Punto2D p;
    final double z;

    //costruttore
    public Punto3D(double x, double y, double z) {
        //MODIFIES: this
        //EFFECTS: inizializza this con super(x,y) + la coordinata z

        this.p = new Punto2D(x, y);
        this.z = z;
    }




    //metodi
    @Override 
    public String toString() {
        return "(" + p.toString() + ", z: " + this.z + ")";
    }


    //per rispettare il principio della Liskov devo scegliere se non rispettare la proprietà transitiva oppure quella riflessiva
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Punto3D)) 
            return false;
        Punto3D tmp = (Punto3D) obj;
        if (this.p != tmp.p) 
            return false;
        if (this.z != tmp.z)
            return false;

        return true;
        
    }


    public double getX() {
        return p.getX();
    }

    public double getY() {
        return p.getY();
    }

    public double getZ() {
        return z;
    }


}
