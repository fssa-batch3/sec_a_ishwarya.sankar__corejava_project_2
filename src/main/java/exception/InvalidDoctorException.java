package exception;

public class InvalidDoctorException extends Exception{

	public InvalidDoctorException(String msg) {
		super(msg);
	}

	public InvalidDoctorException(Throwable e) {
		super(e);
	}
}
