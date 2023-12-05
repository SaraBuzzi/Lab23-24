import java.util.ArrayList;
import java.util.Iterator;

public class CompanyAds implements Iterable<AdCampaign> {
    // OVERVIEW: classe che implementa un'azienda e le sue campagne pubblicitarie

    // attributes
    private final String nome;
    ArrayList<AdCampaign> ads = new ArrayList<>();

    // constructor
    public CompanyAds(String nome) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza un'azienda con il nome e 0 campagne pubblcitarie
        // lancia IllegalArgumentException se nome == null o vuoto

        if (nome == null || nome.equals(" "))
            throw new IllegalArgumentException("nome azienda == null o vuoto");

        this.nome = nome;
    }

    // methods
    public String getNome() {
        return nome;
    }

    public void addCampaign(AdCampaign c) throws IllegalArgumentException, CampaignExistsException {
        // MODIFIES: this
        // EFFECTS: aggiunge alla lista di campagne pubblicitarie di this la campagna c
        // lancia IllegalArgumentException se c == null
        // lancia CampaignExistsException se la campagna c è già precedentemente
        // inserita in this

        if (c == null)
            throw new IllegalArgumentException("campagna inserita nulla");
        if (ads.contains(c))
            throw new CampaignExistsException("campagna gia' precedentemente inserita");

        ads.add((AdCampaign) c.clone());

        assert repOk();
    }

    public AdCampaign getCampaign(String nome) {
        // EFFECTS: restituisce la campagna identificata dal nome passato


        for (AdCampaign ad : ads) {
            if (ad.getNome().equals(nome))
                return ad;
        }
        return null;

    }

    @Override
    public Iterator<AdCampaign> iterator() {

        ads.sort(null);
        Iterator<AdCampaign> i = ads.iterator();

        return new Iterator<AdCampaign>() {

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public AdCampaign next() {
                return i.next();
            }

        };
    }

    public boolean repOk() {
        if (ads == null)
            return false;
        for (AdCampaign ad : ads) {
            if (ad == null)
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String ret ="Campagne di " + nome + ":\n";
        for (AdCampaign ad : ads) {
            ret += ad + "\n";
        }
        return ret;
    }

}
