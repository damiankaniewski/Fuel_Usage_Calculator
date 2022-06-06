package fc.exceptions;

public class EmptyFieldException extends Exception {
    public EmptyFieldException() {
        super("Wymagane podanie informacji!");
        //System.out.println("Wymagane podanie informacji...");
    }
}