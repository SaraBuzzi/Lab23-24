public class Divisori {
<<<<<<< HEAD
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        
    }
=======
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		System.out.print("Divisori di " + n + ": ");

		for(int i = 1; i <= n/2; i++)
			if(n % i == 0)
				System.out.print(i + " ");

		System.out.println();
	}
>>>>>>> 651fd89ca57d1f683c0c2e81399f5d60acc1d690
}
