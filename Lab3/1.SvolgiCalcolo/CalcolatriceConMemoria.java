import java.util.InputMismatchException;

public class CalcolatriceConMemoria {
    //OVERVIEW: modellare una calcolatrice sequenziale su numeri decimali, utilizzando il risultato dell'operazione precedente come il primo operando dell'operazione successiva

    private double mem;

    //costruttori
    public CalcolatriceConMemoria() {
        //MODIFIES: this
        //EFFECTS: inizializza la calcolatrice con valore di memoria a zero
        mem = 0;
    }

    public CalcolatriceConMemoria(double mem) {
        //MODIFIES: this
        //EFFECTS: inizializza la calcolatrice con valore di memoria pari al valore del parametro mem
        this.mem = mem; // this.mem indica lo stato attuale della memoria (non bisogna sempre specificarlo ma solo quando può essere ambiguo)
    }


    //metodi
    public double getMem() {
        //EFFECTS: legge la memoria
        return this.mem;
    }

    public double add(double op2) {
        //MODIFIES: this
        //EFFECTS: aggiunge alla memoria il valore op2 
        this.mem += op2;
        return this.mem;
    }

    public double sub(double op2) {
        //MODIFIES: this
        //EFFECTS: sottrae alla memoria il valore op2
        this.mem -= op2;
        return this.mem;
    }

    public double mul(double op2) {
        //MODIFIES: this
        //EFFECTS: moltiplica il valore in memoria con quello di op2
        this.mem *= op2;
        return this.mem;
    }

    public double div(double op2) throws DivideByZeroException{
        //MODIFIES: this
        //EFFECTS: divido il valore in memoria con quello di op2
        // if op2 = 0 throws DivideByZeroException
        if (op2 == 0) {
            throw new DivideByZeroException();
        }
        this.mem /= op2;
        return this.mem;
    }

    public double operate(char operator, double op2) throws InputMismatchException, DivideByZeroException {
        //MODIFIES: this
        //EFFECTS: imposta il valore in memoria al risultato dell'operazione indicata
        // if operator != '+' or '-' or '*' or '/' throws InputMismatchException
        // if op2 = 0 throws DivideByZeroException
        switch (operator) {
            case '+':
                this.add(op2);
                return this.mem;
            case '-':
                this.sub(op2);
                return this.mem;
            case '*':
                this.mul(op2);
                return this.mem;
            case '/':
                this.div(op2);
                return this.mem;
            default:
            throw new InputMismatchException("operatore sconosciuto");
        }
    }
}
