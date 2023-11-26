public class Main {
    public static void main(String[] args) {
        ScontoSemplice politica1 = new ScontoQuantita(
                10, 10, 5, 20);
        ScontoSemplice politica2 = new UnoOgniNGratis(
                11, 10, 3);
        ScontoSemplice politica3 = new UnoOgniNGratis(
                politica1.numeroArticoli, politica1.prezzoArticolo, 3);

        System.out.println("Politica1: " + politica1.toString());
        System.out.println("Sconto: " + politica1.calcolaSconto());

        System.out.println("Politica2: " + politica2.toString());
        System.out.println("Sconto: " + politica2.calcolaSconto());

        System.out.println("Politica3: " + politica3.toString());
        System.out.println("Sconto: " + politica3.calcolaSconto());

        ScontoCombinato scontoCombinato = null;

        // Caso di Politiche non combinabili
        try {
            scontoCombinato = new ScontoCombinato(politica1, politica2);
            System.out.println("Politiche 1 e 2 Combinabili! Sconto: " + scontoCombinato.calcolaSconto());
        } catch (IllegalArgumentException e) {
            System.out.println("Politiche 1 e 2 Non Combinabili!");
        }

        // Caso di Politiche combinabili
        try {
            scontoCombinato = new ScontoCombinato(politica1, politica3);
            System.out.println("Politiche 1 e 3 Combinabili! Sconto Combinato: " + scontoCombinato.calcolaSconto());
        } catch (IllegalArgumentException e) {
            System.out.println("Politiche 1 e 3 Non Combinabili!");
        }

    }

}


