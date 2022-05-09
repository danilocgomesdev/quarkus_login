package danilocgomes.dev.core.exceptions;

public class FiltroException extends ApplicationExceptionBase {
	public FiltroException(String filtro, Throwable throwable) {
		super("Erro ao tentar converter filtro: " + filtro, throwable);
	}
}
