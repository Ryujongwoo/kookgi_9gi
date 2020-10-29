CREATE TABLE "GUESTBOOK" (
    "IDX" NUMBER(*,0) NOT NULL, 
	"NAME" CHAR(30 BYTE) NOT NULL, 
	"PASSWORD" CHAR(30 BYTE) NOT NULL, 
	"MEMO" VARCHAR2(1000 BYTE) NOT NULL, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"IP" CHAR(15 BYTE), 
	PRIMARY KEY ("IDX")
);

-- �ּ��Դϴ�.
-- �۹�ȣ�� �ٽ� 1���� ���۵ǰ� �Ϸ��� ���̺��� ��� �����͸� �����ϰ� �������� ������ �� �ٽ� ����� �ȴ�.
delete from guestbook;
-- ������ ����
drop sequence guestbook_idx_seq;
-- �ڵ����� 1�� �����ϴ� ������ �����
create sequence guestbook_idx_seq;

select * from guestbook order by idx desc;
select count(*) from guestbook;
select count(*) from guestbook where memo like '%1��%';
select count(*) from guestbook where name like '%��%';

insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, 'ȫ�浿', '1111', '1�� �Դϴ�.', '192.168.100.101');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '�Ӳ���', '2222', '2�� �Դϴ�.', '192.168.100.102');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '����', '3333', '3�� �Դϴ�.', '192.168.100.103');
insert into guestbook (idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '������', '4444', '4�� �Դϴ�.', '192.168.100.104');

-- �𺧷��ۿ��� ������ sql ����� �ڵ����� commit(�Ϸ�)�� ���� �ʴ´�. sql ����� �ӽ÷� ����� �����̴�.
-- �𺧷��ۿ��� ������ sql ����� �̻���� ���������� ������ �Ǿ��ٸ� �ݵ�� commit ����� �����ؼ� �Ϸ� ���Ѿ� �Ѵ�.
commit;


