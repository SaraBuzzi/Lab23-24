import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Inserisci i film noleggiati nel formato 'nome tipo data' (CTRL+D per terminare)");
    
        Scanner s = new Scanner(System.in);

        ArrayList<Film> films = new ArrayList<>();
        int i = 1;
        while (s.hasNextLine()) {
            String[] el = s.nextLine().split(" ");
            String[] campiData = el[2].split("-");
            LocalDate noleggio = LocalDate.of(
                Integer.parseInt(campiData[2]), 
                Integer.parseInt(campiData[1]), 
                Integer.parseInt(campiData[0])
                );
            Film f = null;

            switch (el[1]) {
                case "Azione":
                    f = new Azione(i, el[0], noleggio);
                    break;
            
                case "Commedia":
                    f = new Commedia(i, el[0], noleggio);
                    break;
            
                case "Dramma":
                    f = new Dramma(i, el[0], noleggio);
                    break;
            }
            films.add(f);
            i++;
        }

        double penaleTot = 0;
        for (Film f : films) {
            penaleTot += f.calcolaPenaleRitardo();
        }

        System.out.println("Penale totale: " + penaleTot + "€");
    }
}
