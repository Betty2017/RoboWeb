USE RESUME;

Drop table if exists PERSON;
CREATE TABLE PERSON (
PID INTEGER ,
FNAME VARCHAR(256) NOT NULL, 
LNAME VARCHAR(256) NOT NULL, 
EMAIL VARCHAR(256) NOT NULL, 
PRIMARY KEY (PID)); 

SELECT * from PERSON;

INSERT INTO PERSON( PID,FNAME, LNAME, EMAIL) VALUES 
(1,"John J", "Jingleheimer-Schmidt", "jjjschmidt@gmail.com");

Drop table if exists EDU;

SELECT * from JOB ;


CREATE TABLE EDU(
EDUNUM INTEGER NOT NULL auto_increment,
DEGREE VARCHAR(245) NOT NULL,
SCHOOL VARCHAR(256) NOT NULL, 
GYEAR VARCHAR(8) NOT NULL,
PID INTEGER,
FOREIGN KEY (PID) REFERENCES PERSON(PID),
primary key (EDUNUM)); 


INSERT INTO EDU(EDUNUM, DEGREE, SCHOOL, GYEAR, PID) VALUES 
(101, "BS Comouter", "MC","2017",1);

INSERT INTO EDU(EDUNUM, DEGREE, SCHOOL, GYEAR, PID) VALUES 
(102, "BS Math", "NOVA","2016",1);

SELECT* FROM  EDU WHERE PID = 1;


SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;




Drop table if exists JOB;

CREATE TABLE JOB(
JOBID INTEGER NOT NULL auto_increment, 
TITLE VARCHAR(256) NOT NULL,  
COMPANY VARCHAR(245) NOT NULL,
DATES VARCHAR(66) NOT NULL, 
DUTY1 VARCHAR(565),
DUTY2 VARCHAR(566),
PID INTEGER NOT NULL,
PRIMARY KEY(JOBID));

INSERT INTO JOB(JOBID, TITLE, COMPANY, DATES, DUTY1,DUTY2,PID) VALUES 
(1, "Software Developer II", "Amtrak","June 2015 - Present"," Lorem ipsum"," Gaudeamos Igitur Iuvenes Dum Somos",1);
INSERT INTO JOB(JOBID, TITLE, COMPANY, DATES, DUTY1,DUTY2,PID) VALUES 
(2, "Software Developer I", "Amtrak","June 2014 - Present"," Lorem ipsum"," Gaudeamos Igitur Iuvenes Dum Somos",1);
INSERT INTO JOB(JOBID, TITLE, COMPANY, DATES, DUTY1,DUTY2,PID) VALUES 
(3, "Software Developer ", "Amtrak","June 2000 - Present"," Lorem ipsum"," Gaudeamos Igitur Iuvenes Dum Somos",1);

Drop table if exists SKILL;

CREATE TABLE SKILL( 
SKILLID INTEGER NOT NULL auto_increment, 
NAME VARCHAR(565) NOT NULL, 
PROFICENCY VARCHAR(565) NOT NULL,
PID INTEGER NOT NULL,
PRIMARY KEY(SKILLID)); 


INSERT INTO SKILL(SKILLID, NAME, PROFICENCY, PID) VALUES 
(1, "PHP", "highly skilled",1);

INSERT INTO SKILL(SKILLID, NAME, PROFICENCY, PID) VALUES 
(2, "Java", "proficient",1);

INSERT INTO SKILL(SKILLID, NAME, PROFICENCY, PID) VALUES 
(3, "Ruby", "familiar",1);


