CREATE TABLE "MVCBOARD" (
  "IDX" NUMBER(*,0) NOT NULL, 
	"NAME" CHAR(20 BYTE) NOT NULL, 
	"SUBJECT" VARCHAR2(200 BYTE) NOT NULL, 
	"CONTENT" VARCHAR2(2000 BYTE) NOT NULL, 
	"REF" NUMBER(*,0), 
	"LEV" NUMBER(*,0), 
	"SEQ" NUMBER(*,0), 
	"HIT" NUMBER(*,0) DEFAULT 0, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	PRIMARY KEY ("IDX")
);

delete from mvcboard;
drop sequence mvcboard_idx_seq;
create sequence mvcboard_idx_seq;
commit;

select * from mvcboard order by ref desc, seq asc;
select count(*) from mvcboard;

insert into mvcboard (idx, name, subject, content, ref, lev, seq) 
values (mvcboard_idx_seq.nextval, '홍길동', '1등', '1등 입니다.', mvcboard_idx_seq.currval, 0, 0);
insert into mvcboard (idx, name, subject, content, ref, lev, seq) 
values (mvcboard_idx_seq.nextval, '임꺽정', '2등', '2등 입니다.', mvcboard_idx_seq.currval, 0, 0);
insert into mvcboard (idx, name, subject, content, ref, lev, seq) 
values (mvcboard_idx_seq.nextval, '장길산', '3등', '3등 입니다.', mvcboard_idx_seq.currval, 0, 0);
insert into mvcboard (idx, name, subject, content, ref, lev, seq) 
values (mvcboard_idx_seq.nextval, '일지매', '4등', '4등 입니다.', mvcboard_idx_seq.currval, 0, 0);