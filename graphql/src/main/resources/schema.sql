create table product (
    id bigint auto_increment primary key,
    name varchar(1000) not null,
    quantity int not null,
    price int not null
);

create table user (
    id bigint auto_increment primary key,
    name varchar(100) not null,
    age tinyint not null
);