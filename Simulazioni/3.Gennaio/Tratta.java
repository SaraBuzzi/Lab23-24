public class Tratta implements Comparable<Tratta>{
    // OVERVIEW: classe che modella una tratta di viaggio

    // attributes
    private final String origine;
    private final String destinazione;
    private final double lunPercorso;
    private final double velMedia;

    // constructor
    public Tratta(String origine, String destinazione, double lunPercorso, double velMedia) {
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se origine == null o vuoto
        // lancia IllegalArgumentException se destinazione == null o vuoto
        // lancia IllegalArgumentException se lunPercorso <= 0
        // lancia IllegalArgumentException se velMedia <= 0

        if (origine == null || origine.equals(" "))
            throw new IllegalArgumentException("luogo di origine non valido");
        if (destinazione == null || destinazione.equals(" "))
            throw new IllegalArgumentException("luogo di destinazione non valido");
        if (lunPercorso <= 0)
            throw new IllegalArgumentException("lunghezza del percorso non valida");
        if (velMedia <= 0)
            throw new IllegalArgumentException("velocita' media non valida");

        this.origine = origine;
        this.destinazione = destinazione;
        this.lunPercorso = lunPercorso;
        this.velMedia = velMedia;

    }

    // methods
    public String getOrigine() {
        return this.origine;
    }

    public String getDestinazione() {
        return this.destinazione;
    }

    public double getLunPercorso() {
        return this.lunPercorso;
    }

    public double getVelMedia() {
        return this.velMedia;
    }

    public double durataInOre() {
        // EFFECTS: restituisce la durata della tratta in ore

        return this.lunPercorso / this.velMedia;
    }

    public double inquina() {
        return 0;
    }

    @Override
    public String toString() {
        return "Tratta tra " + this.origine + " e " + this.destinazione + "; lunghezza: " + this.lunPercorso + ", velocita': " + this.velMedia;
    }

    @Override
    public int compareTo(Tratta o) {
        return Double.compare(o.durataInOre(), this.durataInOre());
    }

}
