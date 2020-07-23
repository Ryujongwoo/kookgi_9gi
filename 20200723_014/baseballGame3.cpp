#include "config.h"
#include <time.h>

void main() {

	srand(time(NULL));
	char baseball[] = "123456789";
	for (int i = 0; i < 1000000; i++) {
		int r = rand() % 8 + 1;
		swap(baseball[0], baseball[r]);
	}
//	printf("%s\n", baseball);

	int level;
	printf("레벨을 입력하세요 : ");
	scanf_s("%d", &level);
	printf("cpu : ");
	for (int i = 0; i < level; i++) {
		printf("%c", baseball[i]);
	}
	printf("\n");

	int count = 0;
	int start = time(NULL);
	while (true) {
		int s = 0, b = 0;

//		컴퓨터가 발생시킨 숫자를 맛추기 위해 레벨의 크기만큼 메모리를 동적으로 할당하고 문자열을 입력받는다.
//		char* user = (char*)malloc(sizeof(char) * level + 1);
		char* user = new char[level + 1];
		cout << "user : ";
//		scanf_s() 함수로 문자열을 입력받을 때 반드시 3번째 인수로 입력받을 문자열의 최대 길이를 지정해야 한다.
		scanf_s("%s", user, _msize(user));
		count++;

		for (int i = 0; i < level; i++) {
			if (baseball[i] == user[i]) {
				s++;
			}
			for (int j = 0; j < level; j++) {
				if (baseball[j] == user[i]) {
					b++;
				}
			}
		}

		if (level == s) {
			break;
		}
		printf("%d 스트라이크 %d 볼\n", s, b - s);

	}

	int end = time(NULL);
	printf("%d초 걸려서 %d번 만에 맞췄다.\n", end - start, count);

}