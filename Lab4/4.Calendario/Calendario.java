import java.sql.Date;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calendario {
    // OVERVIEW: classe Calendario per gestire un calendario eventi

    // attributi
    ArrayList<Evento> eventi;

    // costruttore
    public Calendario(Evento e) {
        // MODIFIES: this
        // EFFECTS: aggiunge a this l'elemento e
        eventi = new ArrayList<Evento>();
    }

    public Calendario() {
        // MODIFIES: this
        // EFFECTS: inizializza this senza elementi
        eventi = new ArrayList<Evento>();
    }

    // metodi
    public ArrayList<Evento> getCal() {
        return eventi;
    }

    public void addEvento(Evento e) throws NullPointerException, EventoDuplicatoException {
        // MODIFIES: this
        // EFFECTS: aggiunge a this un evento e
        // se e è nullo lancia NullPointerException
        // lancia EventoDuplicatoException se è già presente in this un evento uguale

        if (e == null)
            throw new NullPointerException("Evento non può essere nullo");
        if (eventi.contains(e))
            throw new EventoDuplicatoException("Evento già presente in calendario");

        eventi.add(e);
    }

    public void deleteEvento(Date data, String nome) throws IllegalArgumentException, NoSuchElementException {
        // MODIFIES: this
        // EFFECTS: rimuove da this l'evento con le caratteristiche specificate
        // se data e nome sono null o vuoti lancia IllegalArgumentException
        // se this non contiene un evento con le caratteristiche specificate lancia
        // NoSuchElementException

        if (data == null || nome == null) {
            throw new IllegalArgumentException("inserire valori validi");
        }

        if (nome.equals("")) {
            throw new IllegalArgumentException("nome vuoto non valido");
        }

        Evento e = new Evento(data, nome);

        if (!eventi.remove(e)) {
            throw new NoSuchElementException("evento non esistente");
        }
    }

    public void copiaEvento(Evento e, int n) throws NullPointerException {
        // MODIFIES: this
        // EFFECTS: aggiunge a this l'evento e ma modificandone la data a n giorni di
        // distanza
        // lancia NullPointerException se e è nullo
        // lancia IllegalArgumentException se n <= 0

        if (e == null) {
            throw new NullPointerException("evento inserito nullo");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("valore negativo non valido");
        }

        eventi.add(e.copiaEvento(n));

    }

    @Override
    public String toString() {
        String ret = "Calendario: (\n";
        for (Evento evento : eventi) {
            ret += "\t\t" + evento.toString() + "\n";
        }

        return ret + ")";
    }

    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        System.out.println("Inserisci +/-/* NomeEvento gg/mm/aaaa [offset] (termina con CTRL+D)");

        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");
            String nome = elem[1];
            String[] campiData = elem[2].split("/");
            Date data = new Date(Integer.parseInt(campiData[2]) - 1900,
                    Integer.parseInt(campiData[1]),
                    Integer.parseInt(campiData[0]));

            try {
                switch (elem[0]) {
                    case "+":
                        calendario.addEvento(new Evento(data, nome));
                        break;
                    case "-":
                        calendario.deleteEvento(data, nome);
                        break;
                    case "*":
                        calendario.copiaEvento(new Evento(data, nome), Integer.parseInt(elem[3]));
                        break;
                    default:
                        System.out.println("Input non valido");
                }
            } catch (NullPointerException | IllegalArgumentException | EventoDuplicatoException
                    | NoSuchElementException f) {
                System.out.println(f.getMessage());
            }

        }

        System.out.println(calendario);

    }

}