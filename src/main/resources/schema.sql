create table t_magazin(
    id integer auto_increment,
    name varchar(50),
    primary key (id)
);

create table t_birou(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    price decimal(7, 1),
    id_store integer,
    primary key (id),
    foreign key (id_store) references t_magazin(id)
);

create table t_scaun(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    max_weight integer,
    price decimal(7, 1),
    id_store integer,
    primary key (id),
    foreign key (id_store) references t_magazin(id)
);

create table t_biblioteca(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    price decimal(7, 1),
    id_store integer,
    primary key (id),
    foreign key (id_store) references t_magazin(id)
 );

create table t_raft(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    price decimal(7, 1),
    id_store integer,
    primary key (id),
    foreign key (id_store) references t_magazin(id)
);

create table t_comoda(
    id integer auto_increment,
    category varchar(50),
    name varchar(50),
    color varchar(50),
    material varchar(50),
    price decimal(7, 1),
    id_store integer,
    primary key (id),
    foreign key (id_store) references t_magazin(id)
 );