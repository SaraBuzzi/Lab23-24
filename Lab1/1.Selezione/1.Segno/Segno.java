public class Segno {
    public static void main(String[] args) {
        int numero = Integer.parseInt(args[0]);
        if (numero <= 0) {
            System.out.println(numero);
        } else {
            System.out.println("+" + numero);
        }
    }
}
