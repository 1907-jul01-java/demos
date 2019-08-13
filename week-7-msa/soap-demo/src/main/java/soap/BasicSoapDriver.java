package soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;
import javax.jws.WebParam;

@WebService
public class BasicSoapDriver {

	@WebMethod
	public String helloWorld() {
		return "Hello, World!";
	}

	@WebMethod
	public String helloName(@WebParam(name = "name") String name) {
		return "Hello, " + name + "!";
	}
	
	@WebMethod
	public Director steven() {
		return new Director(1, "Steven Spielberg");
	}
	
	@WebMethod
	public Director postDirector(@WebParam Director director) {
		return director;
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/hello", new BasicSoapDriver());
	}

}
