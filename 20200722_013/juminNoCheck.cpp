#include "config.h"

void main() {

	char juminNo[14];				// 주민등록번호 13자리를 입력받을 문자 배열
	char check[] = "234567892345";	// 가중치

	printf("주민등록번호 13자리를 '-'없이 입력하세요 : ");
	scanf_s("%s", juminNo, sizeof(juminNo));

	int sum = 0;
	for (int i = 0; i < 12; i++) {
//		printf("%c * %c = %d * %d = %d\n", juminNo[i], check[i], juminNo[i], check[i], juminNo[i] * check[i]);
//		sum += (juminNo[i] - '0') * (check[i] - 48);		 // 가중치
//		sum += (juminNo[i] - '0') * (i < 8 ? i + 2 : i - 6); // 규칙1
		sum += (juminNo[i] - '0') * (i % 8 + 2);			 // 규칙2
	}
//	printf("%d\n", sum);

	int result = (11 - sum % 11) % 10;
	if (result == (juminNo[12] - 48)) {
		printf("정상\n");
	}
	else {
		printf("오류\n");
	}
	printf("%s\n", result == (juminNo[12] - 48) ? "정상" : "오류");
	cout << (result == (juminNo[12] - 48) ? "정상" : "오류") << endl;

}