CREATE TABLE "GUESTBOOK" (
    "IDX" NUMBER(*,0) NOT NULL, 
	"NAME" CHAR(30 BYTE) NOT NULL, 
	"PASSWORD" CHAR(30 BYTE) NOT NULL, 
	"MEMO" VARCHAR2(1000 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"IP" CHAR(15 BYTE), 
	PRIMARY KEY ("IDX")
);

-- 주석입니다.
-- 글번호를 다시 1부터 시작되게 하려면 테이블의 모든 데이터를 제거하고 시퀀스를 삭제한 후 다시 만들면 된다.
delete from guestbook;
-- 시퀀스 제거
drop sequence guestbook_idx_seq;
-- 자동으로 1씩 증가하는 시퀀스 만들기
create sequence guestbook_idx_seq;

select * from guestbook order by idx desc;
select count(*) from guestbook;
select count(*) from guestbook where memo like '%1등%';
select count(*) from guestbook where name like '%길%';

insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '홍길동', '1111', '1등 입니다.', '192.168.100.101');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '임꺽정', '2222', '2등 입니다.', '192.168.100.102');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '장길산', '3333', '3등 입니다.', '192.168.100.103');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '일지매', '4444', '4등 입니다.', '192.168.100.104');

-- 디벨로퍼에서 실행한 sql 명령은 자동으로 commit(완료)이 되지 않는다. sql 명령이 임시로 실행된 상태이다.
-- 디벨로퍼에서 실행한 sql 명령은 이상없이 정상적으로 실행이 되었다면 반드시 commit 명령을 실행해서 완료 시켜야 한다.
commit;


