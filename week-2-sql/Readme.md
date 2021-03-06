# Week 2 SQL Topics
- Tools
    - PostgreSQL
    - Database administration
        - CLI, Client tool, IDE plugin
    - AWS RDS
    - Docker

- RDBMS: Relational Database Management System
    - Domain integrity
    - Referential integrity
    - ERD: Entity Relational Diagram
    - Multiplicity: 1:1, 1:many, many:many, join tables
    - Normalization
        - 1NF: No repeating attributes, Atomic values
        - 2NF: Partial key dependencies
        - 3NF: Non-key dependencies
    - ACID transactions: Atomic, Consistent, Isolated, Durable
    - Transaction phenomenon: Dirty reads, Nonrepeatable reads, Phantoms
    - Transaction isolation levels
        - Read uncommitted
        - Read committed
        - Repeatable Read
        - Serialization
        
- JDBC: Java Database Connectivity
    - DriverClass, Connection
    - Statement, PreparedStatement, Callable Statement
    - ResultSet
    - Design Pattern: Data Access Object
    - Datasource: Properties, Environment Variables, JDBC URL

- SQL: Structured Query Language
    - Dialects, Vendors, Sublanguages
    - Keys: Candidate, Primary, Composite, Foreign
    - DCL: Data Control Language
        - Grant, Revoke
    - DDL: Data Definition Language
        - Create, Alter, Drop, Truncate
    - DML: Data Manipulation Language
        - Select, Insert, Update, Delete
    - TCL: Transaction Control Language
        - Commit, Rollback, Savepoint
    - Select clauses
        - Alias, And, Or
        - Subqueries
        - Joins, Unions
        - Group By, Order By

- PL/pgSQL
    - Function: Scalar, Aggregate
    - Index
    - View
    - Sequence
    - Trigger
    - Stored Procedure
