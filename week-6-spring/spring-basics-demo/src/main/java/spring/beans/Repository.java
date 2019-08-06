package spring.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Repository
public class Repository {
	@Qualifier("dataSource")
	@Resource
	Datasource datasource;

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}

	public Repository(Datasource datasource) {
		super();
		this.datasource = datasource;
	}

	public Repository() {
		super();
	}

	@Override
	public String toString() {
		return "Repository [datasource=" + datasource + "]";
	}

}
