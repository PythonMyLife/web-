create database if not exists ebook;
use ebook;
CREATE TABLE IF NOT EXISTS user (
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    `status` VARCHAR(1) NOT NULL,
    `email` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`username`)
)  DEFAULT CHARSET=UTF8MB4;

CREATE TABLE IF NOT EXISTS manager (
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`username`)
)  DEFAULT CHARSET=UTF8MB4;

CREATE TABLE IF NOT EXISTS book (
    `bookname` VARCHAR(30) NOT NULL,
    `auther` VARCHAR(100) NOT NULL,
    `cover` LONGBLOB NOT NULL,
    `ISBN` VARCHAR(13) NOT NULL,
    `booknumber` INT NOT NULL,
    `price` DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (`ISBN`)
)  DEFAULT CHARSET=UTF8MB4;

CREATE TABLE IF NOT EXISTS bookorder (
    `ISBN` VARCHAR(13) NOT NULL,
    `time` DATETIME NOT NULL,
    `number` INT NOT NULL,
    `username` VARCHAR(30) NOT NULL,
    `ID` INT NOT NULL,
    PRIMARY KEY (`username`)
)  DEFAULT CHARSET=UTF8MB4;
