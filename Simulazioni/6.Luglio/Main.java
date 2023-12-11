import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Operatore operatore = new Operatore(args[0]);

        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci Utenza e comando (add/call/load/reset):");

        try {
            while (s.hasNextLine()) {
                String[] elem = s.nextLine().split(" ");
                switch (elem[1]) {
                    case "add":
                        if (elem[2].equals("Prepagata")) {
                            operatore.addUtenza(new UtenzaPrepagata(elem[3], elem[0]));
                        } else {
                            String[] elemSoglia = elem[2].split("-");
                            operatore.addUtenza(new UtenzaSoglia(elem[3], elem[0], Double.parseDouble(elemSoglia[1])));
                        }
                        break;
                    case "call":
                        operatore.getUtenza(elem[0]).conversazione(Double.parseDouble(elem[2]));
                        break;

                    case "load":
                        if (operatore.getUtenza(elem[0]).getClass() == UtenzaPrepagata.class) {
                            ((UtenzaPrepagata) operatore.getUtenza(elem[0])).ricarica(Double.parseDouble(elem[2]));
                        } else if (operatore.getUtenza(elem[0]).getClass() == UtenzaSoglia.class) {
                            System.out.println("ricarica non supportata");
                            System.exit(1);
                        }
                        break;

                    case "reset":
                        if (operatore.getUtenza(elem[0]).getClass() == UtenzaSoglia.class) {
                            ((UtenzaSoglia) operatore.getUtenza(elem[0])).reset();
                            ;
                        } else if (operatore.getUtenza(elem[0]).getClass() == UtenzaPrepagata.class) {
                            System.out.println("UtenzaPrepagata cannot be cast to UtenzaSoglia");
                            System.exit(1);
                        }
                        break;
                }
            }
        } catch (UtenzaNonValidaException | TempoEsauritoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(operatore);

    }
}
