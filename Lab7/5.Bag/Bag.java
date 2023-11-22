
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bag <E> implements Iterable<E>{
    //OVERVIEW: modella un beg/multiset generico

    //attributes
    HashMap<E, Integer> map = new HashMap<>();

    //methods
    public void insert(E element) throws NullPointerException{
        //MODIFIES: this
        //EFFECTS: inserisce element in this
        //lancia NullPointerException se element == null

        if (element == null) 
            throw new NullPointerException("element == null");

        Integer currentCount = map.putIfAbsent(element, 1);

        if (currentCount != null) {
            map.replace(element, currentCount+1);
        }

        assert repOk();
    }

    public E pick() throws NoSuchElementException {
        //EFFECTS: restituisce un elemento della Bag
        //lancia NoSuchElementException se this è vuota

        if (this.size() == 0) 
            throw new NoSuchElementException("bag empty");

        return (E) (map.keySet().toArray())[0];
    }

    public void remove(E element) throws NoSuchElementException, NullPointerException {
        //MODIFIES: this
        //EFFECTS: rimuove element da this
        //lancia NoSuchElementException se element non è contentuto in this
        //lancia NullPointerException se element == null

        if (element == null) 
            throw new NullPointerException("element null");
        
        if (!(this.contains(element)))
            throw new NoSuchElementException("element not in the bag");
        
        Integer currentCount = map.get(element);

        if (currentCount == 1) {
            map.remove(currentCount);
        } else {
            map.replace(element, currentCount-1);
        }

    }

    public boolean contains(E element) throws NullPointerException{
        //EFFECTS: restituisce true se element è contenuto in this, false altrimenti
        //lancia NullPointerException se element == null

        if (element == null) 
            throw new NullPointerException("element == null");
        
        return map.containsKey(element);
    }

    public int count(E element) throws NullPointerException{
        //EFFECTS: restituisce il numero di element presenti in this
        //lancia NullPointerException se element == null

        if (element == null) 
            throw new NullPointerException("element null");

        Integer currentCount = map.get(element);
        if (currentCount == null) {
            return 0; 
        }
        return currentCount;

    }

    public int size() {
        //EFFECTS: restituisce il numero di elementi totali di this

        int count = 0;
        for (E element : map.keySet()) {
            count += map.get(element);
        }
        return count;
    }

    public int sizeUnique() {
        //EFFECTS: restituisce il numero di elementi unici di this

        return map.size();
    }

    @Override
    public String toString() {
        String ret = "Bag - elements: [ ";
        for (E element : this) {
            ret += element + " ";
        }
        return ret+= "]";

    }

    public boolean repOk() {
        for (E element : map.keySet()) {
            if (element == null)
                return false;
            if (map.get(element) <= 0)
                return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        
        return new Iterator<E>() {

            Iterator<E> keys = map.keySet().iterator();
            E currentElem = null;
            int count = 1;

            @Override
            public E next() {
                if (!(this.hasNext())) 
                    throw new NoSuchElementException("no more elements");
                
                if (currentElem != null && map.get(currentElem) > count) {
                    count++;
                } else {
                    currentElem = keys.next();
                    count = 1;
                }
                return currentElem;
            }

            @Override
            public boolean hasNext() {
                if (currentElem != null && map.get(currentElem) > count) {
                    return true;
                } else if(keys.hasNext()) {
                    return true;
                }
                return false;
            }
        };
    }

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);

        switch (args[0]) {
            case "String":
                System.out.println("Inserisci Stringhe (CTRL+D per terminare)");
                Bag<String> b = new Bag();
                while(s.hasNext()) {
                    b.insert(s.nextLine());
                }
                System.out.println(b);
                break;
           
            case "Double":
                System.out.println("Inserisci numeri Double (CTRL+D per terminare)");
                Bag<Double> d = new Bag();
                while(s.hasNextDouble()) {
                    d.insert(s.nextDouble());
                }
                System.out.println(d);
                break;
            
            case "Integer":
                System.out.println("Inserisci numeri Interi (CTRL+D per terminare)");
                Bag<Integer> i = new Bag();
                while(s.hasNextInt()) {
                    i.insert(s.nextInt());
                }
                System.out.println(i);
                break;
        }
        
    }
    
}
