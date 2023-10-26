public class Voto {
    public static void main(String[] args) {
        int voto = Integer.parseInt(args[0]);
        if (voto<60) {
            System.out.println("Insufficiente");
        } else if (voto>60 && voto<70) {
            System.out.println("Sufficiente");
        } else if (voto>=70 && voto<80) {
            System.out.println("Buono");
        } else if (voto>=80 && voto<90) {
            System.out.println("Distinto");
        } else if (voto>=90 && voto<=100) {
            System.out.println("Ottimo");
        } else {
            System.out.println("Errore");
        }
    }
}
