
CREATE DATABASE DailyPlanetMartina
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_czech_ci;

USE DailyPlanetMartina;

CREATE TABLE Clanky (
  id_clanku INT PRIMARY KEY AUTO_INCREMENT,
  Nazev VARCHAR(250),
  Autor VARCHAR(250),
  id_autor VARCHAR(250),
  Datum DATE DEFAULT now() NOT NULL
);

INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Lidé doma hromadí léky', 'Loise Lane', 1, '2019-02-08');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Nový japonský císař', 'Clark Kent', 2, '2019-02-14');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Prodeje androidových telefonů rostou', 'Bob Harley', 3, '2019-02-24');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('U přehrady našli utonulého muže', 'Cat Grant', 4, '2019-02-01');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Chléb bude dražší', 'Loise Lane', 1, '2019-02-02');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Nová česká prezidentka', 'Clark Kent', 2, '2019-02-25');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Nikdo už nekupuje androidové telefony', 'Bob Harley', 3, '2018-02-19');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Množírny zvířat zakázány', 'Cat Grant', 4, '2019-02-12');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Mléko bude dražší', 'Loise Lane', 1, '2019-02-26');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Nová finská prezidentka', 'Clark Kent', 2, '2019-02-05');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Ledovce tají', 'Loise Lane', 1, '2019-02-03');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Na Prýglu se bruslí', 'Cat Grant', 4, '2019-02-18');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Letos v únoru napadlo opravdu hodně sněhu', 'Cat Grant', 4, '2019-02-11');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Došla káva', 'Loise Lane', 1, '2019-02-26');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('D1 konečně opravená', 'Clark Kent', 2, '2019-02-05');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Superman a Spiderman jsou kamarádi', 'Loise Lane', 1, '2019-02-03');
INSERT INTO Clanky (Nazev, Autor, id_autor, Datum) VALUES ('Agrofert musí vrátit všechny dotace', 'Cat Grant', 4, '2019-02-18');




CREATE TABLE Zamestnanci (
  id_autor INT PRIMARY KEY AUTO_INCREMENT,
  Jmeno VARCHAR(250),
  Bydliste VARCHAR(250),
  Plat INT,
  Datum_nastupu DATE DEFAULT now() NOT NULL
);


INSERT INTO Zamestnanci (id_autor, Jmeno, Bydliste, Plat, Datum_nastupu) VALUES (1, 'Loise Lane', 'Brno', 60000000, '2017-03-01');
INSERT INTO Zamestnanci (id_autor, Jmeno, Bydliste, Plat, Datum_nastupu) VALUES (2, 'Clark Kent', 'Pelhřimov', 58000000, '2018-04-01');
INSERT INTO Zamestnanci (id_autor, Jmeno, Bydliste, Plat, Datum_nastupu) VALUES (3, 'Bob Harley', 'Uherské Hradiště', 50000000, '2018-12-01');
INSERT INTO Zamestnanci (id_autor, Jmeno, Bydliste, Plat, Datum_nastupu) VALUES (4, 'Cat Grant', 'Liberec', 44000000, '2019-03-01');



CREATE TABLE Prodany_naklad ( 
  Datum DATE DEFAULT now() NOT NULL,
  Den_v_tydnu VARCHAR(15),
  Prodany_naklad INT,
  Zisk numeric(8,1)
);	
  
	
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-01', 'pondělí', 12563, 6281.5);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-02', 'úterý', 25456, 12728);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-03', 'středa', 345, 172.5);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-04', 'čtvrtek', 3548, 1774);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-05', 'pátek', 5464, 2732);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-08', 'pondělí', 6545, 3272.5);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-09', 'úterý', 8672, 4336);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-10', 'středa', 256464, 128232);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-11', 'čtvrtek', 8648, 4324);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-12', 'pátek', 484, 242);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-15', 'pondělí', 84684, 42342);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-16', 'úterý', 684, 342);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-17', 'středa', 5454, 2727);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-18', 'čtvrtek', 5465, 2732.5);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-19', 'pátek', 28848, 14424);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-22', 'pondělí', 8787, 4393.5);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-23', 'úterý', 86786, 43393);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-24', 'středa', 5688, 2844);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-25', 'čtvrtek', 54868, 27434);
INSERT INTO Prodany_naklad (Datum, Den_v_tydnu, prodany_naklad, Zisk) VALUES ('2019-02-26', 'pátek', 4888, 2444);





