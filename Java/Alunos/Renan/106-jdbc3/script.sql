

VEICULO

placa, modelo, fabricante, ano


create database devcourse;
use devcourse;

CREATE TABLE IF NOT EXISTS `veiculo` (	`id` int(10) NOT NULL auto_increment,	`placa` varchar(255),	`modelo` varchar(255),	`fabricante` varchar(255),	`ano` integer(4),	PRIMARY KEY( `id` ));