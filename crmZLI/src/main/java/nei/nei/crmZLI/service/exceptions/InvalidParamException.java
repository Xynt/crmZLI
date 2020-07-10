package nei.nei.crmZLI.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidParamException extends RuntimeException {

	public InvalidParamException(String format) {
		super(format, null, false, false);
	}

}
