package com.squarefootgardenplanner.service.exceptions;

/**
 * Exception to throw when a given plant type and name is not found in the database.
 */
public class PlantNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4110253649886702779L;

    /**
     * Exception with no message or cause.
     */
    public PlantNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public PlantNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public PlantNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public PlantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
