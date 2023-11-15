import java.util.ArrayList;
import java.util.Scanner;

public class Segmento3D implements Segmento{
    
    private final Punto3D a,b;

    public Segmento3D(Punto3D a, Punto3D b) throws IllegalArgumentException, NullPointerException {
        //MODIFIES: this
        //EFFECTS: inizializza un segmento con il punto a e il punto b
        //lancia NullPointerException se a == null o b == null
        //lancia IllegalArgumentException se a == b

        if (a==null) {
            throw new NullPointerException("a is null");
        }

        if (b ==null) {
            throw new NullPointerException("b is null");
        }
        

        if (a.equals(b)) {
            throw new IllegalArgumentException("a equals b");
        }

        this.a = a;
        this.b = b;
    }

    

    
    public Punto3D getA() {
        return a;
    }


    public Punto3D getB() {
        return b;
    }


    public double lenght() {
        //EFFECTS: restituisce la lunghezza di this
        return Math.sqrt(
            Math.pow(this.a.p.x - this.b.p.x, 2) + 
            Math.pow(this.a.p.y - this.b.p.y, 2) +
            Math.pow(this.a.z - this.b.z, 2)
        );
    }

    @Override
    public String toString() {
        return "Segmento - a: " + a + ", b: " + b;
    }

    public static void main(String[] args) {

        double lenmin = Double.parseDouble(args[0]);

        ArrayList<Segmento3D> sup = new ArrayList<>();

        System.out.println("Inserisci i segmenti nel formato ax ay bx by az bz(temina con CTRL+D)");
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] el = s.nextLine().split(" ");
            Segmento3D seg = new Segmento3D(new Punto3D(Double.parseDouble(el[0]), Double.parseDouble(el[1]), Double.parseDouble(el[2])), 
                                            new Punto3D(Double.parseDouble(el[3]), Double.parseDouble(el[4]), Double.parseDouble(el[5])));

            if (seg.lenght() > lenmin) {
                sup.add(seg);
            }
        }

        System.out.println("Segmenti di lunghezza superiore a " + lenmin);
        for (Segmento3D segmento : sup) {
            System.out.println(segmento);
            System.out.println("Lunghezza: " + segmento.lenght());
        }
    }
}
