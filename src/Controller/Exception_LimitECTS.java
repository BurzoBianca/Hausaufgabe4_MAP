package Controller;

/**
 * Exceptie pe care o folosim atunci cand limita de credite este atinsa
 */

public class Exception_LimitECTS extends RuntimeException {

    public Exception_LimitECTS(String message) {
        super(message);
    }
}
