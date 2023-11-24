public interface Figura extends Comparable<Figura>{
    //OVERVIEW: interfaccia che implementa figure piane,
    //          comparabili secondo il perimentro

    public double perimetro();

    @Override
    default int compareTo(Figura o) {
        return Double.compare(o.perimetro(), perimetro());
    }
}
