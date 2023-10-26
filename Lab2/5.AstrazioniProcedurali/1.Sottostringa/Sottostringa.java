public class Sottostringa {
    public static void main(String[] args) {
        String stringa1 = args[0];
        String stringa2 = args[1];

        if (sottoStringa(stringa1, stringa2)) {
            System.out.println(stringa2 + " è sottostringa di " + stringa1);
        } else {
            System.out.println(stringa2 + " non è sottostringa di " + stringa1);
        }

    }

    public static boolean sottoStringa(String stringa1, String stringa2) {
        return stringa1.contains(stringa2);
    }
}
