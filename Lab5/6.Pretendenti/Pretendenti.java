import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
    // OVERVIEW: classe che modella il metodo di selezione dei pretendenti della
    // principessa Eva

    // attributi
    ArrayList<Integer> pret;

    // costruttori
    public Pretendenti(int n) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this con n pretendenti
        // se n<=0 lancia IllegalArgumentException

        if (n <= 0) {
            throw new IllegalArgumentException("Inserire almeno un i");
        }

        pret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            pret.add(i);
        }

        assert repOk();

    }

    // metodo di OSSERVAZIONE (non computazionale!)
    public int getVincitore() throws IllegalStateException {
        // EFFECTS: restituisce il vincitore
        // se il numero dei pretendi != 1 lancia PretendentiStillRunningException

        if (pret.size() != 1) {
            throw new IllegalStateException("C'è ancora più di un i in gara");
        }

        return pret.get(0);

    }

    private boolean repOk() {
        if (pret == null) {
            return false;
        }
        if (pret.size() == 0) {
            return false;
        }

        Integer prev = null;
        for (int i : pret) {
            if (i <= 0) {
                return false;
            }
            if (prev != null && i <= prev) {
                return false;
            }
            prev = i;
        }
        return true;
    }

    @Override
    public String toString() {
        String res = "Pretendenti:";
        for (int i : pret) {
            res += " " + i;
        }
        return res;
    }

    @Override
    public Iterator<Integer> iterator() {
        //MODIFIES: modifica la lista dei pretendenti eliminando quello selezionato
        //EFFECTS: restituisce un Iterator che seleziona un nuovo i a
        //         distanza 3 dell'ultimo restituito.
        //         Quando si arriva in coda la coda continua cambiando direzione, stessa cosa
        //         accade quande si ritorna al primo elemento

        return new Iterator<Integer>() {
            //OVERVIEW: iterator che conta ogni volta tre pretendenti eliminandone uno

            int current = 0; // indice dell'elemento da cui devo partire a contare
            boolean dir = true; //true = avanti , false = indietro
            boolean removed = true; //se ho rimosso qualcosa devo chiamare prima next per poter rimuovere ancora


            @Override
            public boolean hasNext() {
                //EFFECTS: restituisce true se ci sono pretendenti eliminabili, false se c'è solo un pretendente

                return Pretendenti.this.pret.size() > 1;
            }

            @Override
            public Integer next() {
                //MODIFIES: this (iteratore)
                //EFFECTS: restituisce il prossimo pretendente da eliminare
                //         aggiorna l'elemento corrente, la direzione e imposta removed a false 
                //se non ci sono altri elementi da rimuovere lancia NoSuchElementException

                if (!this.hasNext()) {
                    throw new NoSuchElementException("Non ci sono più pretendenti da eliminare");
                }


                if (dir) {
                    current+=2;
                } else {
                    current-=2;
                }

                if (current >= Pretendenti.this.pret.size()-1) {
                    current = 2*(Pretendenti.this.pret.size()-1) - current;
                    dir = false;
                }

                if (current <= 0) {
                    current = - current;
                    dir = true;
                }
                removed = false;
                return Pretendenti.this.pret.get(current);
            }

            @Override
            public void remove() throws IllegalStateException {
                //MODIFIES: this.pret e this
                //EFFECTS: rimuovere il pretenddente selezionato dal next() e aggiornare l'indice
                //se sto rimuovendo un elemento senza aver fatto next(), lancia IllegalStateException

                if (removed) {
                    throw new IllegalArgumentException("Non si può eliminare senza prima aver selezionato un nuovo pretendente");
                }
                Pretendenti.this.pret.remove(current);
                removed = true;
                if (!dir || current>Pretendenti.this.pret.size()-1) {
                    current--;
                }
                if (current == Pretendenti.this.pret.size() -1) {
                    dir = false;
                }
                if (current == 0) {
                    dir = true;
                }

                assert repOk();
            }
            
            @Override
            public String toString() {
                String direStr = dir ? "avanti" : "indietro"; //operatore ternario!!
                return "Si conta da " + Pretendenti.this.pret.get(current) + " direzione " + direStr;
            }

        };

    }
    public static void main(String[] args) {
        Pretendenti p = new Pretendenti(Integer.parseInt(args[0]));
        Iterator<Integer> i = p.iterator();

        while (i.hasNext()) {
            System.out.println(p);
            System.out.println(i);
            System.out.println("Eliminato: " + i.next());
            i.remove();
        }
        System.out.println("Il numero " + p.getVincitore() + " è il fortunato vincitore");
    }

}
