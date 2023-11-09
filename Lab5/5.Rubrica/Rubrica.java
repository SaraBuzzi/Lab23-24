import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Rubrica implements Iterable<Contatto> {
    //OVERVIEW: classe che implementa una Rubrica contenente diversi Contatti

    //attributi
    ArrayList<Contatto> rubrica;

    //costruttori
    public Rubrica() {
        //MODIFIES: this
        //EFFECTS: inizializza una rubrica vuota

        rubrica = new ArrayList<>();
    }

    //metodi
    public void addContatto(Contatto c) throws IllegalArgumentException, ContattoInRubricaException{
        //MODIFIES: this
        //EFFECTS: aggiunge l'oggetto c alla rubrica
        //lancia IllegalArgumentException se c == null
        //lancia ContattoInRubricaException se c è già presente in rubrica

        if (c==null) {
            throw new IllegalArgumentException();
        }
        if (rubrica.contains(c)) {
            throw new ContattoInRubricaException("Il contatto è già stato precedentemente inserito");
        }

        rubrica.add(c);
    }

    public void remContatto(String nome, String cognome) throws NoSuchElementException{
        //MODIFIES: this
        //EFFECTS: rimuove dalla rubrica il contatto corrispondente al nome e cognome dati
        //lancia NoSuchElementException se c non è presente nella rubrica

        Contatto c = new Contatto(nome, cognome);
        if (!rubrica.contains(c)) {
            throw new NoSuchElementException("Contatto non esistente");
        }

        rubrica.remove(c);
    }

    @Override
    public Iterator<Contatto> iterator() {
        //EFFECTS: restituisce un iteratore per scorrere i contatti della rubrica

        return new Iterator<Contatto>() {
            Iterator<Contatto> c = rubrica.iterator();

            @Override
            public boolean hasNext() {
                return c.hasNext();
            }

            @Override
            public Contatto next() {
                return c.next();
            }
            
        };
    }

    public static void main(String[] args) {

    }

    
}
