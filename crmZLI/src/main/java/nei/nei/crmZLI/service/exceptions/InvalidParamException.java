package nei.nei.crmZLI.service.exceptions;

@SuppressWarnings("serial")
public class InvalidParamException extends RuntimeException{

	public InvalidParamException(String format) {
		super(format);
	}

}
