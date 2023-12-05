import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        MazzoRidotto m = null;
        switch (args[0]) {
            case "Mazzo":
                 m = new Mazzo();
                break;
            case "MazzoRidotto":
                 m = new MazzoRidotto();
                break;
        }

        m.mischia();
        System.out.println(m);

        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");

            switch (elem[0]) {
                case "estrai":
                    if (m.hasNext()) {
                        System.out.println("Estratto: " + m.next());
                    } else {
                        System.out.println("Non ci sono più carte nel mazzo");
                    }
                    break;

                case "inserisci":
                    int seme = 0;
                    switch (elem[2]) {
                            case "C":
                                seme = 1;
                                break;
                            case "Q":
                                seme = 2;
                                break;
                            case "F":
                                seme = 3;
                                break;
                            case "P":
                                seme = 4;
                                break;
                        }

                    try {
                        Carta carta = new Carta(Integer.parseInt(elem[1]), seme);
                        m.addCarta(carta);
                        System.out.println("Inserito: " + carta);
                    } catch (CardExistsException | CardNotValidException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }

        m.ordina();
        System.out.println(m);

    }
}
