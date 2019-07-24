# JDBC API
Java Database Connectivity (JDBC) is an API for connecting to a RDBMS such as Oracle, PostgreSQL, or MySQL. As a collection of classes and interfaces it requires a driver from the database vendor on the classpath. Once added, a `java.sql.DriverManager` will register the driver and act as a factory for a `java.sql.Connection`, used to create and send SQL queries with `java.sql.Statement`, `java.sql.PreparedStatement`, or `java.sql.CallableStatement` objects, and retrieve result sets in `java.sql.ResultSet` objects.

You can load a JDBC driver using `Class.forName()` or `DriverManager.registerDriver()`, or let DriverManager automatically detect the driver on the classpath.

```java
// Loading the driver may not be necessary, but it's good to specify
try {
    Class.forName("org.postgresql.Driver");
} catch (java.lang.ClassNotFoundException e) {
    System.out.println(e.getMessage());
}

// Pay attention to the url pattern
String url = "jdbc:postgresql://host:port/database";
String username = "databaseuser"
String password = "password"

try (
    // Be sure to close all connections after use
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();
){
    // executeUpdate() returns the number of rows affected for DML
    int rowCount = statement.executeUpdate("insert into pizza values (1, 'cheese')");

    // executeQuery() returns a ResultSet object for queries
    ResultSet pizzas = statement.executeQuery("select * from pizza");

    // Loop through ResultSet for each row returned
    while(pizzas.next()) {
        System.out.println(pizzas.getInt("id"));
        System.out.println(pizzas.getString("flavor"));
    }

} catch (SQLException ex) {
    
} 
```

## Statement
A Statement object sends queries and updates, as well as receive errors or ResultSets.

**Statement** is prone to SQL Injection attacks, especially if you use a raw string to write the query.

**PreparedStatement** is a precompiled SQL statement. It is best used for writing several similar queries in a loop, but will also as a side effect protect against SQL Injections
```java
PreparedStatement ps = myConnection.prepareStatement("UPDATE ANIMALS SET name=? WHERE id=?");
ps.setString(1, "Hippo");
ps.setInt(2, 7);
ps.executeQuery();
```
**CallableStatement** execute stored procedures and can return 1 or many ResultSets.
```java
CallableStatement cs = myConnection.prepareCall("{CALL BIRTHDAY_SP(?, ?)}");
cs.setInt(1, aid);
cs.setInt(2, yta);
cs.execute();
```

# Transaction Management
The connection objecct will automatically commit every statement to the database, which may not be ideal for batch insertions. To open a transaction, call `connection.setAutocommit(false)` and end the transaction afterwards with `connection.commit()`, then set `connection.setAutocommit(true)` if needed. Use the `rollback()` method if exceptions are thrown during the transaction.