public class Palindrome {

<<<<<<< HEAD
    private static boolean isPalindroma(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = args[0];
        String stamp = "";
        // System.out.print("[ ");

        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) { 
                String temp = s.substring(i,j+1); /** j+1 perchè non voglio le sottostringhe di due caratteri */
                if(isPalindroma(temp)) {
                    stamp += temp + " ";
                    System.out.print(temp + " ");
                }
            }
        }
       //  System.out.println("]");
       System.out.println("[ " + stamp + "]");
    }

}
=======
	private static boolean isPalindroma(String s) {

		for(int i = 0; i < s.length()/2; i++)
			if(s.charAt(i) != s.charAt(s.length()-i-1))
				return false;

		return true;
	}

	public static void main(String[] args) {

		String s = args[0];
		System.out.print("[ ");

		for (int i = 0; i < s.length(); i++) {
			for (int j = i+2; j <= s.length(); j++) {

				String temp = s.substring(i, j);

				if(isPalindroma(temp))
					System.out.print(temp + " ");
			}
		}

		System.out.println("]");
	}
}
>>>>>>> 651fd89ca57d1f683c0c2e81399f5d60acc1d690
