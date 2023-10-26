import java.time.DateTimeException;
import java.time.format.DateTimeParseException;

public class FormatoOra {
    public static void main(String[] args) {
        try {
            System.out.println(converti(args[0]));
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }   
    }

    public static String converti(String s) throws DateTimeParseException {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3));
        s.
        if ( h>24 || h<0 || m > 60 || m < 0) {
            throw new DateTimeException("Formato ora non valido");
        }
        String o = "AM";
        if (h>12) {
            h-=12;
            o = "PM";
        }
        return h + s.substring(2) + " " + o;  
    }
}
