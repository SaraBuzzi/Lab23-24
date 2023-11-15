import java.time.LocalDate;

public class Dramma extends Film{

    public Dramma(int codId, String titolo, LocalDate data) throws IllegalArgumentException, NullPointerException {
        super(codId, titolo);
        this.setData(data);
    }
    


    @Override
    public String toString() {
        return super.toString().replace("Film", "Film Dramma");
    }
}