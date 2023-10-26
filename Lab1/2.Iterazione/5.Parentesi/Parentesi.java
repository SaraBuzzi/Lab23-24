

public class Parentesi {
    public static void main(String[] args) {
        String parentesi = args[0];
        int counter = 0;

        for (int i = 0; i < parentesi.length(); i++) {
            if (parentesi.charAt(i) == '[' ) { 
                counter++;
            } else {
                counter--;
            }
            if (counter < 0) {
                System.out.println("Non bilanciate");
                System.exit(0);
            }
        }   

        if (counter == 0) {
            System.out.println("Bilanciate");
        } else {
            System.out.println("Non bilanciate");
        }
    }
}
public class Parentesi {
	public static void main(String[] args) {
		String s = args[0];

		int counter = 0;

		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '[') {
				counter++;
			} else if(counter > 0) {
				counter--;
			} else {
				System.out.println("Non bilanciate");
				System.exit(0);
			}
		}

		if(counter != 0)
			System.out.println("Non bilanciate");
		else
			System.out.println("Bilanciate");
	}
}
