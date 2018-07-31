package exception;

public class LivroExistenteException extends Exception {

    public LivroExistenteException() {
    }

    public LivroExistenteException(String message) {
        super(message);
    }

    public LivroExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public LivroExistenteException(Throwable cause) {
        super(cause);
    }

    public LivroExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
