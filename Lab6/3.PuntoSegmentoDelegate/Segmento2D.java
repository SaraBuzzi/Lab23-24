import java.util.ArrayList;
import java.util.Scanner;

public class Segmento2D implements Segmento{
    //OVERVIEW: modella un segmento in 2D
    //          classe immutabile
    
    //attributi
    public final Punto2D a,b; //non sono tipi primitivi! 

    //costruttore
    public Segmento2D(Punto2D a, Punto2D b) throws IllegalArgumentException, NullPointerException{
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


    public double lenght() {
        //EFFECTS: restituisce la lunghezza di this
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }


    @Override
    public String toString() {
        return "Segmento - a: " + a + ", b: " + b;
    }
   

    
}
