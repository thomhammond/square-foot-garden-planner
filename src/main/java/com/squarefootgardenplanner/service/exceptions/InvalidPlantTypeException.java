package com.squarefootgardenplanner.service.exceptions;

//TODO: Do I still need this?
public class InvalidPlantTypeException extends RuntimeException {
    private static final long serialVersionUID = -3512117163378550420L;

    /**
     * Exception with no message or cause.
     */
    public InvalidPlantTypeException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public InvalidPlantTypeException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public InvalidPlantTypeException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public InvalidPlantTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
