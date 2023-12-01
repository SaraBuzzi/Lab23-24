public class Main {
    public static void main(String[] args) {
        
        Mazzo mazzo = new Mazzo();

        mazzo.mischia();
        System.out.println(mazzo);

        mazzo.ordina();
        System.out.println(mazzo);
    }
}
