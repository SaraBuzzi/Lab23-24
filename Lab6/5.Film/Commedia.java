import java.time.LocalDate;

public class Commedia extends Film{

    public Commedia(int codId, String titolo, LocalDate data) throws IllegalArgumentException, NullPointerException {
        super(codId, titolo);
        this.setPenaleGiornaliera(2.50);
        this.setData(data);

    }

    @Override
    public String toString() {
        return super.toString().replace("Film", "Film Commedia");
    }
    
}
