create database erdo;

-- root:

use erdo;

create table erdok(
    id int not null primary key auto_increment,
    nev varchar(50),
    tipus varchar(50),
    meret int,
    terulet varchar(50),
    orszag varchar(50),
    vedett_terulet boolean
);
