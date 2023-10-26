import java.util.ArrayList;
import java.util.Scanner;

public class Rubrica {
    public static void main(String[] args) throws IllegalArgumentException {

        Scanner s = new Scanner(System.in);
        ArrayList<Contatto> rubrica = new ArrayList<Contatto>();
        while (s.hasNext()) {
            String[] campi = s.nextLine().split(" ");
            try {
                if (campi.length == 4) {
                    Contatto c = new Contatto(campi[0], campi[1], campi[2], campi[3]);
                    rubrica.add(c);
                } else {
                    Contatto c = new Contatto(campi[0], campi[1]);
                    rubrica.add(c);
                }
                
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<Contatto> uguali = new ArrayList<Contatto>();
        for (int i = 0; i < rubrica.size(); i++) {
            for (int j = i+1; j < rubrica.size(); j++) {
                if (rubrica.get(i).equals(rubrica.get(j))) {
                    uguali.add(rubrica.get(i));
                }
            }
        }

        if (uguali.isEmpty()) {
            System.out.println("Non ci sono contatti uguali");
        } else {
            System.out.println("Contatti uguali:");
            for (Contatto c : uguali) {
                System.out.println(c);
            }
        }
        
    }
}
