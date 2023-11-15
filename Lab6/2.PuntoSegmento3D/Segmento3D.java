import java.util.ArrayList;
import java.util.Scanner;

public class Segmento3D extends Segmento2D{
//OVERVIEW: modella un segmento in 3D ottenuto estendendo Segmento2D
//          classe immutabile 

    //costruttore
    public Segmento3D(Punto3D a, Punto3D b) {
        super(a, b);
    }

    //metodi
    @Override
    public Punto3D getA() {
        return (Punto3D) super.getA();
    }

    @Override
    public Punto3D getB() {
        return (Punto3D) super.getB();
    }

    @Override
    public String toString() {
        return "Segmento3D: [a: " + a + ", b: " + b + "]";
    }

    @Override
    public double lenght() {
        //EFFECTS: restituisce la lunghezza di this
        return Math.sqrt(
            Math.pow(this.getA().x - this.getB().x, 2) + 
            Math.pow(this.getA().y - this.getB().y, 2) + 
            Math.pow(this.getA().z, this.getB().z)
            );
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
