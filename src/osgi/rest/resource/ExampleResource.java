package osgi.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class ExampleResource {

	@GET
	public String helloWorld() {
		return "Hello World!";
	}
}
