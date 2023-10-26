import java.util.ArrayList;


public class SommaUnici {
    public static void main(String[] args) {
        
        
        
        
    }

    public static ArrayList<Integer> leggiNumeri(String[] args) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < args.length; i++) {
            num.add(Integer.parseInt(args[i]));
        }
        return num;
    }

    public static int occorrenze(ArrayList<Integer> numeri, int n) {
        int o = 0;
        for (Integer numero : numeri) {
            if (numero == n) {
                o++;
            }
        }
        return o;
    }


    
} 
