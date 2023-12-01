import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            AlberoNatalizio albero = new AlberoNatalizio(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
    
            Scanner s = new Scanner(System.in);
            while (s.hasNextLine()) {
                String[] campi = s.nextLine().split(" ");
                try {
                    switch (campi[0]) {
                        case "Decorazione":
                            Decorazione decorazione = new Decorazione(campi[1], Double.parseDouble(campi[2]));
                            albero.addDecorazione(decorazione);
                            break;
                        case "Puntale":
                            Puntale puntale = new Puntale(campi[1], Double.parseDouble(campi[2]));
                            albero.addDecorazione(puntale);
                            break;
                        case "DecorazioneElettrica":
                            DecorazioneElettrica decElettrica = new DecorazioneElettrica(campi[1],
                                    Double.parseDouble(campi[2]), Double.parseDouble(campi[3]));
                            albero.addDecorazione(decElettrica);
                            break;
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("errore in input");
                } catch (IllegalArgumentException | WeightReachedException | TopperExistsException e) {
                    System.out.println(e.getMessage());
                }
    
            }
    
            albero.accendi();
            System.out.println(albero);
        }
    }

