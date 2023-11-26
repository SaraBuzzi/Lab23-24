import java.util.ArrayList;

public class Massimo<U>{
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

    public static void main(String[] args) {
        
        
    }
}
