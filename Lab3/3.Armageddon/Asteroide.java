public class Asteroide {
     //OVERVIEW: definisce un oggetto asteroide in base alla massa e alla distanza dalla terra

    private double massa;
    private double distanza;

     //costruttori
     public Asteroide(double m, double d) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza un oggetto asteroide
        // if m < 0 or d < 0 throws IllegalArgumentException 

        if (m < 0 || d < 0) {
            throw new IllegalArgumentException("valori non positivi");
        }
        this.massa = m;
        this.distanza = d;
     }

     //metodi 

     public double getMassa() {
        return this.massa;
     }

     public double getDist() {
        return this.distanza;
     }

     public double forzaGravitazionale() throws DivideByZeroException {
        //MODIFIES: this
        //EFFECTS: restituisce la forza gravitazionale secondo la formula forza = massa/distanza*2
        // if distanza = 0 throws DivideByZeroExcpetion

        if (distanza == 0) {
            throw new DivideByZeroException();
        }

        double forza = this.massa/(this.distanza*2);

        return forza;
     }



}