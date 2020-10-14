SELECT * FROM memolist ORDER BY idx DESC;

# 자동증가가 다시 1부터 시작되게 한다.
DELETE FROM memoList;
ALTER TABLE memolist AUTO_INCREMENT = 1;

INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('홍길동', '1111', '1등 입니다.', '192.168.100.101');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('임꺽정', '2222', '2등 입니다.', '192.168.100.102');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('장길산', '3333', '3등 입니다.', '192.168.100.103');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('일지매', '4444', '4등 입니다.', '192.168.100.104');

