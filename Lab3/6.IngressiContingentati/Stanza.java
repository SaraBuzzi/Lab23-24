import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.InstanceNotFoundException;


// SBAGLIATOOOOOOO
public class Stanza {
    //OVERVIEW: classe "Stanza" che modella una stanza con una determinata capienza massima di persone

    //attributi
    int maxPers;
    int numPers;

    //construttori
    public Stanza(int max) throws InputMismatchException {
        //MODIFIES: this
        //EFFECTS: inizializza un oggetto Stanza con la sua capienza massima
        //if max < 0 throws InputMismatchException
        if (max <= 0) {
            throw new InputMismatchException("Non è possibile avere una stanza con capienza negativa");
        }

        this.maxPers = max; 
        this.numPers = 0;
    }

    //metodi
    public int getMax() {
        return this.maxPers;
    }

    public int getPers() {
        return this.numPers;
    }

    public void addOnePerson() throws IndexOutOfBoundsException {
        this.numPers++;
        if (this.numPers == this.maxPers) {
            throw new IndexOutOfBoundsException("Capienza massima raggiunta nella stanza ");
        }
    }

    public void remOnePerson() throws InstanceNotFoundException {
        this.numPers--;
        if (this.numPers < 0) {
            throw new InstanceNotFoundException("Nessuno nella stanza ");
        }
    }



    public static void main(String[] args) {

        HashMap<Integer, Stanza> mappa = new HashMap<Integer, Stanza>();
        for (int i = 0; i < args.length; i++) {
            try {
                Stanza s = new Stanza(Integer.parseInt(args[i]));
                mappa.put(i+1, s);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("Create " + mappa.size() + " stanze");

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            System.out.println("OPERANDO " + s.nextInt());
            System.out.println(" OPERATORE " +s.next());
            int nStanza = s.nextInt();
            if (!mappa.containsKey(nStanza)) {
                System.out.println("Stanza " + nStanza + " non esiste");
            } 

            
               switch (s.next()) {
                case "+":
                try {
                    mappa.get(nStanza).addOnePerson();
                    break;
                } catch (IndexOutOfBoundsException f) {
                    System.out.println(f.getMessage() + nStanza);
                }
               case "-":
                try {
                    mappa.get(nStanza).remOnePerson();
                    break;
                } catch (InstanceNotFoundException g) {
                    System.out.println(g.getMessage() + nStanza);
                }
                } 
            }
            
        

        int totPers = 0;
        for (int i = 1; i <= mappa.size(); i++) {
            totPers += mappa.get(i).getPers();
        }
        System.out.println("Numero totale di persone presenti: " + totPers);
    
    }

    
    

}
