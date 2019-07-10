drop table if exists movies;
drop table if exists directors;
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
insert into
  directors(name)
values
  ('Steven Spielberg');
insert into
  directors(name)
values
  ('Quentin Tarantino');
insert into
  movies(title, year, director)
values
  ('Jurassic Park', 1993, 1);
insert into
  movies(title, year, director)
values
  ('E.T.', 1982, 1);
insert into
  movies(title, year, director)
values
  ('Kill Bill', 2003, 2);