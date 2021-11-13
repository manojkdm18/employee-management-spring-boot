create table department(
DEPTRFNUM bigint(20) NOT NULL AUTO_INCREMENT,
DEPTNAME VARCHAR(120),
DEPTCODE VARCHAR(120) UNIQUE,
ISACTIVE char(1) NOT NULL DEFAULT 'N',
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (DEPTRFNUM)
);

create table address (
ADDRFNUM bigint(20) NOT NULL AUTO_INCREMENT,
CITY VARCHAR(120),
STATE VARCHAR(120),
COUNTRY VARCHAR(120),
ZIPCODE VARCHAR(50),
ISACTIVE char(1) NOT NULL DEFAULT 'N',
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (ADDRFNUM)
);


create table employee(
EMPRFNUM bigint(20) NOT NULL AUTO_INCREMENT,
FIRSTNAME VARCHAR(120),
LASTNAME VARCHAR(120),
EMPID VARCHAR(120) UNIQUE,
EMAIL VARCHAR(120) UNIQUE,
MOBILE VARCHAR(12) UNIQUE,
DESIGNATION VARCHAR(20),
SALARY decimal(10,2),
DATE_OF_BIRTH VARCHAR(120),
GENDER char (1),
FK_DEPTRFNUM bigint(10),
ISACTIVE char(1) NOT NULL DEFAULT 'N',
CREATEDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
MODIDATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (EMPRFNUM)
);


alter table employee ADD CONSTRAINT FK_DEPTRFNUM FOREIGN KEY (FK_DEPTRFNUM) REFERENCES department (DEPTRFNUM) ON DELETE CASCADE;
alter table employee ADD CONSTRAINT FK_ADDRFNUM FOREIGN KEY (FK_ADDRFNUM) REFERENCES address (ADDRFNUM) ON DELETE CASCADE;


insert into department values(NULL,'INFORMATION TECHNOLOGY','IT','Y',NOW(),NOW());
insert into department values(NULL,'COMPUTER SCIENCE','CS','Y',NOW(),NOW());
