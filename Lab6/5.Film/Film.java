import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Film {
    // OVERVIEW: classe astratta che rappresenta un film noleggiabile da un
    // videoteca, definito da un codice identificativo, un titolo, e la data di
    // noleggio del film

    public final int codId;
    public final String titolo;
    private LocalDate data;
    private double penaleGiornaliera;

    public Film(int codId, String titolo) {
        //MODIFIES: this
        //EFFECTS: inizializza un film con id e titolo
        //lancia IllegalArgumentException se titolo è null o vuoto

        if (titolo == null || titolo.equals(" ")) {
            throw new IllegalArgumentException();
        }

        this.codId = codId;
        this.titolo = titolo;
        this.penaleGiornaliera = 2.00;
        
        assert repOk();
    }

    

    public LocalDate getData() {
        return data;
    }



    public void setData(LocalDate data) throws NullPointerException{

        if (data == null) {
            throw new NullPointerException("Data nulla");
        }
        this.data = data;
        assert repOk();
    }



    public double getPenaleGiornaliera() {
        return penaleGiornaliera;
    }



    public void setPenaleGiornaliera(double penaleGiornaliera) throws IllegalArgumentException{

        if (penaleGiornaliera < 0) {
            throw new IllegalArgumentException("Penale negativa");
        }
        this.penaleGiornaliera = penaleGiornaliera;
        assert repOk();
    }



    public double calcolaPenaleRitardo() {
        //EFFECTS: ritorna la penale di ritardo di this

        LocalDate oggi =  LocalDate.now();
        LocalDate riconsegna =  data.plusDays(7);

        if (riconsegna.isBefore(oggi)) {
            return penaleGiornaliera * riconsegna.until(oggi, ChronoUnit.DAYS);
        }
        return 0;
    }



    @Override
    public String toString() {
        return "Film: " + titolo + ", noleggiato il" + data;
    }

    public boolean repOk() {
        if (titolo == null || titolo.equals(" ")) {
            return false;
        }
        if (data == null) {
            return false;
        }
        if (data.isAfter(LocalDate.now())) {
            return false;
        }
        if (penaleGiornaliera < 0) {
            return false;
        }

        return true;
    }

    
}
