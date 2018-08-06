script veiculo

create table veiculo (
  placa varchar(10) not null primary key,
  modelo varchar(20) not null,
  fabricante varchar(20) not null,
  ano integer not null
);

