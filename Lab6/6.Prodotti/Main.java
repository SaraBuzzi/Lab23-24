import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci un prodotto nel formato: `<nome> <costo> alimentare <datascadenza>` oppure `<nome> <costo> nondeperibile riciclabile/nonriciclabile`");
        while (s.hasNextLine()) {
            String[] el = s.nextLine().split(" ");
            Prodotto prod = null;
            switch (el[2]) {
                case "alimentare":
                String[] campiData = el[3].split("-");
                prod = new ProdottoAlimentare(
                    el[0], 
                    Integer.parseInt(el[1]), 
                    LocalDate.of(Integer.parseInt(campiData[2]), Integer.parseInt(campiData[1]), Integer.parseInt(campiData[0])));
                    double valoreScontato1 = prod.sconto();
                    System.out.println("Prezzo con sconto del " + prod.getPercentuale() + "%: " + valoreScontato1);
                    break;
                case "nondeperibile":
                prod = new ProdottoNonDeperibile(
                        el[0],
                        Integer.parseInt(el[1]),
                        el[3].equals("riciclabile"));

                double valoreScontato2 = prod.sconto();
                System.out.println("Prezzo con sconto del " + prod.getPercentuale() + "%: " + valoreScontato2);
                break;
                }
            }
        }
    }