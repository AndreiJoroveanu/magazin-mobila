create table t_birou(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    height integer,
    length integer,
    width integer,
    price integer,
    primary key(id)
);

create table t_scaun(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    max_weight integer,
    height integer,
    length integer,
    width integer,
    price integer,
    primary key(id)
);

create table t_biblioteca(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    height integer,
    length integer,
    width integer,
    price integer,
    primary key(id)
);

create table t_raft(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    height integer,
    length integer,
    width integer,
    price integer,
    primary key(id)
);

create table t_comoda(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    height integer,
    length integer,
    width integer,
    price integer,
    primary key(id)
);