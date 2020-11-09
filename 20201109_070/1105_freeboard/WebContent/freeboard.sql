CREATE TABLE "FREEBOARD" (
  "IDX" NUMBER(*,0) NOT NULL, 
	"NAME" CHAR(20 BYTE) NOT NULL, 
	"PASSWORD" CHAR(20 BYTE) NOT NULL, 
	"SUBJECT" VARCHAR2(200 BYTE) NOT NULL, 
	"CONTENT" VARCHAR2(3000 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"HIT" NUMBER(*,0) DEFAULT 0, 
	"IP" CHAR(15 BYTE), 
	"NOTICE" CHAR(6 BYTE) DEFAULT 'no', 
	PRIMARY KEY ("IDX")
);

delete from freeboard;
drop sequence freeboard_idx_seq;
create sequence freeboard_idx_seq;
commit;

insert into freeboard (idx, name, password, subject, content, ip) 
values (freeboard_idx_seq.nextval, 'ȫ�浿', '1111', '1��', '1�� �Դϴ�.', '192.168.100.101');
insert into freeboard (idx, name, password, subject, content, ip) 
values (freeboard_idx_seq.nextval, '�Ӳ���', '2222', '2��', '2�� �Դϴ�.', '192.168.100.102');
insert into freeboard (idx, name, password, subject, content, ip) 
values (freeboard_idx_seq.nextval, '����', '3333', '3��', '3�� �Դϴ�.', '192.168.100.103');
insert into freeboard (idx, name, password, subject, content, ip) 
values (freeboard_idx_seq.nextval, '������', '4444', '4��', '4�� �Դϴ�.', '192.168.100.104');

select * from freeboard order by idx desc;
select count(*) from freeboard;

CREATE TABLE "FREEBOARDCOMMENT" (
  "IDX" NUMBER(*,0) NOT NULL, 
	"REF" NUMBER(*,0), 
	"NAME" CHAR(20 BYTE) NOT NULL, 
	"PASSWORD" CHAR(20 BYTE) NOT NULL, 
	"CONTENT" VARCHAR2(2000 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"IP" CHAR(15 BYTE), 
	PRIMARY KEY ("IDX")
);

delete from freeboardcomment;
drop sequence freeboardcomment_idx_seq;
create sequence freeboardcomment_idx_seq;
commit;

select * from freeboardcomment order by idx desc;
select count(*) from freeboardcomment;