package nei.nei.crmZLI.service.exceptions;

@SuppressWarnings("serial")
public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException(String format) {
		super(format);
	}
}
