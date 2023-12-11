
public class AdCampaignWebRestyling extends AdCampaign {
    // OVERVIEW: classe che definisce una campagna pubblicitaria basata sul redesign
    // di un sito web
    //           estende la classe AdCampaign

    // attributes
    private double nVis = 0;
    private double tVisMedio = 0;
    private double tVisOld;

    //constructor
    public AdCampaignWebRestyling(String nome, double tVisOld) {
        // MODIFIES: this
        // EFFECTS: inizializza this
        // lancia IllegalArgumentException se tVisOld <= 0

        super(nome);

        if (tVisOld <= 0)
            throw new IllegalArgumentException(" vecchio tempo di visita medio <= 0");

        this.tVisOld = tVisOld;

        assert repOk();

    }

    // methods
    @Override
    public double performance() {
        // EFFECTS: restituisce il valore di performance della campagna pubblicitaria
        return tVisMedio / (tVisMedio + tVisOld);
    }

    public double getnVis() {
        return nVis;
    }

    public void setnVis(double nVis) throws IllegalArgumentException, CampaignClosedException {
        // lancia IllegalArgumentExcpetion se nVis <= 0
        // lancia CampaignClosedException se la campagna è chiusa (quindi non permette
        // aggiornamenti)

        if (!(this.isAperta()))
            throw new CampaignClosedException(nome + " campagna gia' chiusa");

        if (nVis <= 0)
            throw new IllegalArgumentException("num visitatori <= 0");

        this.nVis = nVis;

        assert repOk();
    }

    public double gettVisMedio() {
        return tVisMedio;
    }

    public void settVisMedio(double tVisMedio) throws IllegalArgumentException, CampaignClosedException {
        // lancia IllegalArgumentExcpetion se tVisMedio <= 0
        // lancia CampaignClosedException se la campagna è chiusa (quindi non permette
        // aggiornamenti)

        if (!(this.isAperta()))
            throw new CampaignClosedException(nome + " campagna gia' chiusa");

        if (tVisMedio <= 0)
            throw new IllegalArgumentException("tempo di visita medio <= 0");

        this.tVisMedio = tVisMedio;
        assert repOk();
    }

    public double gettVisOld() {
        return tVisOld;
    }

    @Override
    public void aggiorna(double nVisNew, double tVisNew) throws IllegalArgumentException, CampaignClosedException {
        // MODIFIES: this
        // EFFECTS: incrementa nVisNew e tVisNew con i parametri dati (se la campagna è
        // aperta!)

        if (tVisNew <= 0)
            throw new IllegalArgumentException("tempo di visita medio <= 0");
        if (nVisNew <= 0)
            throw new IllegalArgumentException("num nuovi visitatori <= 0");

        this.setnVis(nVis + nVisNew);
        this.settVisMedio(tVisMedio + ((nVis * tVisMedio) + (nVisNew * tVisNew)) / (nVis + nVisNew));

        assert repOk();

    }

    public boolean repOk() {
        if (tVisOld <= 0)
            return false;
        if (nVis < 0)
            return false;
        if (tVisMedio < 0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString().replace("AdCampaign", "WebRestyle");
    }

    @Override
    public Object clone() {
        AdCampaignWebRestyling a = null;
        try {
            a = new AdCampaignWebRestyling(nome, gettVisOld());
        } catch (IllegalArgumentException e) {
            //impossibile
        }
        return a;
    }

}
