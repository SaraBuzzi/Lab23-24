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
        while (!primo(this.curr)) {
            this.curr++;
        }

        return this.curr++;
    }


    public static boolean primo(int n) {
        // EFFECTS: ritorna true n è primo.
        // Nota: il primo numero primo è 2

        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Primi p = new Primi();
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            System.out.println(p.next());
        }
    }

}
