import javax.swing.text.html.HTMLDocument.Iterator;

public class Matrice implements Iterable<Integer> {
    // OVERVIEW: classe Matrice che modelli una matrice di interi di dimensione n*m,
    // con n e m valori interi passato al costruttore della classe

    //attributi
    int[][] matrice;


    //costruttori
    public Matrice(int n, int m) throws IllegalArgumentException {
        //lancia IllegalArgumentException se n<=0 o m<=0

        if (n<=0 || m<=0) {
            throw new IllegalArgumentException("Valori negativi o uguali a zero non validi")
        }
        this.matrice = new int[n][m];
    }


    //metodi
    public int getNumber(int n, int m) {
        return this.matrice[n][m];
    }


    public void setNumber(int x, int n, int m) {
        x = this.matrice[n][m];
    }
    
    @Override
    public Iterator<Iterator<Integer>> iterator() {
        //EFFECTS: restituisce un iteratore di un iteratore di interi

        return new Iterator<Iterator<Integer>>() {
            //OVERVIEW: 
            //MODIFIES: 

            public boolean hasNext() {

            }

            public Iterator<Integer> next() {

            }

        };
    }

    
}
