package com.appscharles.libs.dialoger.exceptions;

/**
 * The type Databaser exception.
 */
public class DialogerException extends Exception {
    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7821375828346530432L;

    /**
     * Instantiates a new Databaser exception.
     */
    public DialogerException() {
        super();
    }

    /**
     * Instantiates a new Databaser exception.
     *
     * @param message the message
     */
    public DialogerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Databaser exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DialogerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Databaser exception.
     *
     * @param cause the cause
     */
    public DialogerException(Throwable cause) {
        super(cause);
    }

}

