package it.nsa.common.exception;

public class UnauthorizedInvalidTokenException extends RuntimeException{

    public UnauthorizedInvalidTokenException(String message) {
        super(message);
    }

    public UnauthorizedInvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }

}
