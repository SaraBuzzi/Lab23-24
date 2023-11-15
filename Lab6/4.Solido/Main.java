import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci il raggio di una sfera");
        Sfera sfera = new Sfera(s.nextDouble());
        System.out.println("Inserisci il raggio e l'altezza di un cono");
        Cono cono = new Cono(s.nextDouble(), s.nextDouble());

       

        switch (sfera.compareTo(cono)) {
            case -1:
                System.out.println("La sfera ha un volume minore del cono");
                break;
            case 1:
                System.out.println("La sfera ha un volume maggiore del cono");
                break;
            case 0:
                System.out.println("I due solidi hanno volume uguale");
                break;
        }

    }
}
