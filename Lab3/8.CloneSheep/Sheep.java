import java.util.ArrayList;
import java.util.Scanner;

public class Sheep implements Cloneable {
    // OVERVIEW: modella una classe Sheep, definita da un nome e da un attributo
    // dna, contenente una serie di stringhe che definiscono i codici dna dei
    // diversi cromosomi della p1

    // attributi
    String nome;
    ArrayList<String> dna = new ArrayList<String>();

    // construttori
    public Sheep(String nome) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza un'oggetto Sheep con il nome dato
        // se il nome è null o vuoto lancia IllegalArgumentException

        if (nome == null || nome.equals(""))
            throw new IllegalArgumentException("Inserire un nome valido");

        this.nome = nome;
    }

    // metodi
    public String getNome() {
        return nome;
    }

    public void aggiungiCrom(String c) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: aggiunge la stringa c alla lista dna dell'oggetto this
        // se la stringa è null, vuota lancia IllegalArgumentException

        if (c == null || (c).equals("")) {
            throw new IllegalArgumentException("Inserire un codice dna valido");
        }

        this.dna.add(c);
    }

    public String getCrom(int i) throws IndexOutOfBoundsException {
        // EFFECTS: restituisce il(c) in posizione i del dna dell'oggetto this
        // se l'array dna non contiene l'indice i o i<0, 
        // lancia IndexOutOfBoundsException

        if (i >= dna.size() || (i<0)) {
            throw new IndexOutOfBoundsException("indice non esistente");
        }
        return dna.get(i);
    }

    public void modificaCrom(int i, String c) throws IndexOutOfBoundsException{
        // MODIFIES: this
        // EFFECTS: sostituisce la string all'indice i nella lista dna, 
        // con la stringa c
        // se se l'array dna non contiene l'indice i o i<0, 
        // lancia IndexOutOfBoundsException

        if (i >= dna.size() || (i<0)) {
            throw new IndexOutOfBoundsException("indice non esistente");
        }

        this.dna.set(i, c);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sheep other = (Sheep) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (dna == null) {
            if (other.dna != null)
                return false;
        } else if (!dna.equals(other.dna))
            return false;
        return true;
    }

    @Override
    public Object clone() {
        Sheep nuovo = null;
        try {
            nuovo = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            nuovo = new Sheep(nome);
        }
        nuovo.dna = (ArrayList<String>) this.dna.clone();
        return nuovo;
    }


    public static void main(String[] args) {
        Sheep p1 = null;
        try {
            p1 = new Sheep(args[0]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Inserisci i cromosomi, uno per riga (terminare con CTRL+D):");
        Scanner s = new Scanner(System.in);
        
        while (s.hasNextLine()) {
            try {
                p1.aggiungiCrom(s.nextLine());
            } catch (IllegalArgumentException e) {
               System.out.println(e.getMessage());
            }
            
        }

        Sheep p2 = (Sheep) p1.clone();

        System.out.println("Ho creato un clone di " + p1.getNome());

        controlla(p1, p2);

        System.out.println("Inserisci il cromosoma da modificare ed il nuovo codice:");
        s = new Scanner(System.in);
        try {
            p2.modificaCrom(s.nextInt(), s.next());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        

        controlla(p1, p2);
    
    }


    public static void controlla(Sheep p1, Sheep p2) {
        if (p1.equals(p2)) {
            System.out.println("Le due pecore sono uguali");
        } else {
            System.out.println("Le due pecore sono diverse");
        }
    }


}
