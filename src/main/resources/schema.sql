create table IF NOT EXISTS  restaurant(
  id integer not null AUTO_INCREMENT,
  name varchar(255),
  location varchar(255),
  primary key(id)
);

create table IF NOT EXISTS  food(
  id integer not null AUTO_INCREMENT,
  name varchar(255),
  price integer not null,
  primary key(id)
);

create table IF NOT EXISTS  Orders(
  id integer not null,
  quantity integer not null,
  food_id integer not null,
  unique (id,food_id)
);