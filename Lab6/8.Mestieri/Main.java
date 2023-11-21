import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        int annoInput = Integer.parseInt(args[0]);
        Scanner s = new Scanner(System.in);
        ArrayList<Dipendente> lista = new ArrayList<>();

        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");
            Dipendente d = new Dipendente(elem[0], 
                                        Double.parseDouble(elem[3]), 
                                        Integer.parseInt(elem[2]), 
                                        elem[1]);
            lista.add(d);
        }

        System.out.println("Dipendenti assunti prima del " + annoInput + ":");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAnnoAssunzione() < annoInput)
                System.out.println(lista.get(i).getNome());
        }
        
    }
}
