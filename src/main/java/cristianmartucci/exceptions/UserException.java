package cristianmartucci.exceptions;

public class UserException extends RuntimeException {
    public UserException(String card_id) {
        super("Nessun utente trovato con card_id: " + card_id);
    }
}
