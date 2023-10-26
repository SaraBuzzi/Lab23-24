public class Angoli {
    public static void main(String[] args) {
        int a1 = Integer.parseInt(args[0]);
        int a2 = Integer.parseInt(args[1]);
        int a3 = 180 - a1 - a2;
        if ((a1+a2+a3 != 180 ) || (a3<0)) {
            System.out.println("I due angoli non appartengono ad un triangolo");
        } else {
            System.out.println("Ampiezza terzo angolo = " + a3 + "°");
        }
    }
}
