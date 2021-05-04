CREATE TABLE accident (
    id serial primary key,
    name varchar(50),
    text varchar(2000),
    address varchar(50),
    accidentType int references accidentType(id),
);
CREATE TABLE accidentType (
    id serial primary key,
    name varchar(50),
);
CREATE TABLE rule (
    id serial primary key,
    name varchar(50),
);
CREATE TABLE accident_rule (
    accident_id int,
    rule_id int,
);