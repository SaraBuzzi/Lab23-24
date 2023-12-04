
// import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        Tratta t = null;
        Percorso p = new Percorso();
        // ArrayList<Percorso> percorsiTot = new ArrayList<>(); AVERE PIU' PERCORSI??
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");
    
            try {
                switch (elem[0]) {
                    case "TrattaTreno":
                        t = new TrattaTreno(elem[1], elem[2], Double.parseDouble(elem[3]), Double.parseDouble(elem[4]), Double.parseDouble(elem[5]));
                        break;
                    case "TrattaBus":
                        t = new TrattaBus(elem[1], elem[2], Double.parseDouble(elem[3]), Double.parseDouble(elem[4]), Double.parseDouble(elem[5]));
                        break;
                    case "TrattaAereo":
                        t = new TrattaAereo(elem[1], elem[2], Double.parseDouble(elem[3]), Double.parseDouble(elem[4]), Double.parseDouble(elem[5]), Double.parseDouble(elem[6]));
                        break;
                }

                p.addTratta(t);

            } catch (IllegalArgumentException | TrattaNonValidaException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(p);
    }
}
