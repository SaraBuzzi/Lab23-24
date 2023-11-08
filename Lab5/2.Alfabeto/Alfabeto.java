import java.util.InputMismatchException;
import java.util.Iterator;

public class Alfabeto implements Iterator<Character> {
    // OVERVIEW: implementa un iterator standalone che a ogni chiamata next()
    // restituiscta una successiva lettera dell'alfabeto

    Character first;
    Character last;
    Character curr;


    //costruttore
    public Alfabeto() {
        this.first = 'a';
        this.last = 'z';
    }

    public Alfabeto(Character c1, Character c2) throws InputMismatchException{
        //lancia IllegalArgumentException se la prima lettera inserita è successiva alla seconda
        //lancia InputMismatchException se l'input inserito non è valido
    

        if (c1 < 97 || c1 > 122) {
            throw new InputMismatchException("Primo carattere non valido");
        } else if (c2 < 97 || c2 > 122) {
            throw new InputMismatchException("Secondo carattere non valido");
        } else if (c1>c2) {
            throw new InputMismatchException("La prima lettera è successiva alla seconda");
        }

        this.curr = c1;
        this.first = c1;
        this.last = c2;
    }

    @Override
    public boolean hasNext() {
        return curr <= last;
    }

    @Override
    public Character next() {
        return curr++;
    }

    public static void main(String[] args) {
        Alfabeto a = new Alfabeto(args[0].charAt(0), args[1].charAt(0) );

        while (a.hasNext()) {
            System.out.println(a.next());
        }
    }
}
