package kaans.com.app.exceptions;

public class InternalServerError extends RuntimeException{

    public InternalServerError(String message) {
        super(message);
    }

}
