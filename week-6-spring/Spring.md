# Design Patterns: Dependency Injection
Some classes require another class, a dependency. While the dependency can be defined in the dependant class's own constructor, this introduces several problems such as tightly coupling the two classes and introducing difficulties during unit testing. To solve this, we can inject the dependency as an argument into the dependant class's constructor or setter.

```java
public class Order {
    private Customer customer;

    // Constructor Injection
    public Order(Customer customer) {
        this.customer = customer;
    }

    // Setter Injection
    public setCustomer(Customer customer) {
        this.customer = customer;
    }
	
	public void receipt() { /* Business logic */ }
}
```

Unfortunately, `Order` needs to lookup its Customer dependency elsewhere. You'll need to construct dependencies recursively:
```java
public class App {
	public static void main(String[] args) {
		// Factory logic
		Customer customer = new Customer();
		Order order = new Order(customer);
		
		// Business logic
		order.receipt();
	}
}
```

We can let Spring's IoC Container handle the factory logic for us instead.

# Spring Framework
Documentation: https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html
Spring Framework is a highly modular Application Framework built upon an IoC Container. It offers similar features to JavaEE's EJBs and can interface well with many other specifications such as JPA. Spring can be configured and deployed without the need for an application server with only a few modules, or it can become a self-executing server in the form of a Spring Boot project.

## Inversion of Control (IoC) Container
Spring implements inversion of control through its Core IoC Container, which manages object lifecycles and automatic dependency injection. An object managed by the container, known as a **Spring Bean**, is instantiated, deployed when requested, and destroyed automatically. Any dependencies required by the bean are also injected through constructor arguments, arguments to a factory method, or properties set on the object instance after its construction. The IoC Container is known today as the Application Context, and originally called the Bean Factory.

The goal of an IoC Container is to decouple execution from configuration (business logic from factory logic). By separating these concerns, an application's code base becomes more modular, loosely coupled, with less focus on how code will be implemented and more on its business logic.

The phrase 'inversion of control' refers to this process of configuring dependencies for a bean, rather than the bean controlling the process for its own dependencies.

## Modules
The IoC container is made up of the spring-core, spring-beans, and spring-context modules, but other dependent modules such as spring-aop are commonly used as well. The container can be further extended with the inclusion of other Spring frameworks such as spring-mvc, spring-data, spring-security, spring-cloud, and much more.

## Configuration
While Spring Boot consolidates many modules and follows a 'convention over configuration' approach, most Spring modules can be individually configured either through an XML file or through Java annotations. Spring Boot can load properties files and also offers native support for YAML.

Many modules provide their own preconfigured beans, but custom beans can also be configured by registering them in the XML configuration file or through annotations which are then scanned by the container. Once all beans and configuration options are gathered, an Application Context is created to act as the IoC container for a program.

The Application Context is an interface with several factories to build one according to the manner of configuration, such as ClassPathXmlApplicationContext or FileSystemXmlApplicationContext for XML files, or XmlWebApplicationContext for Spring MVC built on Tomcat. There is also AnnotationConfigApplicationContext for a configuration class.

## BeanFactory vs ApplicationContext
The Bean Factory was the original interface for Spring, and has been superceded by the more capable Application Context. Bean Factory was a sophisticated implementation of the factory design pattern which lazily and programmatically instantiate beans as singletons.

Application Context is an extension of the Bean Factory, eagerly instantiating beans and capable of defining several different scopes besides singleton.

## Bean Lifecycle
Source: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html
Spring's container handles the lifecycle of a bean through a complex series of steps. In general, the setup phase involves instantiation of the empty object, handling of its dependencies, initialization of properties and default values, and any custom initialization methods before the bean is ready for use within the program. The teardown phase dereferences the bean when it passes out of scope (or the container is itself shutdown), but also calls any custom destroy methods along the way.

Simplified Lifecycle:
	▪ Instantiate Bean
	▪ Populate Bean (Inject Dependencies)
	▪ Set awareness of context values
	▪ BeanPostProcessor
	▪ (Optional) Custom Init method
	▪ Bean is ready for use! (Bean Mitzvah)
	▪ destroy()/custom destroy method (when container is shut down)
        
As a rule, we do not need to interfere with the lifecycle, but Spring provides several callback methods to customize it in subtle ways. We can implement the InitializingBean/DisposableBean interfaces and override their afterPropertiesSet/destroy methods, or we can define our own custom init and destroy methods in XML configuration or through @PostConstruct/@PreDestroy annotations.

## Bean Scopes
A bean has several scopes, two of which are available to a basic Application Context while the rest are usually seen in a Spring web program.

| Scope | Description |
|------|------|
| singleton | (Default) Scopes a single bean definition to a single object instance for each Spring IoC container.|
| prototype | Scopes a single bean definition to any number of object instances.|
|request | Scopes a single bean definition to the lifecycle of a single HTTP request. That is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring ApplicationContext.
| session | Scopes a single bean definition to the lifecycle of an HTTP Session. Only valid in the context of a web-aware Spring ApplicationContext.|
| application | Scopes a single bean definition to the lifecycle of a ServletContext. Only valid in the context of a web-aware Spring ApplicationContext. |
| websocket | Scopes a single bean definition to the lifecycle of a WebSocket. Only valid in the context of a web-aware Spring ApplicationContext. |

