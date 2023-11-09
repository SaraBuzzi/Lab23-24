import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu implements Iterable<Piatto> {
    //OVERVIEW: classe Menu che contiene una serie di oggetti di tipo Piatto

    //attributi
    ArrayList<Piatto> piatti;

    //costruttore
    public Menu() {
        //MODIFIES: this
        //EFFECTS: inizializza l'oggetto Menu

        piatti = new ArrayList<>();

        assert repOk();
    }

    //metodi



    
    public void addPiatto(Piatto p) throws IllegalArgumentException, AlreadyInTheMenuExeption{
        //MODIFIES: this
        //EFFECTS: aggiunge l'oggetto p al menù
        //lancia IllegalArgumentException se p == null
        //lancia AlreadyInTheMenuExeption se p è già presente nel menù

        if (p == null) {
            throw new IllegalArgumentException("Piatto inserito non valido");
        }

        if (piatti.contains(p)) {
            throw new AlreadyInTheMenuExeption("Piatto già inserito nel menù");
        }

        piatti.add(p);

        assert repOk();
    }

    public void remPiatto(String nome, String tipo, int costo) throws IllegalArgumentException, NoSuchElementException{
        //MODIFIES: this
        //EFFECTS: rimuove dal menù l'oggetto specificato dai valori nome, tipo e costo
        //lancia NoSuchElementException se p non è nel menù

        Piatto p = new Piatto(nome, tipo, costo);

        if (piatti.contains(p)) {
            throw new NoSuchElementException("Piatto non presente nel menù");
        }

        piatti.remove(p);

        assert repOk();
    }

    public boolean repOk() {
        if (piatti == null) {
            return false;
        }

        for (Piatto piatto : piatti) {
            if (piatto == null) {
                return false;
            }
            if (piatti.indexOf(piatto) == piatti.lastIndexOf(piatto)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<Piatto> iterator() {
        //EFFECTS: restituisce un iteratore che scorre il menù, un piatto alla volta

        return new Iterator<Piatto>() {
            Iterator<Piatto> p = piatti.iterator();

            @Override
            public boolean hasNext() {
                return p.hasNext();
            }

            @Override
            public Piatto next() {
                return p.next();
            }
        };
    }



    public Iterator<Piatto> iterator(String tipo) {
        //EFFECTS: restituisce un iteratore che scorre solo p piatti del menù del tipo specificato (primo o secondo)
        //lancia IllegalArgumentExeption se tipo == null, vuoto, != primo o != secondo

        if (tipo == null || !(tipo.equals("primo") || tipo.equals("secondo"))) {
            throw new IllegalArgumentException("Inserire il tipo del piatto");
        }

        return new Iterator<Piatto>() {

            int curr = 0;
            @Override
            public boolean hasNext() {
                for (int p = curr; p < piatti.size(); p++) {
                    if (piatti.get(p).getTipo().equals(tipo)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Piatto next() {
                for (int p = curr; p < piatti.size(); p++) {
                    if (piatti.get(p).getTipo().equals(tipo)) {
                        curr = p+1;
                        return piatti.get(p);
                    }
                }
                throw new NoSuchElementException("Gli elementi di tipo" + tipo + " sono terminati");
            }
        };
    }


    public static void main(String[] args) {
        Menu menu = new Menu();

        System.out.println("Aggiungi p piatti nel formato: nome tipo costo (terminare la lettura con CTRL+D):");
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] elem = s.nextLine().split(" ");
            Piatto p = new Piatto(elem[0], elem[1], Integer.parseInt(elem[2].substring(0,elem[2].length()-1)));

            try {
                menu.addPiatto(p);
            } catch (IllegalArgumentException | AlreadyInTheMenuExeption e) {
                System.out.println(e.getMessage());
            }
        }

        Iterator<Piatto> primi = menu.iterator("primo");
        System.out.println("Primi:");
        while (primi.hasNext()) {
            System.out.println(primi.next());
        }

        Iterator<Piatto> sec = menu.iterator("secondo");
        System.out.println("Secondi:");
        while(sec.hasNext()) {
            System.out.println(sec.next());
        }

    }
    


    


}
