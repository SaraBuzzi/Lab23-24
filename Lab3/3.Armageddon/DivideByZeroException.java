
public class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("Non puoi dividere per zero");
    }

    public DivideByZeroException(String s) {
        super(s);
    }
}
