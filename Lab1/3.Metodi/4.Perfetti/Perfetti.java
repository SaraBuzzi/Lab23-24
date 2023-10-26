public class Perfetti {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (perfetto(n)) {
            System.out.println(n + " è perfetto");
        } else {
            System.out.println(n + " non è perfetto");
        }
    }

    public static int sommaDivisoriPropri(int n) {
        int somma = 0;
        for (int i = 1; i < n; i++) {
            if (n%i == 0) {
                somma += i;
            }
        }
       
        return somma;
    }

    public static boolean perfetto(int n) {
        if (n==0) {
            return false;
        } 
        return (n==sommaDivisoriPropri(n));
    }
}
