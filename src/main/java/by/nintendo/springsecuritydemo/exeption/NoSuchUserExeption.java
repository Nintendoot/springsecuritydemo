package by.nintendo.springsecuritydemo.exeption;

public class NoSuchUserExeption extends RuntimeException{
    public NoSuchUserExeption() {
    }

    public NoSuchUserExeption(String message) {
        super(message);
    }

    public NoSuchUserExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchUserExeption(Throwable cause) {
        super(cause);
    }

    public NoSuchUserExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
