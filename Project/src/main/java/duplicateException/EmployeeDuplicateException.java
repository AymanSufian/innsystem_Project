package duplicateException;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeDuplicateException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeDuplicateException(String message) {
        super(message);
    }
}

