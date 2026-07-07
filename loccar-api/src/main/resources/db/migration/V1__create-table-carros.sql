create table Carros(

    id bigint not null auto_increment,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano int not null ,
    placa varchar(7) not null unique,
    ativo boolean not null,

    primary key(id)

);