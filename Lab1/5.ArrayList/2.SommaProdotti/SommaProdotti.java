public class SommaProdotti {
    public static void main(String[] args) {
        if (args.length %2 != 0) {
            System.exit(0);
        }
        int[] num = new int[args.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(args[i]);
        }
        
        System.out.println("La somma è " + calcola(num));
    }

    public static int calcola(int[] n) {
        int totale = 0;
        for (int i = 0; i < n.length; i++) {
            if (i%2==0) {
                totale += n[i]*n[i+1];
            }
        }
        return totale;
    }

    
}
