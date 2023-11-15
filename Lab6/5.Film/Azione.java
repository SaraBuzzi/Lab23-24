import java.time.LocalDate;

public class Azione extends Film {

    public Azione(int codId, String titolo, LocalDate data) throws IllegalArgumentException, NullPointerException {
        super(codId, titolo);
        
        this.setPenaleGiornaliera(3.00);
        this.setData(data);
    }

    @Override
    public String toString() {
        return super.toString().replace("Film", "Film Azione");
    }

    
}
