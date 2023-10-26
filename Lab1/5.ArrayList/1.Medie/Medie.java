import java.util.ArrayList;

public class Medie {
    public static void main(String[] args) {
        double somma = 0;
        ArrayList<Double> num = new ArrayList<Double>();
        for (int i = 0; i < args.length; i++) {
            num.add(Double.parseDouble(args[i]));
        }

        for (double x : num) {
            somma += x;
        }
        
        System.out.println("Media aritmetica: " + somma/num.size());
    }
}
