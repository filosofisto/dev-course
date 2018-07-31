package exception;

public class LivroNaoEncontradoException extends Exception {

    public LivroNaoEncontradoException() {
    }

    public LivroNaoEncontradoException(String message) {
        super(message);
    }

    public LivroNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public LivroNaoEncontradoException(Throwable cause) {
        super(cause);
    }

    public LivroNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
