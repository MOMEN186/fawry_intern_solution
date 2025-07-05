package exceptions;

public class CheckOutException extends RuntimeException {
    public CheckOutException(String message) {
        super(message);
    }
}
