package exception;

public class InvalidFeedbackException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFeedbackException(String msg) {
		super(msg);
	}

	public InvalidFeedbackException(Throwable e) {
		super(e);
	}
}