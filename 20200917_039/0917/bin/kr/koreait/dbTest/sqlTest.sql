# insert into 테이블이름(필드이름, ...) values (데이터, ...);
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('홍길동', '1111', '1등 입니다.');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('임꺽정', '2222', '2등 입니다.');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('장길산', '3333', '3등 입니다.');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES ('일지매', '4444', '4등 입니다.');
# 아래와 같이 테이블 이름만 사용하면 모든 필드에 데이터를 저장한다는 의미이다.
INSERT INTO memo VALUES ('손오공', '5555', '5등 입니다.');

