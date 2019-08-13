package soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloService {
	@WebMethod
	public String helloWorld();
	
	@WebMethod
	public String helloName(@WebParam(name = "name") String name);

}
