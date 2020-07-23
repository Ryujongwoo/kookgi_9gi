#include "config.h"
#include <time.h>

void main() {

	srand(time(NULL));
	int baseball[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	for (int i = 0; i < 1000000; i++) {
		int r = rand() % 8 + 1;
		swap(baseball[0], baseball[r]);
	}

	int level;
	printf("레벨을 입력하세요 : ");
	scanf_s("%d", &level);
	printf("cpu : ");
	for (int i = 0; i < level; i++) {
		printf("%d", baseball[i]);
	}
	printf("\n");

	int count = 0;
	int start = time(NULL);
	while (true) {
		int s = 0, b = 0;

		int user;
		printf("user : ");
		scanf_s("%d", &user);
		count++;
		
		for (int i = 0; i < level; i++) {

//			입력한 숫자의 앞 부분 부터 비교하기 위해 입력한 레벨이 3일 경우 100, 10, 1로 나눈 몫을 계산한다.
//			level에 3을 입력했을 경우 i값은 0, 1, 2로 변경되므로 level - i - 1을 계산하면 아래와 같다.
//			3 - 0 - 1 => 2, pow(10, 2) => 100
//			3 - 1 - 1 => 1, pow(10, 1) => 10
//			3 - 2 - 1 => 0, pow(10, 0) => 1
			int r = pow(10, level - i - 1);

			int mok = user / r;

			if (baseball[i] == mok) {
				s++;
			}
			for (int j = 0; j < level; j++) {
				if (baseball[j] == mok) {
					b++;
				}
			}

//			다음 자리의 숫자를 비교하기 위해 user에 저장된 값을 pow(10, level - i - 1)로 나눈 나머지로 변경시킨다.
			user %= r;

		}

		if (level == s) {
			break;
		}
		printf("%d 스트라이크 %d 볼\n", s, b - s);

	}

	int end = time(NULL);
	printf("%d초 걸려서 %d번 만에 맞췄다.\n", end - start, count);

}