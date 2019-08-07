package spring.beans;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	Service service;

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Controller [service=" + getService() + "]";
	}

	public Controller(Service service) {
		super();
		this.service = service;
	}

	public Controller() {
		super();
	}
	
	public void error() throws IOException {
		throw new IOException();
	}

}
