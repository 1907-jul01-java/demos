# SQL
## Terminology
**RDBMS** Relational Database Management System, relational referring to relational data (i.e. tables).

**Schema** Like packages/namespaces, groupings of tables expressing some database logical structure.

**SQL implementations** There is PostgreSQL is an Enterprise Database like Oracle, SQL Server, but there are others like MySQL/MariaSQL as well as non relational SQL databases (NoSQL).

**Candidate Key** A column that can uniquely identify a row (or entry) and thus is a potential candidate for a primary key.

**Composite Key** A primary key consisting of multiple columns.

**Primary Key** Unique (in that table), non-null candidate key.

**Foreign Key** A key that points to another primary key of a row (either in another table, or the same).

**Multiplicity** Refers to the relationship between linked tables. One-to-One (University, President), One-to-Many (University, Students), Many-to-Many (Students, Teachers). In 1:1, FKs will be within same table. 1:many, FKs will be in the other table. many:many, FKs will be in a junction/transition/join/lookup table.

**Referential Integrity** Enforcing data relationships, changes reflected between foreign keys. No orphans, all child rows must have their parent rows deleted as well.

**Domain Integrity** Column data is restricted to allowed range of allowed type.

**ERD** Entity-Relational Diagram

**Alias** The `AS` or `IS` keyword allows you to set a Table name or column name as a short variable.

**Normalization** Dividing data into separate tables to reduce redundancy and improve query speed

## Normal Forms
### Starting point (no normalization)
| SalesStaff |
| --- |
| EmployeeID |
| SalesPerson |
| SalesOffice |
| Age |
| DOB |
| Customer1 |
| Customer2 |
| Customer3 |

### 1st NF (Atomic values, No repeating Columns)
| SalesStaff |
| --- |
| EmployeeID |
| SalesPersonName |
| Age |
| DOB |
| SalesOfficeStreet |
| SalesOfficeCity |
| SalesOfficeState |
| SalesOfficeZip |

| Customer |
| --- |
| CustomerId |
| EmployeeId |
| CustomerName |

### 2nd NF (Remove Partial Dependencies)
| SalesStaff |
| --- |
| EmployeeID |
| SalesPersonName |
| Age |
| DOB |
| SalesOfficeID |

| SalesOffice |
| --- |
| SalesOfficeId |
| SalesOfficeStreet |
| SalesOfficeCity |
| SalesOfficeState |
| SalesOfficeZip |

| Customer |
| --- |
| CustomerId |
| EmployeeId |
| CustomerName |

### 3rd NF (Remove Transitive Dependencies)
| SalesStaff |
| --- |
| EmployeeID |
| SalesPersonName |
| DOB |
| SalesOfficeID |

| SalesOffice |
| --- |
| SalesOfficeId |
| SalesOfficeStreet |
| SalesOfficeZip |

| Customer |
| --- |
| CustomerId |
| EmployeeId |
| CustomerName |

## Sublanguages
**DCL** Data Control Language, setting user permissions (GRANT, REVOKE)

**DDL** Data Definition Language, working with database structure (CREATE, ALTER, TRUNCATE, DROP) EX:
```sql
CREATE TABLE (Schema)[TableName]
(Column definitions (Constraints))


ALTER TABLE [TableName]
ADD (Column) [Column definition]
ADD (Constraint clause)
DROP [column] [cascade]
DROP Constraint
ALTER COLUMN [definition]
```

**DML** Data Manipulation Language, working with the rows of data itself (INSERT, UPDATE, DELETE) EX:
```sql
INSERT INTO [TableName] [columns]
VALUES (data input)
SELECT (drop entire result set into table)
```

**DQL** Data Query Language, retrieving rows of data (SELECT). EX:
```sql
SELECT [columnList]
FROM [tableList]
WHERE [conditionList]
GROUP BY [columnList] // aggregate functions
HAVING [condition]  // aggregate functions
ORDER BY [columnList]
```

**TCL** Transaction Control Language, managing transactions (COMMIT, ROLLBACK, SAVEPOINT)
```sql
BEGIN;
SAVEPOINT this_point;
INSERT ...
INSERT ...
INSERT ... --Error here
ROLLBACK TO SAVEPOINT this_point; --Undo last 3 inserts
INSERT ...
COMMIT; --Only last insert will commit
```

## Joins
Combine rows from two tables based on some logical relationship between them (columns)
### Types
1. Inner Join, selects records with matching values from TableA and TableB
1. Left (Outer) Join, TableA primary, selects all records from A with matching values from B (non-matching values included as null)
1. Right (Outer) Join, TableB is primary, opposte of Left Join.
1. Cross Join, Cartesian join of two tables, if TableA has 5 rows, and TableB has 3 rows, the cross join will have 15 rows
1. Subquery is a query nested in the WHERE clause of a SELECT statement, in orde3r to further restrict the data returned. There are correlated and non-correlated. Correlated subqueries depend on the outer query to exist, meaning they cannot execute independently.

## Unions
1. UNION returns distinct rows present in either return set
1. UNION ALL returns all rows in both sets (including duplicates)
1. INTERSECT returns distinct rows present in both sets
1. MINUS returns all rows present in first set but not in second

## Functions
**Sequences** Generate numeric sequence, mostl for creating/managing primary keys.

**Views** Virtual table that displays the results of a SELECT statement, lets you reuse and store complex queries

**Indexes** Physical ordering of a column or group of columns, having unique indexes

**Aggregate Functions** (AVG, MIN, MAX, SUM, COUNT) perform an action on an entire column

**Scalar functions** (LOWER, UPPER) operate on individual entries

**Functions** Custom function with 0 or many input parameters, but 0 or 1 output. DML is not allowed.

**Stored Procedures** Custom function with 0 or many input parameters, but 0 or many output parameters. DML allowed.