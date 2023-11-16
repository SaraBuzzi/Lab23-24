

public class ProdottoNonDeperibile extends Prodotto {
    // OVERVIEW: classe che modella prodotti non deperibili con un flag che segnala
    // se il prodotto è in materiale riciclabile o no
    // estende la classe Prodotto

    // attributes
    public final boolean riciclabile; // true => materiale riciclabile, false => materiale non riciclabil
    public int percentuale = 5;

    // constructors
    public ProdottoNonDeperibile(String nome, double costo, boolean riciclabile) {
        super(nome, costo);

        this.riciclabile = riciclabile;
    }

    // methods
    @Override
    public double sconto() {
        // EFFECTS: restituisce il valore del prodotto scontato del 5%. Se il prodotto è
        // in materiale riciclabile lo sconto applicato è del 10%

        if (this.riciclabile) {
            this.setPercentuale(10); 
            return this.costo - (this.costo*10)/100;
        }
        
        return this.costo - (this.costo*5)/100;

    }


    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
    }



    @Override
    public String toString() {
        
        if (riciclabile) {
            return "Prodotto non deperibile riciclabile " + nome + " al prezzo " + costo ;
        }
        return "Prodotto non deperibile non riciclabile" + nome + " al prezzo " + costo ;
    }

    

    

}
