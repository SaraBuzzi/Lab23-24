import java.util.Scanner;

public class TopN {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Inserisci almeno " + n + " numeri interi diversi tra loro (CTRL+D per terminare):");
        int[] num = readIntArray();
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

    private static int[] readIntArray() {
        int[] num = new int[];
        int i = 0;
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            num[i] = Integer.parseInt(s.nextLine());
            i++;
        }
        return num;
    }
}
