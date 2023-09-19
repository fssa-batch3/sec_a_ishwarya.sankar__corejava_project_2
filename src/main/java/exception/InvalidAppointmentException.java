package exception;

public class InvalidAppointmentException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAppointmentException(String msg) {
		super(msg);
	}

	public InvalidAppointmentException(Throwable e) {
		super(e);
	}

}
