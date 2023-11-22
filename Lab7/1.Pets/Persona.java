import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Persona implements Iterable<Pet>{
    //OVERVIEW: classe che modella una persona identificata da un nome. la persona può avere diversi animali domestici

    //attributes
    final String nome;
    ArrayList<Pet> animali = new ArrayList<>();

    //constructor
    public Persona (String nome) {
        //MODIFIES: this
        //EFFECTS: inizializza this
        //lancia IllegalArgumentException se nome == null o vuoto

        if (nome == null || nome.equals(" "))
        throw new IllegalArgumentException("nome null o vuoto");

        this.nome = nome;
    }

    //methods
    public void addAnimal(Pet animal) throws NullPointerException {
        //MODIFIES: this
        //EFFECTS: aggiunge animal a this
        //lancia NullPointerException se animal == null

        if (animal == null) 
            throw new NullPointerException("animal == null");
        
        animali.add(animal);


    }

    public void remAnimal(Pet animal) throws NullPointerException, NoSuchElementException {
        //MODIFIES: this
        //EFFECTS: rimuove animal da this
        //lancia NullPointerException se animal == null
        //lancia NoSuchElementException se animal non è presente in this

        if (animal == null) 
            throw new NullPointerException("animal == null");
        if (!(animali.contains(animal)))
            throw new NoSuchElementException("animal is not in the list");
        
        animali.remove(animal);

    }

    public String coroAnimali() {
        //EFFECTS: restituisce come string la lista di animali domestici di this con i loro versi

        String ret = "Il coro degli animali di " + this.nome + ":\n";
        for (Pet pet : animali) {
            ret += pet + "\n";
        }
        return ret;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public Iterator<Pet> iterator() {
        
        return new Iterator<Pet>() {

            Iterator<Pet> i =  animali.iterator();

            @Override
            public boolean hasNext() {
              return i.hasNext();  
            }

            @Override
            public Pet next() {
                return i.next();
            }

        };
        
    }

}
