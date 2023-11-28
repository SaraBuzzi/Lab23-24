import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Massimo<U extends Comparable<U>> {
    // OVERVIEW: classe generica che istanzia una struttrura dati in cui inserire
    // elementi e tenere traccia dell'elemento più grande

    //attributes
    ArrayList<U> lista = new ArrayList<>();

    //methods
    public void insert(U element) throws NullPointerException, IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inserisce element in this
        //lancia NullPointerException se element == null
        //lancia IllegalArgumentExeption se element è già nella lista

        if (element == null) 
            throw new NullPointerException("element == null");
        if (lista.contains(element))
            throw new IllegalArgumentException("element already in the list");

        lista.add(element);
    }

    public U max() {
        //EFFECTS: restituisce il valore massimo presente nella lista in this
        
        U max = lista.get(0);

        for (U u : lista) {
            if (u.compareTo(max) > 0) {
                max = u;
            }
        }

        return max;
    }

    public U max(Comparator<U> c) {
          
        U max = lista.get(0);

        for (U u : lista) {
            if (c.compare(u, max) > 0) {
                max = u;
            }
        }
        return max;
    }

    

    

    public static void main(String[] args) {

        System.out.println("Inserisci Stringhe (CTRL+D per terminare)");
        Scanner s = new Scanner(System.in);

        Massimo<String> lista = new Massimo<>();
        while (s.hasNextLine()) {

            try {
                lista.insert(s.nextLine());
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        String maxLunghezza = lista.max(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {    
                return Integer.compare(o1.length(), o2.length());
            }
            
        });

        System.out.println("Massimo (lessicografico): " + lista.max());
        System.out.println("Massimo (lunghezza): " + maxLunghezza);


    }
}
