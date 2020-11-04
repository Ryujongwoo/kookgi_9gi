CREATE TABLE "CATEGORY" (
    "IDX" NUMBER(*,0) NOT NULL, 
	"CATEGORY" VARCHAR2(200 BYTE) NOT NULL, 
	"REF" NUMBER(*,0), 
	"LEV" NUMBER(*,0), 
	"SEQ" NUMBER(*,0), 
    "DELETECHECK" CHAR(3 BYTE) DEFAULT 'no',
    "DELETEREPORT" NUMBER(*,0) DEFAULT 0,
	PRIMARY KEY ("IDX")
);

delete from category;
drop sequence category_idx_seq;
create sequence category_idx_seq;
commit;

-- 답변형 게시판은 글 목록을 얻어올 때 글그룹(ref)을 내림차순으로 정렬해 얻어오고 같은 글그룹 안에서는 출력순서(seq)의 오름차순으로 얻어온다.
select * from category order by ref desc, seq asc;
select * from category;

