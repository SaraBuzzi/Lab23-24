import java.util.ArrayList;
import java.util.Scanner;

public class MinMaxAvgAL {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        
        ArrayList<Integer> l= new ArrayList<>();

        while(s.hasNext()) {
            l.add(Integer.parseInt(s.nextLine()));
        }


        System.out.println("Minimo: " + minimo(l));
        System.out.println("Massimo: " + massimo(l));
        System.out.println("Valore medio: " + media(l));
            
        }

    private static int minimo(ArrayList<Integer> in) {
        int min = in.get(0);
        for (int i = 1; i < in.size(); i++) {
          if (i < min) {
            min = in.get(i);
         }
        }
         return min;
        }


    private static int massimo(ArrayList<Integer> in) {
        int max = 0;
        for (int i = 0; i < in.size(); i++) {
            if (i > max) {
             max = i;
            }
        }

    /**  UGUALE MA FOR EACH
    for (int i : in) {
        if (i > max) {
            max = i;
        }
    }
    */
        return max;
        }


    private static double media(ArrayList<Integer> in) {
        double media = 0;
        for (int i : in) {
          media+=i;
        }
        return media/in.size();
    }

}


    


