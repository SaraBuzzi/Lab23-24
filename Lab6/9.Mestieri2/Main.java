import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Inserisci medici nel formato 'nome specializzazione parcella' (termina con CTRL+D)");
        Scanner s = new Scanner(System.in);
        ArrayList<Dottore> listaDottori = new ArrayList<>();

        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");
            Dottore doc = new Dottore(elem[0], elem[1], Double.parseDouble(elem[2]));
            listaDottori.add(doc);
        }

        Scanner p = new Scanner(System.in);
        System.out.println("Inserisci pazienti nel formato 'nome codiceID' (termina con CTRL+D)");
        ArrayList<Paziente> listaPazienti = new ArrayList<>();

        while (p.hasNextLine()) {
            String[] elem = p.nextLine().split(" ");
            Paziente paz = new Paziente(elem[0], elem[1]);
            listaPazienti.add(paz);
        }

        Scanner b = new Scanner(System.in);
        System.out.println("Inserisci visite nel formato 'nomeDottore codiceIDPaziente' (termina con CTRL+D)");
        ArrayList<Visita> listaVisite = new ArrayList<>();

        while (b.hasNextLine()) {
            String[] elem = b.nextLine().split(" ");
            Visita vis = new Visita(elem[0], elem[1]);
            listaVisite.add(vis);
        }


        
        System.out.println("I guadagni del mese sono:");
        for (Dottore dott : listaDottori) {
            int guadagnoTot = 0;
            for (Visita visita : listaVisite) {
                if (dott.nome.equals(visita.nomeDottore)) {
                    guadagnoTot += dott.parcella;
                }
            }
            if (guadagnoTot != 0) {
                System.out.println(dott.nome + " " + guadagnoTot);
            }
            
        }
    }
}

