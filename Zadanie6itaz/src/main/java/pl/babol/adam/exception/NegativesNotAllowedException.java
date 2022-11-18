package pl.babol.adam.exception;

public class NegativesNotAllowedException extends RuntimeException {
    public NegativesNotAllowedException(String message) {
        super(message);
    }
}
