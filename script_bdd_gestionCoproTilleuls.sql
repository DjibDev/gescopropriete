CREATE DATABASE gestion_coproTilleuls DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE gestion_coproTilleuls;

DROP TABLE RESIDENTS_APPARTEMENTS;
DROP TABLE APPARTEMENTS;
DROP TABLE BATIMENTS;
DROP TABLE EVENEMENTS;
DROP TABLE MESSAGES;
DROP TABLE BILLETS;
DROP TABLE CATEGORIES;
DROP TABLE AGENDAS;
DROP TABLE RESIDENTS;
DROP TABLE ROLES;
DROP TABLE USERS_TEMP;

CREATE TABLE BATIMENTS ( 
	code VARCHAR(3) NOT NULL PRIMARY KEY,
    adresse VARCHAR(50) NOT NULL
);

CREATE TABLE APPARTEMENTS ( 
	num INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	num_syndic VARCHAR(5) NULL,
	porte INT(2) NULL,
    etage INT(2) NOT NULL, 
	batiment VARCHAR(3) NOT NULL,
	CONSTRAINT fk_appartements_batiments FOREIGN KEY (batiment) REFERENCES BATIMENTS(code)
);

CREATE TABLE ROLES ( 
	id VARCHAR(5) NOT NULL PRIMARY KEY,
    libelle VARCHAR(50) NOT NULL
);

	CREATE TABLE USERS_TEMP (
		id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
		champs1 VARCHAR(20) NOT NULL,
		champs2 VARCHAR(80) NOT NULL,
		used BIT DEFAULT 0
	);

CREATE TABLE RESIDENTS (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	tel VARCHAR(10) NULL,
	email VARCHAR(60) NULL,
	login VARCHAR(20) NOT NULL,
	mot_de_passe VARCHAR(80) NOT NULL,
	date_inscription DATETIME NOT NULL,
	type_res VARCHAR(50) DEFAULT "Propriétaire résident", 
	actif BIT DEFAULT 1,
	role VARCHAR(5) NOT NULL,
	CONSTRAINT fk_proprietaire_role FOREIGN KEY (role) REFERENCES ROLES(id)
);



CREATE TABLE RESIDENTS_APPARTEMENTS (	
	residents INT(11) NOT NULL,
	appartements INT(5) NOT NULL,
	CONSTRAINT pk_asso PRIMARY KEY (residents,appartements),
    CONSTRAINT fk_asso1 FOREIGN KEY (residents) REFERENCES RESIDENTS(id),
    CONSTRAINT fk_asso2 FOREIGN KEY (appartements) REFERENCES APPARTEMENTS(num)
);

CREATE TABLE CATEGORIES ( 
	id INT(2) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(50) NOT NULL
);

CREATE TABLE BILLETS ( 
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sujet VARCHAR(50) NOT NULL,
	date_creation DATETIME NOT NULL,
	categorie INT(2) NOT NULL,
	createur INT(11) NOT NULL,
	ouvert BIT DEFAULT 1,
	archive BIT DEFAULT 0,
	CONSTRAINT fk_billets_categories FOREIGN KEY (categorie) REFERENCES CATEGORIES(id),
	CONSTRAINT fk_billets_residents FOREIGN KEY (createur) REFERENCES RESIDENTS(id)
);

CREATE TABLE MESSAGES ( 
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sujet VARCHAR(50) NOT NULL,
	date_creation DATETIME NOT NULL,
	billet INT(2) NOT NULL,
	createur INT(11) NOT NULL,
	archive BIT DEFAULT 0,
	CONSTRAINT fk_messages_billets FOREIGN KEY (billet) REFERENCES BILLETS(id),
	CONSTRAINT fk_messages_residents FOREIGN KEY (createur) REFERENCES RESIDENTS(id)
);

CREATE TABLE AGENDAS ( 
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	libelle VARCHAR(50) NOT NULL,
    annee int(4) NOT NULL
);

CREATE TABLE EVENEMENTS ( 
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	date_event DATETIME NOT NULL,
	date_creation DATETIME NOT NULL,
	sujet VARCHAR(80) NOT NULL,
	details VARCHAR(250) NOT NULL,
	archive BIT DEFAULT 0,
	agenda INT(11) NOT NULL,
	createur INT(11) NOT NULL,
	CONSTRAINT fk_evenements_agendas FOREIGN KEY (agenda) REFERENCES AGENDAS(id),
	CONSTRAINT fk_evenements_residents FOREIGN KEY (createur) REFERENCES RESIDENTS(id)
);


/* INSERTS */
INSERT INTO BATIMENTS (code, adresse) VALUES 
("B1", "4 Allée des Tilleuls"),
("B2", "2 Allée des Tilleuls"),
("B3A", "55 Avenue de la Cholière"),
("B3B", "57 Avenue de la Cholière"),
("B3C", "59 Avenue de la Cholière"),
("B3D", "61 Avenue de la Cholière"),
("B3E", "63 Avenue de la Cholière");

INSERT INTO APPARTEMENTS (num_syndic, porte, etage, batiment) VALUES
(null, 2, 3, "B1"),(null, 4, 2, "B3D");

INSERT INTO ROLES (id, libelle) 
VALUES ("COPRO", "Co-propriétaire"),("ADMIN", "Administrateur"), ("COSYN", "Conseiller Syndical"),("GSACT","Gestionnaire d'Activités"), ("LOCAT","Locataire");


INSERT INTO RESIDENTS (nom, prenom, tel, email, login, mot_de_passe, date_inscription, type_res, actif, role) 
VALUES ("Durand", "Paul", "0101010101","pdurande@gmail.com" ,"jbl", "976bfa507a8aa45f4e440201a121ea32dea14ba0a2ef5c3f7339d824c47407ed", NOW(), "Propriétaire résident" , true, "COPRO");

INSERT INTO RESIDENTS (nom, prenom, tel, email, login, mot_de_passe, date_inscription, type_res, actif, role) 
VALUES ("Admin", "Test", "0637066255","test@gmail.com" ,"test", "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", NOW(), "Propriétaire non-résident" , true, "ADMIN");

INSERT INTO RESIDENTS (nom, prenom, tel, email, login, mot_de_passe, date_inscription, type_res, actif, role) 
VALUES ("Martin", "Luc", "0102030405","test2@gmail.com" ,"test2", "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", NOW(), "Locataire" ,false, "LOCAT");

INSERT INTO RESIDENTS_APPARTEMENTS (residents, appartements) VALUES (1,1),(2,1),(3,2);

INSERT INTO AGENDAS (libelle ,annee) VALUES ("Composteur", 2017),("Activités des enfants", 2017), ("Reservation des salles", 2017);












