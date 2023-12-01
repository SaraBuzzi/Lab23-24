public class Carta implements Comparable<Carta> {
    //OVERVIEW: classe che modella oggetti che rappresentano carte da gioco, definita da un valore numerico e un seme

    //attributes
    private final int num; // nel range [A=1,2,3,4,5,6,7,8,9,10,J=11,Q=12,K=13]
    private final int seme; // nel range [cuori=1, quadri=2, fiori=3, picche=4]

    //constructor
    public Carta(int num, int seme) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza this
        //lancia IllegalArgumentException se num non è nel range [1-13]
        //lancia IllegalArgumentException se seme non è nel range [1-4]

        if (num<1 || num>13) 
            throw new IllegalArgumentException("card number not in the range [1-13]");
        if (seme<1 || seme>4)
            throw new IllegalArgumentException("card suit not in the range [1-4]");

        this.seme = seme;
        this.num = num;

    }

    //methods
    public int getNum() {
        return this.num;
    }

    public int getSemeNumero() {
        return this.seme;
    }

    public String getSemeString() {
        switch (this.seme) {
            case 1:
                return "C";
            case 2:
                return "Q";
            case 3:
                return "F";
            default:
                return "P";   
        }

    }

    @Override
    public String toString() {
        return "Carta: " + this.num + " " + this.getSemeString();
    }

    @Override
    public int compareTo(Carta o) {
        if (this.num > o.num)
            return 1;
        if (this.num < o.num)
            return -1;
        if (this.seme < o.seme)
            return 1;
        if (this.seme > o.seme)
            return -1;
        return 0; //caso in cui numero e seme sono uguali => carte uguali  
    }


}
