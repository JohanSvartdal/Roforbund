

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

create table if not EXISTS roforbund.klasser
(
    Klasse_id   INT UNSIGNED auto_increment,
    Klasse_navn varchar(50),
    Min_alder   INT(3) UNSIGNED,
    Max_alder   INT(3) UNSIGNED,


    CONSTRAINT Klasse_id PRIMARY KEY (Klasse_id)
);

create table if not EXISTS roforbund.adresser
(
    Adresse_id       varchar(100) not null,
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
    Adresse_id      varchar(100),
    Tlf             int(8) UNSIGNED,
    Deaktivert      boolean,
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
    Klubb_id        INT UNSIGNED,
    Trener_id       INT UNSIGNED,
    Godkjent        int(1) UNSIGNED NOT NULL,
    Antall_ovelser  int(3) UNSIGNED NOT NULL,
    Kommentar       varchar(800),
    CONSTRAINT Test_id PRIMARY KEY (Test_id),
    FOREIGN KEY (Klubb_id) REFERENCES klubber(Klubb_id),
    FOREIGN KEY (Trener_id) REFERENCES bruker(Bruker_id)
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



create table if not EXISTS roforbund.klasser
(
    Klasse_id        varchar(100) NOT NULL,
    Klasse_navn      varchar(100) NOT NULL,
    alder_min        int(3) UNSIGNED,
    alder_max        int(3) UNSIGNED,
    CONSTRAINT Klasse_id PRIMARY KEY (Klasse_id)
);

insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('JuniorG15', 10, 15);

insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('JuniorJ15', 10, 15);

insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('JuniorG19', 16, 19);

insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('JuniorJ19', 16, 19);

insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('SeniorG25', 20, 25);

insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('SeniorJ25', 20, 25);

Insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('SeniorG30', 26, 30);

insert into roforbund.klasser (Klasse_navn, Min_alder, Max_alder)
values ('SeniorJ30', 26, 30);



insert into roforbund.postnummere (Postnummer, Poststed)
values (3015, 'Drammen');

insert into roforbund.postnummere (Postnummer, Poststed)
values (4624, 'Kristiansand');

insert into roforbund.postnummere (Postnummer, Poststed)
values (4754, 'Bykle');

insert into roforbund.postnummere (Postnummer, Poststed)
values (3057, 'Solbergelva');

insert into roforbund.postnummere (Postnummer, Poststed)
values (4568, 'Hovden');

insert into roforbund.postnummere (Postnummer, Poststed)
values (4677, 'Stavanger');

insert into roforbund.postnummere (Postnummer, Poststed)
values (7932, 'Volda');

insert into roforbund.postnummere (Postnummer, Poststed)
values (1101, 'Oslo');

insert into roforbund.postnummere (Postnummer, Poststed)
values (2264, 'Lillesand');

insert into roforbund.postnummere (Postnummer, Poststed)
values (6709, 'Kongsberg');

insert into roforbund.postnummere (Postnummer, Poststed)
values (5376, 'Sogndal');


insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('3015cappelensgate61', 'Cappelens Gate', 61, 3015);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('3015bragernestorg4', 'Bragernes Torg', 4, 3015);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('4624marikåpeveien10', 'Marikåpeveien', 10, 4624);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('4624tollbodgata20', 'Tollbodgata', 20, 4624);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('3015rosengransgate112', 'Rosenkransgate', 112, 3015);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('4624kongensgate65', 'Kongensgate', 65, 4624);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('4624haugenstuegata22', 'Haugenstuegata', 22, 4624);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('3057hallingstadveien13', 'Hallingstadveien', 13, 3057);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('4568hovdenveien46', 'Hovdenveien', 46, 4568);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('4677jareveien55', 'Jareveien', 55, 4677);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('7932tregata39', 'Tregata', 39, 7932);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('1101bolstadveien48', 'Bolstadveien', 48, 1101);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('2264senterveien81', 'Senterveien', 81, 2264);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('6709kongeveien13', 'Kongeveien', 13, 6709);

insert into roforbund.adresser (Adresse_id, Gatenavn, Husnummer, Postnummer)
values ('5376fjellgata24', 'Fjellgata', 24, 5376);


insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Drammen Roklubb', '3015bragernestorg4', 40640382);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Kristiansand Roklubb', '4624tollbodgata20', 93064217);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Arendal roklubb', '3057hallingstadveien13', 99223991);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Hovden roklubb', '4568hovdenveien46', 34675899);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Stavanger roklubb', '4677jareveien55', 40936082);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Volda roklubb', '7932tregata39', 96852273);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Oslo roklubb', '1101bolstadveien48', 45732289);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Lillesand roklubb', '2264senterveien81', 84576233);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Kongsberg roklubb', '6709kongeveien13', 91287654);

