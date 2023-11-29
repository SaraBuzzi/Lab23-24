

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Vetreria implements Iterable<Contenitore> {
    // OVERVIEW: classe che modella un insieme di contenitori di un laboratorio

    // attributes
    ArrayList<Contenitore> vetreria = new ArrayList<>();

    // methods
    public void addContenitore(Contenitore c) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: aggiunge c a this, se c è già presente non modifica this
        // lancia IllegalArgumentException se c == null

        if (c == null)
            throw new IllegalArgumentException("contenitore == null");

        if (!(vetreria.contains(c))) {
            vetreria.add(c);
        }

        assert repOk();

    }

    public void remContenitore(Contenitore c) throws IllegalArgumentException, NoSuchElementException {
        // MODIFIES: this
        // EFFECTS: rimuove c da this
        // lancia IllegalArgumentException se c == null
        // lancia NoSuchElementException se c non è presente in this

        if (c == null)
            throw new IllegalArgumentException("contenitore == null");
        if (!(vetreria.contains(c)))
            throw new NoSuchElementException("contenitore not in the list");

        vetreria.remove(c);

        assert repOk();
    }

    public Vetreria vetreriaDiTipo(String s) {
        // EFFECTS: restituisce una nuova vetreria contenente solo i contenitori con
        // liquido di tipo s. Rimuove tutti contenitori estratti da this

        Vetreria nuovaVetreria = new Vetreria();

        for (Contenitore cont : this) {
            if (cont.getTipoLiquido().equals(s)) {
                nuovaVetreria.addContenitore(cont);
            }
        }
        for (Contenitore cont : nuovaVetreria) {
            this.remContenitore(cont);
        }

        return nuovaVetreria;
    }

    public void ottimizza() {
        //MODIFIES: this
        //EFFECTS: metodo che riempie fino al massimo i contenitori più capienti svuotando, se possibile, alcuni tra quelli meno capienti
        //         i contenitori devono avere UGUALE liquido

        this.ordina();
        for (int i = vetreria.size()-1; i >= 0; i-- ) {
            for (int j = i-1; j >= 0; j--) {
                vetreria.get(i).versa(vetreria.get(j));
            }
        }


    }

    @Override
    public String toString() {
        String ret = "Vetreria con: ";
        for (Contenitore contenitore : vetreria) {
            ret += contenitore.toString() + " ";
        }
        return ret;
    }

    public boolean repOk() {
        for (Contenitore contenitore : vetreria) {
            if (contenitore == null)
                return false;
        }

        return true;
    }

    public void ordina() {
        //EFFECTS: ordina i propri contenitori in base alla loro capienza
        vetreria.sort(null);
    }

    @Override
    public Iterator<Contenitore> iterator() {
        return new Iterator<>() {

        Iterator<Contenitore> i = vetreria.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Contenitore next() {
                return i.next();
            }

        };
       
    }


    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci i contenitori nel formato <tipoLiquido> <quantitàLiquido> <tipoContenitore> <parametriContenitore>");
        Vetreria vetreria = new Vetreria();
        while (s.hasNextLine()) {
            try {
                String[] campi = s.nextLine().split(" ");
                switch (campi[2]) {
                    case "Sfera":
                        Sfera sfera = new Sfera(Double.parseDouble(campi[1]), campi[0], Double.parseDouble(campi[3]));
                        vetreria.addContenitore(sfera);
                        break;
                
                    case "Cilindro":
                        Cilindro cilindro = new Cilindro(Double.parseDouble(campi[1]), campi[0], Double.parseDouble(campi[3]), Double.parseDouble(campi[4]));
                        vetreria.addContenitore(cilindro);
                        break;
                    
                    case "Cuboide":
                        Cuboide cuboide = new Cuboide(Double.parseDouble(campi[1]), campi[0], Double.parseDouble(campi[3]), Double.parseDouble(campi[4]), Double.parseDouble(campi[5]));
                        vetreria.addContenitore(cuboide);
                        break;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Errore di input");
            } catch (IllegalArgumentException | ExceededCapacityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(vetreria);
        Vetreria vetreriaAlcool = vetreria.vetreriaDiTipo("alcool");
        vetreriaAlcool.ottimizza();
        System.out.println(vetreriaAlcool);

    }
    
}
