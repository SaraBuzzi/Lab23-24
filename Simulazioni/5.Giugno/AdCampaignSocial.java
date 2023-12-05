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

        if (!(this.isAperta()))
            throw new CampaignClosedException(nome + " campagna gia' chiusa");
        if (nVis <= 0)
            throw new IllegalArgumentException("num visualizzazioni <= 0");

        this.nVis = nVis;

        assert repOk();
    }

    public void setnLike(double nLike) throws CampaignClosedException {
        // lancia IllegalArgumentExcpetion se nLike <= 0 o nLike > nVis
        // lancia CampaignClosedException se la campagna è chiusa (quindi non permette
        // aggiornamenti)

        if (!(this.isAperta()))
            throw new CampaignClosedException(nome + " campagna gia' chiusa");
        if (nLike <= 0)
            throw new IllegalArgumentException("num like <= 0");
        if (nLike > nVis)
            throw new IllegalArgumentException("num like > num visualizzazioni");

        this.nLike = nLike;

        assert repOk();
    }

    @Override
    public void aggiorna(double nVisNew, double nLikeNew) throws IllegalArgumentException, CampaignClosedException {
        // MODIFIES: this
        // EFFECTS: incrementa nVis e nLike con i parametri dati (se la campagna è
        // aperta!)

        if (nLikeNew <= 0)
            throw new IllegalArgumentException("num like nuovo <= 0");
        if (nVisNew <= 0)
            throw new IllegalArgumentException("num visualizzazioni nuovo <= 0");
        
        this.setnVis(this.nVis + nVisNew);
        this.setnLike(this.nLike + nLikeNew);
        

        assert repOk();

    }

    public boolean repOk() {
        if (nVis < 0)
            return false;
        if (nLike < 0)
            return false;
        if (nLike > nVis)
            return false;
        return true;

    }

    @Override
    public String toString() {
        return super.toString().replace("AdCampaign", "Social");
    }

    @Override
    public Object clone() {
        AdCampaignSocial a = null;
        try {
            a = new AdCampaignSocial(nome);
        } catch (IllegalArgumentException e) {
            //impossibile
        }
        return a;
    }

}
