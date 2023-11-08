import java.util.Iterator;

public class Primi implements Iterator<Integer>{
    // OVERVIEW: implementa un iterator standalone che a ogni chiamata di next()
    // restituisca il successivo numero primo

    Integer curr = 2;
    Integer prev;
    
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        for (int i = 2; i < curr; i++) {
            if (curr%i == 0) {
                ;
            }
        }
        prev = curr;
        curr++;
        return prev;
    }

    public static void main(String[] args) {
        Primi p = new Primi();
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            System.out.println(p.next());
        }
    }

}
