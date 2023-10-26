/**
 * Conversioni
 */
public class Conversioni {

    public static void main(String[] args) {
        double qty = Double.parseDouble(args[0]);

        String unit1 = args[1];
        String unit2 = args[3];

        switch (unit1) {
            case "minuti":
                qty*=60; /** sto moltiplicando qty per sessanta */
                break;
            case "ore":
                qty*=60*60;
                break;
            case "giorni":
                qty*=60*60*24;
                break;
            case "mesi":
                qty*=60*60*24*30;
                break;
            case "anni":
                qty*=60*60*24*30*12;
                break;
        }

        switch (unit2) {
            case "minuti":
                qty/=60; /** sto dividendo qty per sessanta */
                break;
            case "ore":
                qty/=60*60;
                break;
            case "giorni":
                qty/=60*60*24;
                break;
            case "mesi":
                qty/=60*60*24*30;
                break;
            case "anni":
                qty/=60*60*24*30*12;
                break;
        }
        
        System.out.println(args[0] + " " + unit1 + " corrispondono a " + qty + " " + unit2);
    }
public class Conversioni {
	public static void main(String[] args) {
		double result = Double.parseDouble(args[0]);

		switch(args[1]) {
			case "minuti":
				result *= 60;
				break;
			case "ore":
				result *= 60*60;
				break;
			case "giorni":
				result *= 60*60*24;
				break;
			case "mesi":
				result *= 60*60*24*30;
				break;
			case "anni":
				result *= 60*60*24*365;
				break;
		}

		switch(args[3]) {
			case "minuti":
				result /= 60;
				break;
			case "ore":
				result /= 60*60;
				break;
			case "giorni":
				result /= 60*60*24;
				break;
			case "mesi":
				result /= 60*60*24*30;
				break;
			case "anni":
				result /= 60*60*24*365;
				break;
		}

		System.out.println(args[0] + " " + args[1] + " corrispondono a " + result + " " + args[3]);
	}
}