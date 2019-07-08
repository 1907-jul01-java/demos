# PostgreSQL

## Local install
- Chocolatey: `choco install postgresql`
- [Official Download](https://www.postgresql.org/download/)

## Cloud
### AWS
Create a free-tier RDS instance in the cloud on Amazon Web Services.
1. Sign up for an account on aws.amazon.com
2. Create an RDS ([tutorial](https://aws.amazon.com/getting-started/tutorials/create-connect-postgresql-db/))

### ElephantSQL/Heroku
Alternatively, use an alternative cloud service provider like [ElephantSQL](https://www.elephantsql.com/docs/index.html) or [Heroku](https://www.heroku.com/postgres).

## Docker
1. Start docker-machine with the Quickstart Terminal, Kitematic, or `docker-machine start` command.
2. In a terminal run:
    >docker run -p [port]:5432 postgres

    Where [port] is your choice of port. A common port is 5432, a default for many Postgres databases:
    >docker run -p 5432:5432 postgres

    To run a database as a background process, use the `-d` switch:
    >docker run -d -p 5432:5432 postgres

    It's a good idea to label a database with the `--name` switch:
    >docker run -d --name my_postgres -p 5432:5432 postgres

### Running PostgreSQL with Docker & Dockerfile
To create a custom postgres database, create a file named `Dockerfile`:
```Dockerfile
FROM postgres:10
ENV POSTGRES_USER hello-postgres
ENV POSTGRES_PASSWORD hello-postgres
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432
```

Set the username and password as needed, and include a `.sql` file in the same directory. Then to build:
>docker build -t demo-postgres .

Where `demo-postgres` is the name you wish to give this image. Then to run the build:
>docker run -p 5432:5432 -d demo-postgres