CREATE TABLE "REGISTER" (
  "USERID" VARCHAR2(20 BYTE) NOT NULL, 
	"USERPASSWORD" VARCHAR2(20 BYTE) NOT NULL, 
	"USERNAME" VARCHAR2(20 BYTE) NOT NULL, 
	"USERAGE" NUMBER(*,0) NOT NULL, 
	"USERGENDER" VARCHAR2(20 BYTE) NOT NULL, 
	"USEREMAIL" VARCHAR2(20 BYTE) NOT NULL, 
	PRIMARY KEY ("USERID")
);

select * from register;
