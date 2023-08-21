package exception;

public class InvalidMedicineException extends Exception {

	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidMedicineException(String msg) {
		super(msg);
	}

	public InvalidMedicineException(Throwable e) {
		super(e);
	}
}
