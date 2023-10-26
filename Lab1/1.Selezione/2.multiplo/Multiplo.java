public class Multiplo {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        if (num1%num2 == 0) {
            System.out.println(num1 + " è multiplo di " + num2);
        } else {
             System.out.println(num1 + " non è multiplo di " + num2);
        }
    }
}
