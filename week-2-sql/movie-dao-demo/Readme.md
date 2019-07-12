# Build Postgres moviedb
Change directory into /db and run:
>docker build -t moviedb .

Then run a container:
>docker run -d -p 5432:5432 moviedb

# Compile, Package, & Execute with Maven
To compile and execute, run:
```
mvn compile
mvn exec:java
```

To package an executable jar and execute, run:
```
mvn clean package
java -jar target/movie-dao-demo.jar
```