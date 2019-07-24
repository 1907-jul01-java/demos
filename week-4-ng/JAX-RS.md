# JAX-RS - Java API for RESTful Web Services
As a part of Java Enterprise Edition, JAX-RS defines the standard for a Java implementation of a RESTful web service with annotations to configure resources and their handler methods. 

## Extending Tomcat
JAX-RS requires a full application server which implements the Java EE spec, such as Glassfish, so a simple servlet container like Tomcat must be extended with the necessary dependencies.

There are many implementations for JAX-RS, such as the reference implementation for Glassfish known as Jersey.

## Creating a resource
RESTful JAX-RS resources are organized into Controller classes annotated with `@Path("url")` and contain one or more handler methods for various HTTP requests. A variety of annotations for HTTP methods such as `@GET` and `@POST` will specify the precise kind of HTTP request a method will target, while `@PATH` can append further details for the HTTP's URL.

`@CONSUMES` and `@PRODUCES` specify the `Content-Type` headers for HTTP requests and responses respectively, and `@PATHPARAM` and `@QUERYPARAM` can map URL and query string parameters respectively to a method parameter.

## Servlet Dispatcher
Jersey provides a servlet dispatcher that acts as a front controller to all registered resources. There are several ways to configure it with or without a `web.xml`.

### Extending `Application`
An older method to configure the servlet dispatcher is to extend `javax.ws.rs.core.Application` and override the `getClasses()` method. This method must return a `Set` of resources.

The class may either be registered in the `web.xml` or annotated with `@ApplicationPath`

### Extending `ResourceConfig`
Another way is to extend `org.glassfish.jersey.server.ResourceConfig` and create a no-args constructor which calls `package()` and passes the package of all resources to scan and automatically register. This class may also be registered in the `web.xml` or annotated with `@ApplicationPath`.