import java.util.Iterator;

public class Fibonacci implements Iterator<Integer>{
    // OVERVIEW: implemente un iterator standalone che produce i primi n numeri
    // della sequanza di Fibonacci. n è un valore dato in linea di comando

  
            private int[] result = { 0, 1 };

           
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                //EFFECTS: 

                int temp = this.result[1];
                this.result[1] = this.result[0] + this.result[1];
                this.result[0] = temp;
                return temp;
            }
        
    


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Fibonacci f = new Fibonacci();
        for (int i = 0; i < n; i++) {
            System.out.println(f.next());
        }
    }



}
