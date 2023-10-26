import java.util.ArrayList;
import java.util.Scanner;

public class Piano {
    public static void main(String[] args) {

        ArrayList<Punto> lista = new ArrayList<Punto>();
        Scanner s = new Scanner(System.in);
        
        while (s.hasNext()) {
            Punto p = new Punto(s.nextDouble(), s.nextDouble());
            lista.add(p);
        }

        double distanza;
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i+1; j <= lista.size(); j++) {
                   distanza = lista.get(i).distanza(lista.get(j));
                   
            }
        }


        
        
    }
}
