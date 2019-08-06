package spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import spring.beans.Datasource;
import spring.beans.Repository;
import spring.beans.Service;

public class SpringJavaConfig {
	@Bean(name = "localDatasource")
	public Datasource localDatasource() {
		return new Datasource("localhost:5432/moviedb", "moviedb", "p4assw0rd");
	}
	
	@Bean(name = "localRepository")
	public Repository localRepository(@Qualifier("localDatasource") Datasource datasource) {
		return new Repository(datasource);
	}
	
	@Bean(name = "localService")
	public Service localService(Repository repository) {
		Service service = new Service();
		service.setRepository(repository);
		return service;
	}
}
