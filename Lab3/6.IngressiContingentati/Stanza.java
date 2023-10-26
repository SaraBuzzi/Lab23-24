import java.util.InputMismatchException;

import javax.management.InstanceNotFoundException;

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
            throw new InputMismatchException("Non è possibile averer una stanza con capienza negativa");
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
        if (this.numPers > this.maxPers) {
            this.numPers--;
            throw new IndexOutOfBoundsException("Capienza massima raggiunta nella stanza ");
        }
    }

    public void remOnePerson() throws InstanceNotFoundException {
        this.numPers--;
        if (this.numPers <= 0) {
            throw new InstanceNotFoundException("Nessuno nella stanza ");
        }
    }




    
    

}
