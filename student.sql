CREATE DATABASE IF NOT EXISTS IS345
;

USE IS345;


;
DROP TABLE IF EXISTS tblStudent
;


CREATE TABLE tblStudent (
	ID integer NOT NULL,
	StudentName varchar (50) NOT NULL,
	StudentAddr varchar (50) ,
	StudentState varchar (10),
	PRIMARY KEY (ID)
) TYPE=INNODB
;



INSERT INTO tblStudent VALUES (1002,'Jane Evans','','')
;

INSERT INTO tblStudent VALUES (1010,'Carol Lucas','','')
;

INSERT INTO tblStudent VALUES (1001,'Lynn Garvey','','')
;

INSERT INTO tblStudent VALUES (2003,'Kim Grey','','')
;

INSERT INTO tblStudent VALUES (1004,'Dan Leri','','')
;

INSERT INTO tblStudent VALUES (1005,'John Michaelson','','')
;

INSERT INTO tblStudent VALUES (1011,'Steve Finley','','')
;

INSERT INTO tblStudent VALUES (1015,'Sheri Edwards','','')
;

INSERT INTO tblStudent VALUES (1016,'William Harrison','','')
;

INSERT INTO tblStudent VALUES (2004,'Paula Reynolds','','')
;

INSERT INTO tblStudent VALUES (2006,'Thomas Jenkins','','')
;

INSERT INTO tblStudent VALUES (2007,'John Garrison','','')
;

INSERT INTO tblStudent VALUES (2008,'John Green','','')
;

INSERT INTO tblStudent VALUES (2017,'Mike Kennedy','','')
;

INSERT INTO tblStudent VALUES (2027,'Donna Wiser','','')
;

INSERT INTO tblStudent VALUES (3010,'Lisa Smith','','')
;

INSERT INTO tblStudent VALUES (3022,'Bob Walker','','')
;
