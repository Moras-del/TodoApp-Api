package pl.ug.kuznia.todoappapi.internal.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message+" not found");
    }
}
