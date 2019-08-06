package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.beans.Controller;
import spring.beans.Service;
import spring.config.SpringAnnotationConfig;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext aac;
		//aac = new ClassPathXmlApplicationContext("xmlConfig.xml");
		//aac = new AnnotationConfigApplicationContext(SpringJavaConfig.class);
		//aac = new ClassPathXmlApplicationContext("annotationConfig.xml");
		aac = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
		Service service = aac.getBean(Service.class);
		Controller controller = aac.getBean(Controller.class);
		System.out.println(service);
		System.out.println(controller);
		aac.close();
	}

}
