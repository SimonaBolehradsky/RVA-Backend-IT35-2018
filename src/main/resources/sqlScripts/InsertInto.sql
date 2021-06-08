INSERT INTO "preduzece"("id", "naziv","pib","sediste","opis")
VALUES(nextval('preduzece_seq'),'NIS a.d.',123,'Novi Sad','Naftna industrija Srbije (NIS) srpska je naftna kompanija ');

INSERT INTO "preduzece"("id", "naziv","pib","sediste","opis")
VALUES(nextval('preduzece_seq'),'Tarkett d.o.o.',856,'Backa Palanka','Bavi se izradom tepiha, podnih obloga i parketa. ');

INSERT INTO "preduzece"("id", "naziv","pib","sediste","opis")
VALUES(nextval('preduzece_seq'),'Tigar Tyres d.o.o.',874,'Pirot','Fabrika Tigar je kompanija koja se bavi proizvodnjom automobilskih guma, obuće i tehničke gume.');

INSERT INTO "preduzece"("id", "naziv","pib","sediste","opis")
VALUES(nextval('preduzece_seq'),'IM Matijevic d.o.o.',214,'Novi Sad','Industrija mesa Matijević d.o.o. je kompanija za proizvodnju i promet mesa i mesnih prerađevina');

INSERT INTO "preduzece"("id", "naziv","pib","sediste","opis")
VALUES(nextval('preduzece_seq'),'Sunoko d.o.o.',533,'Novi Sad','Sunoko d.o.o. je srpsko-nemačka kompanija osnovana u Novom Sadu 2005. godine.');


INSERT INTO "preduzece"("id", "naziv","pib","sediste","opis")
VALUES(-100,'Test',533,'Test','Sunoko d.o.o. je srpsko-nema�ka kompanija osnovana u Novom Sadu 2005. godine.');

--obrazovanje
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES(nextval('obrazovanje_seq'),'Inzenjer','7/1', 'opis');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES(nextval('obrazovanje_seq'),'Ekonomista','6/2', 'opis');
INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES(nextval('obrazovanje_seq'),'Programer','8', 'opis');

INSERT INTO "obrazovanje"("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES(-100,'Test test','8', 'opis');


--SEKTOR
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
VALUES(nextval('sektor_seq'),'IT sektor', 'IT',1);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
VALUES(nextval('sektor_seq'),'Finansijski sektor', 'F',2);
INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
VALUES(nextval('sektor_seq'),'Mediji', 'M',5);

INSERT INTO "sektor"("id", "naziv", "oznaka", "preduzece")
VALUES(-100,'Test', 'M',5);



--radnik
INSERT INTO "radnik"("id", "ime","prezime","broj_lk","obrazovanje","sektor")
VALUES(nextval('radnik_seq'),'Marko','Markovic',2357,1,1);
INSERT INTO "radnik"("id", "ime","prezime","broj_lk","obrazovanje","sektor")
VALUES(nextval('radnik_seq'),'Iva','Ivanovic',1456,2,1);
INSERT INTO "radnik"("id", "ime","prezime","broj_lk","obrazovanje","sektor")
VALUES(nextval('radnik_seq'),'Pera','Peric',5632,3,3);

INSERT INTO "radnik"("id", "ime","prezime","broj_lk","obrazovanje","sektor")
VALUES(-100,'Test','Peric',5632,3,3);
