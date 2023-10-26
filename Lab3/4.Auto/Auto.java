public class Auto {
    //OVERVIEW: Modellare, specificare e implementare una classe `Auto` che rappresenta un'automobile

    private double serbatoio;
    private double velMax;
    private double conMedio;

    //costruttore
    public Auto(double serbatoio, double velMax, double conMedio) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: inizializza un oggetto "Auto" 
        // if serbatoio < 0 or velMax < 0 or conMedio < 0 throw IllegalArgumentException

        if (serbatoio < 0 || velMax < 0 || conMedio < 0) {
            throw new IllegalArgumentException("inserire valori positivi");
        }

        this.serbatoio = serbatoio;
        this.velMax = velMax;
        this.conMedio = conMedio;
    }

    //metodi
    public void setVel (double vel) {
        //MODIFIES: this
        //EFFECTS: restituisce l'oggetto Auto cambiando il parametro velocità con quello dato
        this.velMax = vel;
    }

    public void viaggio(double distanza, double vel) {
        
    }
}
