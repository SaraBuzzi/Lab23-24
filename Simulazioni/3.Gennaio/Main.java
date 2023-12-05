
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Tratta t = null;
        Percorso p = new Percorso();
        ArrayList<Percorso> percorsi = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");
            try {
                switch (elem[0]) {
                    case "-":
                        percorsi.add(new Percorso(p));
                        p = new Percorso();
                        break;
                    case "TrattaTreno":
                        t = new TrattaTreno(elem[1], elem[2], Double.parseDouble(elem[3]), Double.parseDouble(elem[4]),
                                Double.parseDouble(elem[5]));
                        p.addTratta(t);
                        break;
                    case "TrattaBus":
                        t = new TrattaBus(elem[1], elem[2], Double.parseDouble(elem[3]), Double.parseDouble(elem[4]),
                                Double.parseDouble(elem[5]));
                        p.addTratta(t);
                        break;
                    case "TrattaAereo":
                        t = new TrattaAereo(elem[1], elem[2], Double.parseDouble(elem[3]), Double.parseDouble(elem[4]),
                                Double.parseDouble(elem[5]), Double.parseDouble(elem[6]));
                        p.addTratta(t);
                        break;
                }

            } catch (IllegalArgumentException | TrattaNonValidaException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            percorsi.add(new Percorso(p));
        } catch (NullPointerException | TrattaNonValidaException e ) {
            System.out.println(e.getMessage());
        }

        for (Percorso percorso : percorsi) {
            System.out.println(percorso);
        }
    }
}
