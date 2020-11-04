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

-- �亯�� �Խ����� �� ����� ���� �� �۱׷�(ref)�� ������������ ������ ������ ���� �۱׷� �ȿ����� ��¼���(seq)�� ������������ ���´�.
select * from category order by ref desc, seq asc;
select * from category;

