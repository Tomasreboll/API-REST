
create table topicos(
id bigint not null auto_increment,
nombre varchar(100) not null,
mensaje varchar(200) not null unique,
fecha DATETIME not null,
status TINYINT(1) NOT NULL DEFAULT 0,
autor varchar(100) not null,
curso varchar(100) not null,

primary key(id)
);