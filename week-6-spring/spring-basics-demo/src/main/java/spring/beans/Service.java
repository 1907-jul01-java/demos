package spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@org.springframework.stereotype.Service
public class Service {
	@Resource
	Repository repository;

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public Service(Repository repository) {
		super();
		this.repository = repository;
	}

	public Service() {
		super();
	}

	@Override
	public String toString() {
		return "Service [repository=" + repository + "]";
	}
	
	@PostConstruct
	public void logAfterCreation() {
		System.out.println("Service created");
	}

	@PreDestroy
	public void logbeforeShutdown() {
		System.out.println("Service destroyed");
	}
}
