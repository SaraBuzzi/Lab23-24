public class Mesi {
    public static void main(String[] args) {
        String mese = args[0];
        switch (mese) {
            case "febbraio":
                System.out.println("Il numero di giorni di " + mese + " è 28");
                break;
            case "aprile", "giugno", "settembre", "novembre" :
                System.out.println("Il numero di giorni di " + mese + " è 30");
                break;
            case "gennaio", "marzo", "maggio", "luglio", "agosto", "ottobre", "dicembre":
                System.out.println("Il numero di giorni di " + mese + " è 31");
                break;
            default:
                System.out.println("Il nome del mese non è corretto");
        }
    }
}
