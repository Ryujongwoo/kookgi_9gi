CREATE TABLE "AJAX" (
  "IDX" NUMBER(*,0) NOT NULL, 
	"NAME" VARCHAR2(20 BYTE) NOT NULL, 
	"AGE" NUMBER(*,0) NOT NULL, 
	"GENDER" VARCHAR2(20 BYTE) NOT NULL, 
	"EMAIL" VARCHAR2(50 BYTE) NOT NULL, 
	PRIMARY KEY ("IDX")
);

delete from ajax;
drop sequence ajax_idx_seq;
create sequence ajax_idx_seq;
commit;




