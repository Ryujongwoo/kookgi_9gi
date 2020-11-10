CREATE TABLE "FILEUPLOAD" (
  "IDX" NUMBER(*,0) NOT NULL, 
	"FILENAME" VARCHAR2(200 BYTE), 
	"FILEREALNAME" VARCHAR2(200 BYTE), 
  "DOWNLOADCOUNT" NUMBER(*,0) DEFAULT 0,
	PRIMARY KEY ("IDX")
);

delete from fileupload;
drop sequence fileupload_idx_seq;
create sequence fileupload_idx_seq;
commit;