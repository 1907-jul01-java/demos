package soap;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.HelloService", serviceName = "HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String helloWorld() {
		return "Hello World";
	}

	@Override
	public String helloName(String name) {
		return "Hello, " + name;
	}

}
