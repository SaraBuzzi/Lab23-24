 public class Radice {
    public static void main(String[] args) {
        double n = Double.parseDouble(args[0]);
        if (radiceQuadrata(n) == 0) {
            System.out.println("Il valore inserito non appartiene al dominio della funzione");
        } else {
            System.out.println("Radice quadrata: "+ radiceQuadrata(n));
        }
    }

    public static double radiceQuadrata(double numero) {
        if (numero>0) {
            return Math.sqrt(numero);
        } 
        return 0;
    }
}
