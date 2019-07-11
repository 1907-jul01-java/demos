drop view get_movies;
drop table if exists actors, movies, directors;
drop sequence if exists actors_id_seq;

create table directors (
  id serial primary key,
  name text not null
);

create table movies (
  id serial primary key,
  title text not null,
  year integer not null check (year > 1950),
  director integer references directors(id) on delete cascade
);

create sequence actors_id_seq increment 3 minvalue 15 maxvalue 2000000 start 50;

create table actors (
  id integer default nextval('actors_id_seq'::regclass) not null,
  name text not null,
  contract_fee numeric(10, 2),
  constraint pk_actors primary key (id)
);

insert into directors(name) values ('Steven Spielberg');
insert into directors(name) values ('Quentin Tarantino');
insert into movies(title, year, director) values ('Jurassic Park', 1993, 1);
insert into movies(title, year, director) values ('E.T.', 1982, 1);
insert into movies(title, year, director) values ('Kill Bill', 2003, 2);
insert into actors(name) values ('Keanu Reeves');
insert into actors values (20, 'Brad Pitt', 50.25);
insert into actors(name) values ('Kevin Bacon');

-- Aggregate function
-- select avg(year) from movies;

-- Scalar function
-- select upper(title) from movies;

-- select * from get_movies;
create or replace view get_movies as select * from movies;

-- select get_time();
create or replace function get_time() returns time with time zone as
$$
  select current_time;
$$ Language sql;

-- select get_actor_id('Keanu Reeves');
create or replace function get_actor_id(actor_name text) returns integer as
$$
  select id from actors where name = actor_name;
$$ language sql;