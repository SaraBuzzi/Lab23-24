public class Punto3D extends Punto2D {
    //OVERVIEW: modella una classe che estende Punto2D con aggiunta di coordinata z 


    //attributi
    public final double z;

    //costruttore
    public Punto3D(double x, double y, double z) {
        //MODIFIES: this
        //EFFECTS: inizializza this con super(x,y) + la coordinata z

        super(x,y);
        this.z = z;
    }




    //metodi
    @Override 
    public String toString() {
        return "(" + super.toString() + ", z: " + this.z + ")";
    }


    //per rispettare il principio della Liskov devo scegliere se non rispettare la proprietà trasitiva oppure quella riflessiva
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Punto3D)) 
            return false;
        Punto2D other = (Punto2D) obj;
        if (this.x != other.x)
            return false;
        if (this.y != other.y)
            return false;
        return true;
        
    }

    
}
