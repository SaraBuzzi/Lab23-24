import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Matrice implements Iterable<Iterator<Integer>> {
    // OVERVIEW: classe Matrice che modelli una matrice di interi di dimensione n*m,
    // con n e m valori interi passato al costruttore della classe

    //attributi
    int[][] matrice;


    //costruttori
    public Matrice(int n, int m) throws IllegalArgumentException {
        //lancia IllegalArgumentException se n<=0 o m<=0

        if (n<=0 || m<=0) {
            throw new IllegalArgumentException("Valori negativi o uguali a zero non validi");
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

            int currentRow = 0;

            public boolean hasNext() {
                return currentRow < matrice.lenght;
            }

            public Iterator<Integer> next()  {
                // EFFECTS: restituisce un iterator che itera sugli elementi dell' i-esima riga
                // della matrice, fino a quando non terminano

                if (!hasNext())
                    throw new NoSuchElementException("La matrice non ha ulteriori righe");

                // Purtroppo devo salvarmi il valore di currentRow per usarlo nel return, prima
                // di incrementarlo
                int row = currentRow++;

                return new Iterator<Integrer>() {
                    
                    int currentEl = 0;

                    @Override
                    public boolean hasNext() {
                        return currentEl < matrix[row].length;
                    }

                    @Override
                    public Integer next() {
                        if (!hasNext())
                            throw new NoSuchElementException("La riga della matrice non ha ulteriori elementi");

                        return matrix[row][currentEl++];
                    }
                };
            }

        };
    }


    public static void main(String[] args) {
        
        try {
            Matrice matrice = new Matrice(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
