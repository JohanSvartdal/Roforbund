

# Her lages databasen (denne kommandoen må kjøres manuelt)
CREATE DATABASE if not EXISTS roforbund;


# Her velges databasen som nettop ble opprettet
USE roforbund;

create table if not EXISTS roforbund.postnummere
(
    Postnummer       int UNSIGNED auto_increment,
    Poststed         varchar(45),
    CONSTRAINT Postnummer PRIMARY KEY (Postnummer)
);

create table if not EXISTS roforbund.adresser
(
    Adresse_id       int UNSIGNED auto_increment,
    Gatenavn         varchar(45),
    Husnummer        varchar(5),
    Postnummer       int(4) UNSIGNED,
    CONSTRAINT Adresse_id PRIMARY KEY (Adresse_id),
    FOREIGN KEY (Postnummer) REFERENCES postnummere(Postnummer)
);

create table if not EXISTS roforbund.klubber
(
    Klubb_id        int UNSIGNED auto_increment,
    Navn            varchar(60),
    Adresse_id      int UNSIGNED,
    Tlf             int(8) UNSIGNED,
    CONSTRAINT Klubb_id PRIMARY KEY (Klubb_id),
    FOREIGN KEY (Adresse_id) REFERENCES adresser(Adresse_id)
);

create table if not EXISTS roforbund.bruker
(
    Bruker_id       int UNSIGNED auto_increment,
    Fornavn         varchar(60),
    Etternavn       varchar(60),
    Fodseldato      DATE,
    Tlf             int(8) UNSIGNED,
    Epost           varchar(60),
    Passord         varchar(60) NOT NULL,
    Adresse_id      int(7) UNSIGNED,
    Klubb_id        int(5) UNSIGNED,
    Rolle           int(1) UNSIGNED,
    Ranking         int(10) UNSIGNED,
    Vekt            float(5) UNSIGNED,
    Hoyde           int(3) UNSIGNED,
    CONSTRAINT Bruker_id PRIMARY KEY (Bruker_id),
    FOREIGN KEY (Adresse_id) REFERENCES adresser(Adresse_id),
    FOREIGN KEY (Klubb_id) REFERENCES klubber(Klubb_id)
);

create table if not EXISTS roforbund.ovelser
(
    Ovelse_id        int UNSIGNED auto_increment,
    Navn             varchar(60) NOT NULL,
    CONSTRAINT Ovelse_id PRIMARY KEY (Ovelse_id)
);

create table if not EXISTS roforbund.tester
(
    Test_id         int UNSIGNED auto_increment,
    Dato            TIMESTAMP,
    Trener_id       INT UNSIGNED,
    Klubb_id        INT UNSIGNED,
    Godkjent        int(1) UNSIGNED NOT NULL,
    CONSTRAINT Test_id PRIMARY KEY (Test_id),
    FOREIGN KEY (Klubb_id) REFERENCES klubber(Klubb_id)
);

create table if not EXISTS roforbund.resultater
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

insert into roforbund.postnummere (Postnummer, Poststed)
values (3015, 'Drammen');

insert into roforbund.postnummere (Postnummer, Poststed)
values (4624, 'Kristiansand');

insert into roforbund.postnummere (Postnummer, Poststed)
values (4754, 'Bykle');

insert into roforbund.adresser (Gatenavn, Husnummer, Postnummer)
values ('Cappelens Gate', 61, 3015);

insert into roforbund.adresser (Gatenavn, Husnummer, Postnummer)
values ('Bragernes Torg', 4, 3015);

insert into roforbund.adresser (Gatenavn, Husnummer, Postnummer)
values ('Marikåpeveien', 10, 4624);

insert into roforbund.adresser (Gatenavn, Husnummer, Postnummer)
values ('Tollbodgata', 20, 4624);

insert into roforbund.adresser (Gatenavn, Husnummer, Postnummer)
values ('Rosenkransgate', 112, 3015);

insert into roforbund.adresser (Gatenavn, Husnummer, Postnummer)
values ('Kongensgate', 65, 4624);

insert into roforbund.adresser (Gatenavn, Husnummer, Postnummer)
values ('Haugenstuegata', 22, 4624);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Drammen Roklubb', 2, 40640382);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Kristiansand Roklubb', 4, 93064217);



insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Johan', 'Svartdal', '2000-10-02', 46968676, 'Johan.svartdal30@gmail.com', 'root', 1, 1, 1, 1, 75, 181);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Gordon', 'Ramsey', '1966-10-02', 93724120, 'gordon.ramsey@kitchen.com', 'root', 5, 1, 2, null, 90, 188);



insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Mari', 'Tveiten', '1999-10-17', 92678341, 'mari@hotmail.com', 'root', 6, 2, 1, 3, 60.8, 174);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Hermann', 'Flesvig', '1992-03-18', 43762182, 'Hermann.flesvig@gmail.com', 'root', 7, 2, 2, null, 80, 183);



insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Superbruker', null, null, 98261732, 'superbruker@roing.no', 'root', null, null, 3, null, null, null);


insert into roforbund.ovelser (Navn)
values ('3000m');

insert into roforbund.ovelser (Navn)
values ('1000m roing');

insert into roforbund.ovelser (Navn)
values ('Planken');


insert into roforbund.tester (Trener_id, Godkjent)
values (2, 2);

insert into roforbund.tester (Trener_id, Godkjent)
values (2, 2);




insert into roforbund.tester (Trener_id, Godkjent)
values (4, 2);

insert into roforbund.tester (Trener_id, Godkjent)
values (4, 3);




insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (1, 1, 1, 983, 2000, 10, 1);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (3, 1, 1, 202, 1800, 70, 3);




insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (2, 3, 3, 100, 1900, 80, 2);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (3, 4, 3, 270, 2100, 40, 1);

SELECT * FROM postnummere;