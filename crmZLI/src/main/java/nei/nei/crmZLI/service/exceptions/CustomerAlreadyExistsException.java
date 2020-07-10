package nei.nei.crmZLI.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException(String format) {
		super(format, null, false, false);
	}
}
