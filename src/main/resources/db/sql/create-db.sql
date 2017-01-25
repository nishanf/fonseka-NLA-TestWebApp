--DROP TABLE users IF EXISTS;


CREATE TABLE Person (
  PersonId   INTEGER PRIMARY KEY,
  Email  VARCHAR(30),
  Name VARCHAR(30),
  Phone  VARCHAR(20)
);

CREATE TABLE Book (
  ISBN  VARCHAR(30) PRIMARY KEY,
  Title VARCHAR(200),
  Author  VARCHAR(60)
);

CREATE TABLE Burrowings (
  PersonId  INTEGER,
  ISBN  VARCHAR(30)
);