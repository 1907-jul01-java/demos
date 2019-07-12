# Maven 
Opinionated project management tool for build automation, dependency management, and other actions. Once installed, use with the `mvn` command. Allows for a project to be IDE agnostic. See the official Maven project for documentation: http://maven.apache.org/index.html as well as the mvn repository to find available libraries: https://mvnrepository.com/

The minimum `pom.xml` example:
```xml
<project>
	<modelVersion>4.0.0</modelVersion>
	<groupId>YourDomainName</groupId>
	<artifactId>YourProjectName</artifactId>
	<version>0.1.0</version>
</project>
```

## Example commands
Create a new Maven project with the quickstart archetype. Change groupId and artifactId arguments as needed:
>mvn archetype:generate

Or skip the setup and run the generator in one line:
>mvn archetype:generate -DgroupId=com.revature -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Compile class files into target/classes
>mvn compile

Package project into a jar file in target
>mvn package

Remove target folder and compiled build
>mvn clean

## Build Lifecycle
Maven builds step through a series of phases sequentially:
- **validate** - validate the project is correct and all necessary information is available
- **compile** - compile the source code of the project
- **test** - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
- **package** - take the compiled code and package it in its distributable format, such as a JAR.
- **verify** - run any checks on results of integration tests to ensure quality criteria are met
- **install** - install the package into the local repository, for use as a dependency in other projects locally
- **deploy** - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

For example, running `mvn package` will first run validate, compile, and test.

## Dependency Management
Maven can not only manage imported libraries, but resolve transitive dependencies required for each. Simply including a dependency will be enough for Maven to search for all other required dependencies.

To include a dependency, search on [Maven Repository](https://mvnrepository.com/) for its groupId, artifactId, and version. Inlude these tags in a `<dependency></dependency>` element within a `<dependencies></dependencies>` block.

```xml
<project>

...

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
</project>
```

A scope element can specify the lifecycle goal the dependency will be limited to.

## Plugin Management
Maven plugins are a collection of goals, work units that accomplish an automated task. A basic Maven project will automatically include a number of plugins including the compiler plugin which can set the source and target value of the JDK version to use when compiling, and the surefire plugin which will automatically run JUnit tests found on the classpath.

These plugins can be configured within the `pom.xml`, and extra plugins can be added to introduce new automation tasks. For example:

### Maven Execution Plugin
To simplify the execution of a Java application, the exec plugin can be configured as follows:
```xml
<project>
...

<build>
  <plugins>
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>exec-maven-plugin</artifactId>
      <configuration>
        <mainClass>com.revature.App</mainClass>
        <commandlineArgs>Mike</commandlineArgs>
      </configuration>
    </plugin>
  </plugins>
</build>

...
</project>
```
And then the following command will run the plugin:
>mvn exec:java

Alternatively, the configuration element block can be removed while still using the plugin, or its arguments overwritten, with the following command:
>mvn exec:java -Dexec.mainClass="com.revature.App" -Dexec.args="Mike"

Even better, simply add this one properties tag:
```xml
<properties>
	...
	<exec.mainClass>your.main.App</exec.mainClass>
</properties>
```

And the `mvn exec:java` command will run your program without any further plugin configuration.