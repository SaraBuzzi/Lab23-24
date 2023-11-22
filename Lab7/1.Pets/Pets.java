import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        
        System.out.println("Inserisci righe nel formato 'nomePersona nomeAnimale tipoAnimale' (terminare con CTRL+D)");
        Scanner s = new Scanner(System.in);
        ArrayList<Persona> listaPersone = new ArrayList<>();

        while (s.hasNextLine()) {
            try {
                String[] elem = s.nextLine().split(" ");
                Pet a = null;
                Persona pers = new Persona(elem[0]);
                if (!(listaPersone.contains(pers))) {
                    listaPersone.add(pers);
                } 
                switch (elem[2]) {
                    case "Cane":
                        a = new Cane(elem[1]);
                        break;
                    case "Gatto":
                        a = new Gatto(elem[1]);
                        break;
                    case "Cavia":
                        a = new Cavia(elem[1]);
                        break;
                }
                listaPersone.get(listaPersone.indexOf(pers)).addAnimal(a);
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) { //NumberFormatExpression 
                System.out.println("Input errato");
            }

        }

        for (Persona persona : listaPersone) {
            System.out.println(persona.coroAnimali());
        }
    }
}
