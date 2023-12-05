public class AdCampaignSocial extends AdCampaign {
    // OVERVIEW: classe che definisce una campagna pubblciitaria mediante post su
    // social network
    // estende la classe AdCampaign

    // attributes
    private double nVis = 0;
    private double nLike = 0;

    // constructor
    public AdCampaignSocial(String name) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this

        super(name);

    }

    // methods
    public double getnVis() {
        return nVis;
    }

    public double getnLike() {
        return nLike;
    }

    @Override
    public double performance() {
        // EFFECTS: restituisce il valore di performance della campagna pubblicitaria

        return nLike / nVis;
    }

    public void setnVis(double nVis) throws CampaignClosedException {
        // lancia IllegalArgumentException se nVis <= 0
        // lancia CampaignClosedException se la campagna è chiusa (quindi non permette
        // aggiornamenti)

        if (this.isAperta())
            throw CampaignClosedException(nome + " already closed");
        if (nVis <= 0)
            throw new IllegalArgumentException("nVis <= 0");

        this.nVis = nVis;
        assert repOk();
    }

    public void setnLike(double nLike) {
        // lancia IllegalArgumentExcpetion se nLike <= 0 o nLike > nVis
        // lancia CampaignClosedException se la campagna è chiusa (quindi non permette
        // aggiornamenti)

        if (this.isAperta())
            throw CampaignClosedException(nome + " already closed");
        if (nLike <= 0)
            throw new IllegalArgumentException("nLike <= 0");
        if (nLike > nVis)
            throw new IllegalArgumentException("nLike > nVis");

        this.nLike = nLike;
        assert repOk();
    }

    public void aggiorna(double nVisNew, double nLikeNew) throws IllegalArgumentException, CampaignClosedException {
        // MODIFIES: this
        // EFFECTS: incrementa nVis e nLike con i parametri dati (se la campagna è
        // aperta!)

        if (nLikeNew <= 0)
            throw new IllegalArgumentException("nLikeNew <= 0");
        if (nVisNew <= 0)
            throw new IllegalArgumentException("nVisNew <= 0");

    }

    public boolean repOk() {
        if (nVis < 0)
            return false;
        if (nLike < 0)
            return false;
        if (nLike > nVis)
            return false;

    }

}
