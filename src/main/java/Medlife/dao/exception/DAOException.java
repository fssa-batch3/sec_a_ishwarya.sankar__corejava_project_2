package Medlife.dao.exception;

public class DAOException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8128504030369464433L;

	/**
	 * 
	 */

	public DAOException(String msg) {
		super(msg);
	}
	
	public DAOException(Throwable msg) {
		super(msg);
	}
}
