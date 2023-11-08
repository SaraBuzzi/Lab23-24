import java.util.Scanner;

public class Orario {
    // OVERVIEW: classe Orario che rappresenta un'orario con un valore delle ore tra
    // 0 e 23 e dei minuti tra 0 e 59.

    // attributi
    int ora;
    int min;

    // costruttori
    public Orario() {
        // MODIFIES: this
        // EFFECTS: inizializza this con ore e minuti, entrambi a 0

        this.ora = 0;
        this.min = 0;
    }

    public Orario(int ora, int min) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this con ore e minuti dati
        //se ore non è compreso nel range [0-23] e minuti nel range [0-59] lancia IllegalArgumentException

        if (ora<0 || ora>23 || min<0 || min>59) {
            throw new IllegalArgumentException("Orario non valido");
        }
        this.ora = ora;
        this.min = min;
    }

    public Orario(int ora, int min, boolean PM) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this con ore, minuti dati e un valore booleano che
        // specifica se l'orario è di mattina(false) o pomeriggio(true)
        // se ore non è compreso nel range [1-12] e minuti nel range [0-59] lancia
        // IllegalArgumentException

        if (ora < 1 || ora > 12 || min < 0 || min > 59) {
            throw new IllegalArgumentException("Orario non valido");
        }

        this.ora = ora; // lo stato della classe può anche essere inconsistente prima della fine del
                        // metodo

        if (PM)
            if (ora < 12)
                this.ora += 12;
            else if (ora == 12)
                this.ora = 0;

        this.min = min;

    }

    // metodi
    public int getOra() {
        return ora;
    }

    public int getMin() {
        return min;
    }

    public void avanza(int ora, int min) throws IllegalArgumentException{
        // MODIFIES: this
        // EFFECTS: fa avanzare l'orario di ora e minuti specificati, gestendo
        // opportunamente il cambio dell'ora
        // se ore non è compreso nel range [1-23] e minuti nel range [0-59] lancia
        // IllegalArgumentException

        if (ora < 1 || ora > 23 || min < 0 || min > 59) {
            throw new IllegalArgumentException("Orario inserito non valido");
        }

        int mintot = (this.ora+ora) * 60 + (this.min+min);

		this.min = mintot%60;
		this.ora = (mintot/60)%24;

    }

    public String getOra24() {
        //EFFECTS: restituisce una stringa che rappresenta l’orario nel formato a 24 ore (hh:mm)
        return this.ora + ":" + this.min;
    }

    public String getOra12() {
        //EFFECTS: restituisce le ore in una notazione a 12 ore (h:mm xx) dove xx è AM o PM
        if (this.ora==12) {
            return "12:" + this.min + " PM";
        } else if (this.ora == 0) {
            return "00:" + this.min + " AM"; 
        } else if (this.ora > 12) {
            return this.ora-12 + ":" + this.min + " PM";
        }
        return this.ora + ":" + this.min + " AM";
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Orario other = (Orario) obj;
        if (ora != other.ora)
            return false;
        if (min != other.min)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Orario o = new Orario();
        if (args.length > 0) {
            String[] e = args[0].split(":");

            try {
                if (args.length == 1) {
                    o = new Orario(Integer.parseInt(e[0]), Integer.parseInt(e[1])); 
                } else if (args.length == 2) {
                    if (args[2].equals("AM")) {
                        o = new Orario(Integer.parseInt(e[0]), Integer.parseInt(e[1]), false);
                    } else if (args[2].equals("PM")) {
                        o = new Orario(Integer.parseInt(e[0]), Integer.parseInt(e[1]), true);
                    }
                }
            } catch (IllegalArgumentException f) {
                System.out.println(f.getMessage());
                System.exit(1);
            }
        }
            
            System.out.println("Orario: " + o.getOra24());
            System.out.println("Orario: " + o.getOra12());

            Scanner s = new Scanner(System.in);
            String[] e2 = s.nextLine().split(" ");
            o.avanza(Integer.parseInt(e2[1]), Integer.parseInt(e2[2]));

            System.out.println("Orario: " + o.getOra24());
            System.out.println("Orario: " + o.getOra12());
        
    }

}
