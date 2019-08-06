package spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component @Qualifier("dataSource")
public class Datasource {
	@Value("localhost:5432/moviedb")
	private String url;
	@Value("moviedb")
	private String user;
	@Value("p4ssw0rd")
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Datasource(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Datasource() {
	}

	@Override
	public String toString() {
		return "Datasource [url=" + url + ", user=" + user + ", password=" + password + "]";
	}

}
