# insert into 테이블이름(필드이름, ...) values (데이터, ...);
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('홍길동', '1111', '1등 입니다.');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('임꺽정', '2222', '2등 입니다.');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('장길산', '3333', '3등 입니다.');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('일지매', '4444', '4등 입니다.');
# 아래와 같이 테이블 이름만 사용하면 모든 필드에 데이터를 저장한다는 의미이다.
INSERT INTO memo VALUES ('손오공', '5555', '5등 입니다.');

# idx 자동증가 다시 1부터 시작하기 => 테이블의 모든 데이터를 삭제한 후 실행해야 한다.
DELETE FROM memo;
ALTER TABLE memo AUTO_INCREMENT = 1;

# select [dictinct] 필드이름 또는 * from 테이블이름 order by 필드이름 [asc/desc];
# order by => 지정된 필드를 기준으로 정렬시킨다. 정렬 방식을 생략하면 asc가 기본값이고 오름차순으로 출력한다.
# 정렬 방식에 desc를 쓰면 내림차순으로 정렬시켜 출력한다.
# '*'은 모든 필드를 의미하고 특정 필드면 보려면 보려하는 필드의 이름을 써주면 된다.
# dictinct는 중복되는 데이터는 한 번 씩만 출력한다.
SELECT * FROM memo;
SELECT * FROM memo ORDER BY idx DESC; # 최신 글 부터 얻어온다.
SELECT NAME, memo FROM memo;
SELECT DISTINCT NAME FROM memo;

# select * from 테이블이름 where 조건식
SELECT * FROM memo WHERE idx = 1; # 특정 글 한 건을 얻어온다.
SELECT * FROM memo WHERE PASSWORD = '2222';
SELECT * FROM memo WHERE NAME = '일지매';

SELECT * FROM memo WHERE NAME = '홍길동' || NAME = '장길산';
SELECT * FROM memo WHERE NAME = '임꺽정' OR NAME = '일지매';
SELECT * FROM memo WHERE NAME IN ('홍길동', '임꺽정', '장길산'); # () 안의 모든것
SELECT * FROM memo WHERE NAME NOT IN ('홍길동', '임꺽정', '장길산'); # () 안에 없는것

SELECT * FROM memo WHERE idx > 5 AND idx <= 10;
SELECT * FROM memo WHERE idx > 15 && idx <= 20;
SELECT * FROM memo WHERE idx BETWEEN 25 AND 30; # 이상, 이하 조건만 가능

# 부분일치 조건
# 와일드 카드(대체) 문자 %와 _ 및 LIKE 연산자를 사용해서 부분일치 조건을 지정할 수 있다.
# _는 1문자를 대체할 수 있고 %는 여러 문자를 대체할 수 있다.
# 역삼_동 => 역삼1동, 역삼2동, 역삼3동, ... 처럼 _ 자리에는 어떤 문자가 나와도 상관없다는 의미이다.
# 홍% => 홍으로 시작하는, %정 => 정으로 끝나는, %길% => 길을 포함하는
SELECT * FROM memo WHERE NAME LIKE '홍%';
SELECT * FROM memo WHERE NAME LIKE '%정';
SELECT * FROM memo WHERE NAME LIKE '%길%'; # 검색 기능 구현에 많이 사용한다.

# LIMIT를 이용해서 특정 index 부터 원하는 개수를 지정해 목록을 얻어올 수 있다.
# 인덱스는 select sql 명령을 실행했을 때 출력 결과의 첫 번째 데이터의 index가 0부터 시작된다. => 오라클은 1부터 시작된다.
# LIMIT 시작 인덱스, 개수
SELECT * FROM memo ORDER BY idx DESC LIMIT 0, 10; # 최신글 순으로 1페이지 분량의 목록을 얻어온다.
SELECT * FROM memo ORDER BY idx ASC LIMIT 0, 10;

# 그룹 함수 : SUM(합계), AVG(평균), MAX(최대값), MIN(최소값), COUNT(개수)
SELECT SUM(idx) FROM memo WHERE idx <= 10;
SELECT AVG(idx) FROM memo WHERE idx <= 10;
SELECT MAX(idx) FROM memo WHERE idx <= 10;
SELECT MIN(idx) FROM memo WHERE idx <= 10;
# 개수는 어떤 필드의 개수를 세더라도 같은 결과가 나오기 때문에 인수로 '*'을 사용한다.
SELECT COUNT(*) FROM memo; # 테이블에 저장된 전체 글의 개수를 얻어올 수 있다.

# select 그룹함수(필드이름) from 테이블이름 where 전체조건 group by 필드이름 heaving 그룹조건
SELECT NAME, COUNT(*) FROM memo GROUP BY NAME HAVING NAME LIKE '%길%';

# update 테이블이름 set 수정할 내용, ... where 조건식
# 조건식을 생략하면 테이블의 전체 데이터를 수정하기 때문에 반드시 조건을 지정해서 사용한다.
UPDATE memo SET PASSWORD = '9999';
UPDATE memo SET PASSWORD = '1111' WHERE NAME = '홍길동';
UPDATE memo SET PASSWORD = '2222' WHERE NAME = '임꺽정';
UPDATE memo SET PASSWORD = '3333' WHERE NAME = '장길산';
UPDATE memo SET PASSWORD = '4444' WHERE NAME = '일지매';

# delete from 테이블이름 where 조건식
# 조건식을 생략하면 테이블의 전체 데이터를 삭제하기 때문에 반드시 조건을 지정해서 사용한다.
DELETE FROM memo;
DELETE FROM memo WHERE NAME = '홍길동';


SELECT * FROM memo;