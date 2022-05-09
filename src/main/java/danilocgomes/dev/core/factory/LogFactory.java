package danilocgomes.dev.core.factory;


import org.jboss.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LogFactory {

	@Produces
	@Dependent
	public Logger logger(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass());
	}
}
