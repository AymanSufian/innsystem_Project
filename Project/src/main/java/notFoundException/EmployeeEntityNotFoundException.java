package notFoundException;


	public class EmployeeEntityNotFoundException extends RuntimeException {
		
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmployeeEntityNotFoundException(String message) {
	        super(message);
	    }
	}


