public class Pitagorica {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        stampaTavolaPitagorica(creaTavolaPitagorica(n));
    }

    public static int[][] creaTavolaPitagorica(int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][0] = i+1;
            for (int j = 0; j < n; j++) {
                  ;
            }
        }
        return m;
    }

    public static void stampaTavolaPitagorica(int[][] m) {
        System.out.println(m[0]);
    }
}
