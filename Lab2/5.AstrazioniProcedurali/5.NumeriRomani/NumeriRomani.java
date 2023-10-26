import java.util.HashMap;
import java.util.Map;

public class NumeriRomani {
    //OVERVIEW: classe statica che fa la conversione tra numeri arabi e romani

    public static boolean isRoman(String s) {
        //EFFECTS: if s is a roman number returns true, false otherwise

        Map<String, Integer> r2m = new HashMap<>();
        r2m.put("I", 1);
        r2m.put("IV", 4);
        r2m.put("V", 5);
        r2m.put("IX", 9);
        r2m.put("X", 10);
        r2m.put("XL", 40);
        r2m.put("L", 50);
        r2m.put("XC", 90 );
        r2m.put("C", 100);
        r2m.put("CD", 400);
        r2m.put("D", 500);
        r2m.put("CM", 900);
        r2m.put("M", 1000);

        int i = 0; 
        int lastValue = Integer.MAX_VALUE; 
        while (i < s.length()) { 
           if (i < s.length()-1 && r2m.containsKey(s.substring(i, i+2)) && r2m.get(s.substring(i, i+2)) < lastValue) { 
                lastValue = r2m.get(s.substring(i, i+2));
                i+=2;
           } else if (r2m.containsKey(s.substring(i, i+1)) && r2m.get(s.substring(i, i+1)) <= lastValue) {
                lastValue = r2m.get(s.substring(i, i+1));
                i++;
                
           } else {
            return false;
           }
        }

        return true;
    }


    public static boolean isArab(String s) {
        //EFFECTS: if s is an arab number returns true, false otherwise
        if (s.charAt(0) < '1' || s.charAt(0) > '9' ) {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }


    public static String A2R(int i) {
        //REQUIRES: i > 0
        //EFFECTS: returns i converted to roman numbers (as a string)
        String ret = "";
        int curr = i;
        int[] valori = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romani = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int j = 0; j < valori.length; j++) {
            while (curr >= valori[j])  {
                curr-=valori[j];
                ret+= romani[j];
        
        }
        }
        return ret;
    }


    public static int R2A(String s) {
        //REQUIRES: s is a valid roman number
        //EFFECTS: returns s converted to arab numbers (in int)
        Map<String, Integer> r2m = new HashMap<>();
        r2m.put("I", 1);
        r2m.put("IV", 4);
        r2m.put("V", 5);
        r2m.put("IX", 9);
        r2m.put("X", 10);
        r2m.put("XL", 40);
        r2m.put("L", 50);
        r2m.put("XC", 90 );
        r2m.put("C", 100);
        r2m.put("CD", 400);
        r2m.put("D", 500);
        r2m.put("CM", 900);
        r2m.put("M", 1000);

        int i = 0;  
        int tot = 0; 

        while (i < s.length()) { 
           if (i < s.length()-1 && r2m.containsKey(s.substring(i, i+2))) { 
                tot+= r2m.get(s.substring(i, i+2));
                i+=2;
           } else if (r2m.containsKey(s.substring(i, i+1))){
                tot+= r2m.get(s.substring(i, i+1));
                i++;
           }
        }
        return tot;
    }

    public static void main(String[] args) {
        
        if (isRoman(args[0])) {
            System.out.println(R2A(args[0]));
        } else if (isArab(args[0])) {
            System.out.println(A2R(Integer.parseInt(args[0])));
        }
    }

    
}
