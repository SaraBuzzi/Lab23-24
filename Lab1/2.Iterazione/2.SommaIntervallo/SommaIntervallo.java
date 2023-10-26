public class SommaIntervallo {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int somma = 0;

        for (int i = a + 1; i < b; i++ ) {
            if (i%2 == 0) {
               somma += i; 
            }
        }

        System.out.println("Somma = " + somma);
    }

    
}
