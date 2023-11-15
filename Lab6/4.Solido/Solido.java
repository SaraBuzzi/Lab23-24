public abstract class Solido implements Comparable<Solido> {
    //OVERVIEW: classe che modella un solido geometrico


    private final String tipo;
   


    public Solido(String tipo) {
        //MODIFIES: this
        //EFFECTS: inizializza this

        this.tipo = tipo;
    }

    public abstract double volume();

    @Override
    public int compareTo(Solido o) {
        
        if (this.volume() < o.volume()) {
            return -1;
        } else if (this.volume() == o.volume()) {
            return 0;
        }
        return 1;
    }

    
}
