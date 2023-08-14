package Medlife.validation.exception;

public class InvalidMedicineException 	extends Exception {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
		public InvalidMedicineException(String msg) {
			super(msg);
		}
		
		public InvalidMedicineException(Throwable msg) {
			super(msg);
		}
	}


