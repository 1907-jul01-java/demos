# Development Environment, Tools, & Resources
## Getting Started
To maximize resources and minimize troubleshooting, perform a clean install or refresh of your operating system. Update your system, [Enable VT-x in BIOS](https://www.wikihow.tech/Enable-VT%E2%80%90x-in-BIOS) if possible, and uninstall all unnecessary programs. 

## Tools
### Package Managers
* [Chocolatey for Windows](https://chocolatey.org)
* [Scoop for Windows](https://scoop.sh/)

### JDK 8 Options
* [Oracle JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
* [AdoptOpenJDK](https://adoptopenjdk.net/)

### Command-line tools
* [Git](https://git-scm.com)
* [Apache Maven](https://maven.apache.org/)

### Editors
* [Visual Studio Code](https://code.visualstudio.com/)
* [Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/release/2019-06/r/eclipse-ide-enterprise-java-developers)
* [Spring Tool Suite](https://spring.io/tools3/sts/all) 

## Installing Java, Maven, and STS with Chocolatey
1) Install [Chocolatey](https://chocolatey.org)
     1) Open `Powershell` as an administrator.
     2) Run:
         >Set-ExecutionPolicy AllSigned
     3) Agree to all changes
     4) Run:
         >Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
2) Open a new `Powershell` window as an administrator and run the following commands:
3) To install [Git for Windows](https://git-scm.com):
    >choco install git
4) To install [Oracle JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html):
    >choco install jdk8
    
    Alternatively, use `choco install` and an OpenJDK distribution of your choosing:
    ```bash
    choco install adoptopenjdk8
    choco install zulu8
    choco install corretto8jdk
    ```
5) To install [Apache Maven](https://maven.apache.org/):
    >choco install maven

    If using an OpenJDK distribution of Java, you should install Maven with the following command to avoid accidentally installing OracleJDK:
    >choco install maven --ignore-dependencies
6) To install [Spring Tool Suite](https://spring.io/tools3/sts/all):
    >choco install springtoolsuite

    Alternatively, install Eclipse for Enterprise Java Developers:
    >choco install eclipse

### Summary
To confirm all tools are properly installed and configured, be sure the following commands return no errors:
```bash
git -v
java -version
javac -version
mvn -v
```

`java` and `javac` should only reference Java 8.

You should pin the shortcut to STS. All above tools can be installed at once for convenience using the following command:
>choco install -y git jdk8 maven springtoolsuite

## Useful Resources
### Git
* [Git Documentation](https://git-scm.com/doc)
* [GitHub - Resources to Learn Git](http://try.github.io/)
* [Gitignore.io - .gitignore generator](https://www.gitignore.io/)

### Java SE 8
* [Java SE 8 Documentation](https://docs.oracle.com/javase/8/docs/)
* [Java SE 8 Specification](https://docs.oracle.com/javase/specs/jls/se8/html/)
* [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
* [Think Java Textbook](https://books.trinket.io/thinkjava/index.html)

### Maven
* [Maven - Getting Started](http://maven.apache.org/guides/getting-started/index.html)
* [Maven by Example](https://books.sonatype.com/mvnex-book/reference/index.html)