The most important are Singleton and Prototype for most Spring applications. Singleton is the default scope where there is one bean (of its kind) per container, which is best for stateless objects. This is not to be confused with a proper Java singleton which has hardcoded scope within a class loader. A Singleton scoped bean is cached and returned whenever that named object is requested.

Prototype scope can have any number of instances per bean definition, and instead of caching existing beans a new instance is created for each bean request. This makes it ideal for stateful objects, but Spring no longer manages the full lifecycle for us making it little different from calling the 'new' keyword ourselves.

## Bean Wiring 
Spring can inject beans as dependencies of other beans through Setter or Constructor Injection. Beans can be wired manually through property element attributes in an XML configuration file or through annotations. Dependencies can be registered and referenced either by its bean name or by its type.

By far the most popular and easiest method is 'Autowiring' where Spring will figure out a dependency 'automagically' based on its Stereotype annotation.

### Stereotype Annotations
https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html
Component is the most basic stereotype and will work for any and all Spring beans. More specific stereotypes such as Service or Repository mostly add unique exception handling for those purposes but otherwise work the same way as Component.

# AOP - Aspect Oriented Programming
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#aop

In OOP, the unit of modularity is the object or class, but it doesn't resolve some issues of tightly coupled code that is only tangentially related to your business logic:
- Logging
- Exception Handling
- Configurations
- Security/Validation
- Transactions
- Tests

In other words: cross-cutting concerns.

In AOP, the unit of modularity is the aspect, otherwise known as a cross-cutting concern. These are code snippets or statements that can be injected into an application which is decoupled from the business logic.

# Spring AOP
With Spring we can define aspects as a class that has several methods which will act as interceptors to other methods in our application. These interceptors are known as advices which will take certain types of actions.
 - **Advice**: Action to be taken at Join Point
 - **Join Point**: Method where code will be injected
 - **Pointcut**: expression which specifies join points where advices will be applied

## Advice
Action that occurs at the joinpoint which has several types:
- Before: preceeds join point, can't interfere with the joinpoint unless exception is thrown
- After - proceeds join point (After-Finally)
    - After-returning: proceeds normal execution of joinpoint
    - After-throwing proceeds if exeption is thrown
- Around - the most powerful advice, acts both before and after, and requires that the developer calls JoinPoint.proceed() to continue join point execution.

## Pointcut
Each advice will have an expression next to their Advice annotation which determines what to listen for in the stack.
- Target: object or method being advised
- AOP Proxy from Spring AOP framework will intercept calls to target and delegate appropriate advice

```java
@Aspect
@Component
public class AnimalAdvisor {
    @Before
    public void beforeGetter(execution(* get*(..)) {
        System.out.println("This prints before every getter is run");
    }
}
```

Examples
- Execution of any public method
> execution(public * *(..))
- Execution of any method starting with 'set'
> execution(* set*(..))
- Execution of any method defined within AnimalService interface
> execution(* com.revature.service.AnimalService.*(..))
- Execution of any method defined within com.revature.demo package
``` execution(* com.revature.demo.*.*(..))```
- Now in subpackage
``` execution(* com.revature.demo..*(..))```
- Within a package
> within(com.revature.demo.*)

# Spring Web MVC
https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html

Spring's web framework is built on the Servlet API and deployed on its own embedded Servlet container. Centered around its Dispatcher Servlet, Spring MVC handles much of the complexity of the request-response cycle.

## MVC Design Pattern
- Model: The data being passed, rendered, and manipulated
- View: What will be displayed, usually as html
- Controller: Handles logic, routing

## Spring MVC Request-Response Flow
1. Request sent to `DispatcherServlet`
1. `DispatcherServlet` calls `HandlerMapping` for help with request URI
1. `HandlerMapping` looks up the handler for the URI, a registered `Controller` which is returned to the `DispatcherServlet` and called
1. `Controller` is the entry-point for an event in and out of the rest of the program
1. `Controller` returns a `View` name & `Model` to the `DispatcherServlet`
1. `DispatcherServlet` consults `ViewResolver` to interpret `View` name as a template file and weave the `Model` into the response body
1. Response sent to client


## DispatcherServlet
Spring MVC's front controller has its own WebApplicationContext, allowing it to handle more bean scopes than singleton and prototype. It manages Controllers, HandlerMapping, ViewResolver, and all other components.

## HandlerMapping
While configurable using `RequestMappingHandlerMapping` objects, it can be simply enabled using a `<mvc:@annotation-driven/>` element tag in configuration, allowing for component scanning to automatically register all @Controller and similar beans along with their mappings. It is responsible for routing requests to specific methods within these controllers.

## Controllers
A `@Controller` stereotype annotation registers a class as a library of methods mapped to URI paths to handle requests. Several related annotations help to further specify these requests and their expected responses.

- `@RequestMapping` specifies the URI with attributes like value for the path and method for the HTTP verb, and can be defined at the class or method level.
- `@GetMapping` is a shorthand form of a `@RequestMapping` with GET assumed as its method. Also has siblings in `@PostMapping` and similar annotations.
- `@RequestParam` can be used on method parameters to bind form or query attributes to arguments.
- `@PathVariable` can be used on method parameters to bind URI path variables to arguments.
- `@ResponseBody` tags a method (or all methods of a class) to write their return objects directly to the response body, skipping the ViewResolver entirely.

## ViewResolver
ViewResolvers handle server-side view resolution for static HTML/CSS/JS files, or rendering for dynamic templates like JSPs or Thymeleaf files. 
