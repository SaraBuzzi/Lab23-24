

public class Cuboide extends Contenitore {
    //OVERVIEW: classe che modella contenitori di tipo cuboide (o parallelepipedo rettangolo)
    //          classe che estende Contenitore

    //attributes
    private final double a,b,c;

    public Cuboide(double liquido, String tipoLiquido, double a, double b, double c)
            throws IllegalArgumentException, ExceededCapacityException {
        //MODIFIES: this
        //EFFECTS: inizializza this inserendo la sua capienza massima (==volume) calcolata con i parametri a,b,c
        //lancia IllegalArgumentException se a <= 0, b <= 0 o c <= =

        super((a*b*c),liquido, tipoLiquido);

        if (a <= 0)
            throw new IllegalArgumentException("lato a <= 0");
        if (b <= 0)
            throw new IllegalArgumentException("lato b <= 0");
        if (c <= 0)
            throw new IllegalArgumentException("lato c <= 0");
        

        this.a = a;
        this.b = b;
        this.c = c;

        assert repOk(); 
    }

    //methods
    @Override
    public String toString() {
        return super.toString().replace("Contenitore (capienza: ", "Cuboide - lati: " + this.a + ", " + this.b + ", " + this.c + ", (capienza: ");
    }

    @Override
    public boolean repOk() {
        if (a <= 0)
            return false;
        if (b <= 0)
            return false;
        if (c <= 0)
            return false;
        return super.repOk();
    }
    
}
