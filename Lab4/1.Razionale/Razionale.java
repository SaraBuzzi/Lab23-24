public class Razionale {
    // OVERVIEW: classe Razionale che rappresenti un numero razionale con il suo
    // numeratore (intero) ed il suo denominatore (intero, diverso da 0).

    //attributi
    int num;
    int den;

    //construttori
    public Razionale(int num, int den) throws ArithmeticException {
        //MODIFIES: this
        //EFFECTS: inizializza this con num e den
        // se den == 0 lancia ArithmeticException

        if (den == 0) {
            throw new ArithmeticException("Denominatore uguale a 0");
        }
        this.num = num;
        this.den = den;

        assert repOk();
    }

    //metodi
    public boolean repOk() {
        return den!=0;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) throws ArithmeticException{
        // se den == 0 lancia ArithmeticException

        if (den == 0) {
            throw new ArithmeticException("Denominatore uguale a 0");
        }

        this.den = den;
    }

    public double valore() {
        //EFFECTS: restituisce il valore del rapporto tra num e den
        
        return (double) this.num/this.den;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    } 

    public static void main(String[] args) {
        try {
            Razionale r = new Razionale(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println("Il razionale e' " + r + " o " + r.valore());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
