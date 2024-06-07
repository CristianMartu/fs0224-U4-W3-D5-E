package cristianmartucci.exceptions;

public class ElementException extends RuntimeException {
    public ElementException(String ISBN) {
        super("Nessun elemento trovato con ISBN: " + ISBN);
    }
}
