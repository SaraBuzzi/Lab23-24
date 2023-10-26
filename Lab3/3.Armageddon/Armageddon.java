import java.util.ArrayList;
import java.util.Scanner;

public class Armageddon {
    public static void main(String[] args) {
        double soglia = Double.parseDouble(args[0]);
        ArrayList<Asteroide> pericolosi = new ArrayList<Asteroide>();

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            try {
                Asteroide a = new Asteroide(s.nextDouble(), s.nextDouble());
                try {
                    if (a.forzaGravitazionale() > soglia ) {
                        pericolosi.add(a);
                    }
                } catch (DivideByZeroException e) {
                    System.out.println(e.getMessage());
                }
            } catch (IllegalArgumentException f) {
                System.out.println(f.getMessage());
            }
        }
        stampaPericolosi(pericolosi);
    }

    public static void stampaPericolosi(ArrayList<Asteroide> p) {
        for (int i = 0; i < p.size(); i++) {
            System.out.println("Asteroide pericoloso a distanza " + p.get(i).getDist() + "km del peso di " + p.get(i).getMassa() + "kg");
        }
    }
}