insert into roforbund.klubber (Navn, Adresse_id, Tlf)
values ('Sogndal roklubb', '5376fjellgata24', 91283345);


insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Johan', 'Svartdal', '2000-10-02', 46968676, 'Johan.svartdal30@gmail.com', 'root', '3015cappelensgate61', 1, 1, 1, 75, 181);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Gordon', 'Ramsey', '1966-10-02', 93724120, 'gordon.ramsey@kitchen.com', 'root', '3015rosengransgate112', 1, 2, null, 90, 188);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Mari', 'Tveiten', '1999-10-17', 92678341, 'mari@hotmail.com', 'root', '4624kongensgate65', 2, 1, 3, 60.8, 174);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Hermann', 'Flesvig', '1992-03-18', 43762182, 'Hermann.flesvig@gmail.com', 'root', '4624haugenstuegata22', 2, 2, null, 80, 183);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Oscar', 'Riise', '2000-09-19', 99226981, 'riisep00@gmail.com', 'root', '3057hallingstadveien13', 1, 1, 2, 68, 179);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Superbruker', null, null, 98261732, 'superbruker@roing.no', 'root', null, null, 3, null, null, null);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Per', 'Hansen', '1989-02-13', 99576324, 'Per.Hansen@hotmail.com', 'root', '4568hovdenveien46', 5, 1, 2, 83, 185);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Lise', 'Pedersen', '1994-10-03', 98922672, 'Lise.Pedersen@gmail.com', 'root', '4677jareveien55', 6, 2, null, 65, 176);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Stine', 'Larsen', '1997-01-22', 95825673, 'Stine.Larsen@gmail.com', 'root', '7932tregata39', 7, 1, 3, 68, 178);

insert into roforbund.bruker (Fornavn, Etternavn, Fodseldato, Tlf, Epost, Passord, Adresse_id, Klubb_id, Rolle, Ranking, Vekt, Hoyde)
values ('Petter', 'Holen', '1998-11-06', 95885933, 'Petter.Holen@outlook.no', 'root', '1101bolstadveien48', 8, 1, 3, 72, 182);

insert into roforbund.ovelser (Navn)
values ('5000m løp');

insert into roforbund.ovelser (Navn)
values ('3000m');

insert into roforbund.ovelser (Navn)
values ('1000m roing');

insert into roforbund.ovelser (Navn)
values ('3000m løp');

insert into roforbund.ovelser (Navn)
values ('2000m løp');

insert into roforbund.ovelser (Navn)
values ('1000m løp');

insert into roforbund.ovelser (Navn)
values ('Knebøy');

insert into roforbund.ovelser (Navn)
values ('Liggende rotak');

insert into roforbund.ovelser (Navn)
values ('Planken');

insert into roforbund.ovelser (Navn)
values ('Utfall');

insert into roforbund.ovelser (Navn)
values ('Armhevinger');

insert into roforbund.ovelser (Navn)
values ('Kroppshev');

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (1, 2, 1, 2);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (1, 2, 2, 3);



insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (1, 2, 1, 2);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (1, 2, 2, 3);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (6, 9, 2, 2);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (2, 4, 4, 5);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (6, 8, 2, 3);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (1, 2, 6, 8);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (1, 2, 2, 3);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (6, 8, 5, 10);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (2, 4, 3, 4);

insert into roforbund.tester (Klubb_id, Trener_id, Godkjent, Antall_ovelser)
values (2, 4, 5, 5);




insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (1, 1, 1, 983, 2000, 10, 1);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (3, 1, 1, 202, 1800, 70, 3);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (2, 3, 3, 100, 1900, 80, 2);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (3, 4, 3, 270, 2100, 40, 1);



insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid)
values (3, 2, 1, 90);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid)
values (3, 2, 5, 35);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, Repetisjoner)
values (2, 2, 1, 420, 2100, 2);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, Repetisjoner)
values (2, 2, 5, 780, 1600, 2);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (1, 2, 1, 960, 2050, 5, 1);

insert into roforbund.resultater (Ovelse_id, Test_id, Bruker_id, Tid, Watt, KG, Repetisjoner)
values (1, 2, 5, 1140, 1310, 5, 1);