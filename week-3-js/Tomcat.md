# Tomcat Web Server
Download [Tomcat](http://tomcat.apache.org/) and extract the archive somewhere.

## Deploying a Java web app to Tomcat
### Manual deployment
Package the project into a `war` file, then move the file into your Tomcat server's webapp folder. Tomcat should unpack and deploy the application automatically.

### IDE debug server
Eclipse and other IDEs can deploy an application onto a debug server for testing. Use the Eclipse server view to install Tomcat then add the project to the workspace.

## Embedded Tomcat
### Tomcat Maven Plugin
Add the `tomcat7-maven-plugin` to the `pom.xml`:
```xml
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <path>/${project.build.finalName}</path>
                    <finalName>executable.jar</finalName>
                </configuration>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```
Then run the project with Maven:
>mvn tomcat7:run

If Tomcat is installed, with the CATALINA_HOME environment variable set, the same plugin can be used to deploy the application to the server with:
>mvn tomcat7:deploy

### Tomcat Embedded API
Tomcat embed is a library that allows for programmatic configuration and deployment of an embedded server within a Java application. In the `pom.xml`:
```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-core</artifactId>
    <version>8.5.23</version>
</dependency>
```

Then in a main method:
```java
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // Set context path and root folder
        String contextPath = "/";
        String docBase = new File(".").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, docBase);

        // Declare, define, and map servlets
        HttpServlet helloServlet = new HttpServlet(){
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                PrintWriter out = resp.getWriter();
                out.write("<html><title>Example</title><body><h1>Hello, World!</h1></body></html>");
                out.close();
            }
        };

        String servletName = "HelloServlet";
        String urlPattern = "/hello";

        // Register servlets with Tomcat
        Tomcat.addServlet(context, servletName, helloServlet);
        context.addServletMappingDecoded(urlPattern, servletName);

        // Start the server
        tomcat.start();
        tomcat.getServer().await();
    }
}
```