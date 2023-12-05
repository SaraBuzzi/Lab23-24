import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CompanyAds company = new CompanyAds(args[0]);
        AdCampaign ad = null;

        System.out.println("Inserisci o aggiorna campagne:");
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] elem = s.nextLine().split(" ");

            try {
                switch (elem[2]) {
                    case "open":
                        switch (elem[1]) {
                            case "Social":
                                ad = new AdCampaignSocial(elem[0]);
                                break;
                            case "WebRestyle":
                                ad = new AdCampaignWebRestyling(elem[0], Double.parseDouble(elem[3]));
                                break;
                        }
                        company.addCampaign(ad);
                        break;

                    case "update":
                        company.getCampaign(elem[0]).aggiorna(Double.parseDouble(elem[3]), Double.parseDouble(elem[4]));
                        break;
                    case "close":
                        company.getCampaign(elem[0]).chiudi();
                        break;

                }
                

        } catch (IllegalArgumentException | CampaignClosedException | NoSuchElementException | CampaignExistsException e) {
                System.out.println(e.getMessage());
            } 
        }

        System.out.println(company);
    }
}
