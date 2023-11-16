import java.time.LocalDate;

public class ProdottoAlimentare extends Prodotto {
    // OVERVIEW: classe che modella prodotti alimentari deperibili, con la data di scadenza
    //           estende la classe Prodotto

    // attributes
    private final LocalDate scadenza;
    public int percentuale = 5;

    // constructor
    public ProdottoAlimentare(String nome, double costo, LocalDate data) {
        super(nome, costo);

        this.scadenza = data;

    }

    //methods
    @Override
    public double sconto() {
        // EFFECTS: restituisce il valore del prodotto scontato del 5%. Se la data di
        // scadenza è inferiore a 10 giorni il prodotto è scontato del 30%

        LocalDate oggi = LocalDate.now();

        if (scadenza.isBefore(oggi.plusDays(10))) {
            this.setPercentuale(30);
            return this.costo - (this.costo*30)/100;
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
        return "Prodotto alimentare " + nome + " al prezzo " + costo + " con scadenza il giorno " + scadenza;
    }

}
