public class Ora {
    // OVERVIEW: classe Orario che rappresenta un'orario con un valore delle ore tra
    // 0 e 23 e dei minuti tra 0 e 59.

    // attributi
    int ore;
    int min;

    // construttori
    public Orario() {
        //MODIFIES: this
        //EFFECTS: inizializza this con ore e minuti, entrambi a 0

        this.ore = 0;
        this.min = 0;
    }

    public Orario(int ore, int min) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this con ore e minuti dati
        //se ore non è compreso nel range [0-23] e minuti nel range [0-59] lancia IllegalArgumentException

        if (ore<0 || ore>23 || min<0 || min>59) {
            throw new IllegalArgumentException("Orario non valido")
        }
        this.ore = ore;
        this.min = min;
    }

    public Orario(int ore, int min, boolean PM) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this con ore, minuti dati e un valore booleano che specifica se l'orario è di mattina(false) o pomeriggio(true)
        //se ore non è compreso nel range [1-12] e minuti nel range [0-59] lancia IllegalArgumentException

        if (ore<1 || ore>12 || min<0 || min>59) {
            throw new IllegalArgumentException("Orario non valido");
        }

        
    }

    // metodi
}
