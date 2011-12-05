package ilife.user.exception;

/**
 * 
 * @author newman
 * 
 */
public class UserExistsException extends Exception {
	private static final long serialVersionUID = 4050482305178810162L;

	/**
	 * Constructor for UserExistsException.
	 * 
	 * @param message
	 *            exception message
	 */
	public UserExistsException(final String message) {
		super(message);
	}
}
