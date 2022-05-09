package danilocgomes.dev.core.exceptions.mapper;

import danilocgomes.dev.core.exceptions.ApplicationExceptionBase;
import danilocgomes.dev.core.util.RestUtils;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationExceptionBase> {

	@Inject
	Logger logger;

	@Override
	public Response toResponse(ApplicationExceptionBase applicationExceptionBase) {
		logger.info("Gerando resposta para exception base");
		if (applicationExceptionBase == null) {
			return createDefaultErrorResponse();
		} else if (applicationExceptionBase.getMessage() == null) {
			if (applicationExceptionBase.getCause() == null)
				return createDefaultErrorResponse();
			else if (applicationExceptionBase.getCause().getMessage() == null) {
				return createDefaultErrorResponse();
			}
		}

		String message = applicationExceptionBase.getMessage();
		int httpCode = applicationExceptionBase.getHttpCode();
		logger.info("Gerando resposta {} para exception: {}");

		String errorJson = RestUtils.createErrorJson(httpCode, message, applicationExceptionBase.getCause(), applicationExceptionBase.getStackTrace());
		return Response.status(httpCode).entity(errorJson).build();
	}

	private Response createDefaultErrorResponse() {
		logger.info("Gerado erro padrão 500 de servidor");
		return Response.serverError().build();
	}
}
