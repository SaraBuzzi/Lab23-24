import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.InstanceNotFoundException;

public class Palazzo {
    public static void main(String[] args) {

        HashMap<Integer, Stanza> mappa = new HashMap<Integer, Stanza>();
        for (int i = 0; i < args.length; i++) {
            try {
                Stanza s = new Stanza(Integer.parseInt(args[i]));
                mappa.put(i+1, s);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Create " + mappa.size() + " stanze");

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int nStanza = s.nextInt();
            if (!mappa.containsKey(nStanza)) {
                System.out.println("Stanza " + nStanza + " non esiste");
            } else {
               switch (s.nextLine()) {
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
            
        }

        int totPers = 0;
        for (int i = 1; i <= mappa.size(); i++) {
            mappa.get(i).numPers += totPers;
        }


        
    }
}
