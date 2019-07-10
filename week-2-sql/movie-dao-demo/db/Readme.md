# Build Postgres moviedb
Change directory into /db and run:
>docker build -t moviedb .

Then run a container:
>docker run -d -p 5432:5432 moviedb