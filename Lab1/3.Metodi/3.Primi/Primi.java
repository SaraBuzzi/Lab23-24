public class Primi {
    public static void main(String[] args) {
        int soglia = Integer.parseInt(args[0]);
        if (soglia<=0) {
            System.out.println("La soglia non è positiva");
        } else {
            numeriPrimi(soglia);
        }
    
    }

    public static boolean primo(int n) {
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void numeriPrimi(int limite) {
        System.out.println("Numeri primi inferiori a " + limite);
        for (int i = 2; i < limite; i++) {
            if (primo(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
