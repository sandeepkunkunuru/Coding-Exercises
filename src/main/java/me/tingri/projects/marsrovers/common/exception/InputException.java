package me.tingri.projects.marsrovers.common.exception;

import me.tingri.projects.marsrovers.common.util.Logger;

public class InputException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for 
     *          later retrieval by the {@link #getMessage()} method.
     */
    public InputException(String message, String... params) {
    	super(String.format(message, (Object[])params));
    	Logger.log(String.format(message, (Object[])params));
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public InputException(String message, Throwable cause, String...params) {
        super(String.format(message, (Object[])params), cause);
    	Logger.log(String.format(message, (Object[])params));
    }

}
