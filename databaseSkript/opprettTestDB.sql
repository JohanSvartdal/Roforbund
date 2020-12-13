CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS test.postnummere
(
    Postnummer       int UNSIGNED auto_increment,
    Poststed         varchar(45),
    CONSTRAINT Postnummer PRIMARY KEY (Postnummer)
);

CREATE TABLE IF NOT EXISTS test.klasser
(
    Klasse_id   INT UNSIGNED auto_increment,
    Klasse_navn varchar(50),
    Min_alder   INT(3) UNSIGNED,
    Max_alder   INT(3) UNSIGNED,


    CONSTRAINT Klasse_id PRIMARY KEY (Klasse_id)
);

CREATE TABLE IF NOT EXISTS test.adresser
(
    Adresse_id       varchar(100) not null,
    Gatenavn         varchar(45),
    Husnummer        varchar(5),
    Postnummer       int(4) UNSIGNED,
    CONSTRAINT Adresse_id PRIMARY KEY (Adresse_id),
    FOREIGN KEY (Postnummer) REFERENCES postnummere(Postnummer)
);

CREATE TABLE IF NOT EXISTS test.klubber
(
    Klubb_id        int UNSIGNED auto_increment,
    Navn            varchar(60),
    Adresse_id      varchar(100),
    Tlf             int(8) UNSIGNED,
    Deaktivert      boolean,
    CONSTRAINT Klubb_id PRIMARY KEY (Klubb_id),
    FOREIGN KEY (Adresse_id) REFERENCES adresser(Adresse_id)
);

CREATE TABLE IF NOT EXISTS test.bruker
(
    Bruker_id       int UNSIGNED auto_increment,
    Fornavn         varchar(60),
    Etternavn       varchar(60),
    Fodseldato      DATE,
    Tlf             int(8) UNSIGNED,
    Epost           varchar(60),
    Passord         varchar(60) NOT NULL,
    Adresse_id      varchar(100),
    Klubb_id        int(5) UNSIGNED,
    Rolle           int(1) UNSIGNED,
    Ranking         int(10) UNSIGNED,
    Vekt            float(5) UNSIGNED,
    Hoyde           int(3) UNSIGNED,
    Klasse_id       int(5) UNSIGNED,
    Deaktivert      boolean,
    CONSTRAINT Bruker_id PRIMARY KEY (Bruker_id),
    FOREIGN KEY (Klasse_id) REFERENCES klasser(Klasse_id),
    FOREIGN KEY (Adresse_id) REFERENCES adresser(Adresse_id),
    FOREIGN KEY (Klubb_id) REFERENCES klubber(Klubb_id)
);

CREATE TABLE IF NOT EXISTS test.ovelser
(
    Ovelse_id        int UNSIGNED auto_increment,
    Navn             varchar(60) NOT NULL,
    CONSTRAINT Ovelse_id PRIMARY KEY (Ovelse_id)
);

CREATE TABLE IF NOT EXISTS test.tester
(
    Test_id         int UNSIGNED auto_increment,
    Dato            TIMESTAMP,
    Klubb_id        INT UNSIGNED,
    Trener_id       INT UNSIGNED,
    Godkjent        int(1) UNSIGNED NOT NULL,
    Antall_ovelser  int(3) UNSIGNED NOT NULL,
    Kommentar       varchar(800),
    CONSTRAINT Test_id PRIMARY KEY (Test_id),
    FOREIGN KEY (Klubb_id) REFERENCES klubber(Klubb_id),
    FOREIGN KEY (Trener_id) REFERENCES bruker(Bruker_id)
);

CREATE TABLE IF NOT EXISTS test.resultater
(
    Resultat_id      int UNSIGNED auto_increment,
    Ovelse_id        int UNSIGNED,
    Test_id          int UNSIGNED,
    Bruker_id        int UNSIGNED,
    Tid              int(5) UNSIGNED,
    Watt             int(4) UNSIGNED,
    KG               int(3) UNSIGNED,
    Repetisjoner     int(3) UNSIGNED,
    CONSTRAINT Resultat_id PRIMARY KEY (Resultat_id),
    FOREIGN KEY (Ovelse_id) REFERENCES ovelser(Ovelse_id),
    FOREIGN KEY (Test_id) REFERENCES tester(Test_id),
    FOREIGN KEY (Bruker_id) REFERENCES bruker(Bruker_id)
);



CREATE TABLE IF NOT EXISTS test.klasser
(
    Klasse_id        varchar(100) NOT NULL,
    Klasse_navn      varchar(100) NOT NULL,
    alder_min        int(3) UNSIGNED,
    alder_max        int(3) UNSIGNED,
    CONSTRAINT Klasse_id PRIMARY KEY (Klasse_id)
);