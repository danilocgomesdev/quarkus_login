package danilocgomes.dev.core.exceptions;

import javax.ws.rs.WebApplicationException;

public class ApplicationExceptionBase extends WebApplicationException {
	private static final int HTTP_CODE_DEFAULT = 422;

	private final int httpCode;

	public ApplicationExceptionBase(String message) {
		super(message);
		this.httpCode = HTTP_CODE_DEFAULT;
	}

	public ApplicationExceptionBase(String message, Throwable cause) {
		super(message, cause);
		this.httpCode = HTTP_CODE_DEFAULT;
	}

	public ApplicationExceptionBase(int code, String message, Throwable cause) {
		super(message, cause);
		this.httpCode = code;
	}

	public ApplicationExceptionBase(Throwable cause) {
		super(cause);
		this.httpCode = HTTP_CODE_DEFAULT;
	}

	public ApplicationExceptionBase(int code, String message) {
		super(message);
		this.httpCode = code;
	}

	@Override
	public String getLocalizedMessage() {
		if (getCause() != null) {
			return getCause().getLocalizedMessage();
		}

		return super.getLocalizedMessage();
	}

	public int getHttpCode() {
		return httpCode;
	}
}
