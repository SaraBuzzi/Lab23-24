import java.util.ArrayList;
import java.util.Scanner;

public class Segmento2D {
    //OVERVIEW: modella un segmento in 2D
    //          classe immutabile
    
    //attributi
    private final Punto2D a,b; //non sono tipi primitivi! 

    //costruttore
    public Segmento2D(Punto2D a, Punto2D b) {
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


    //metodi
    public Punto2D getA() {
        return a;
    }

    public Punto2D getB() {
        return b;
    }


    public Double lenght() {
        //EFFECTS: restituisce la lunghezza di this
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }


    @Override
    public String toString() {
        return "Segmento2D: [a: " + a + ", b: " + b + "]";
    }

    public static void main(String[] args) {

        double lenmin = Double.parseDouble(args[0]);

        ArrayList<Segmento2D> sup = new ArrayList<>();

        System.out.println("Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)");
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] el = s.nextLine().split(" ");
            Segmento2D seg = new Segmento2D(new Punto2D(Double.parseDouble(el[0]), Double.parseDouble(el[1])), new Punto2D(Double.parseDouble(el[2]), Double.parseDouble(el[3])));

            if (seg.lenght() > lenmin) {
                sup.add(seg);
            }
        }

        System.out.println("Segmenti di lunghezza superiore a " + lenmin);
        for (Segmento2D segmento : sup) {
            System.out.println(segmento);
            System.out.println("Lunghezza: " + segmento.lenght());
        }
    }
   

    
}
