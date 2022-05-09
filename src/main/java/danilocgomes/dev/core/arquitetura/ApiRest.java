package danilocgomes.dev.core.arquitetura;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/versao")
@Produces(MediaType.APPLICATION_JSON)
public class ApiRest {


	@ConfigProperty(name = "quarkus.application.version")
	String version;

	@GET
	public String getVersion() {
		return "{ \"API\": " + version + " }";
	}
}
