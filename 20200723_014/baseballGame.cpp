#include "config.h"
#include <time.h>

void main() {

//	레벨을 입력받아 1 ~ 9 사이의 숫자 중에서 중복을 허용하지 않고 레벨의 크기만큼 숫자를 얻어낸다.
	srand(time(NULL));
	int baseball[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	for (int i = 0; i < 1000000; i++) {
		int r = rand() % 8 + 1;
		swap(baseball[0], baseball[r]);
	}
//	for (int i = 0; i < 9; i++) {
//		printf("%d ", baseball[i]);
//	}

//	레벨을 입력받는다.
	int level;
	printf("레벨을 입력하세요 : ");
	scanf_s("%d", &level);
//	프로그램이 정상적으로 실행되는가 결과를 확인하기 위해 입력된 레벨만큼의 숫자를 배열에서 출력한다.
//	이 부분은 작업이 완료되면 주석으로 처리한다.
	printf("cpu : ");
	for (int i = 0; i < level; i++) {
		printf("%d", baseball[i]);
	}
	printf("\n");

//	여기부터 맞출 때 까지 반복한다. => 몇 번 만에 맞출지 모르기 때문에 무한 루프를 돌리다가 스트라이크의 개수와
//	레벨이 같아지면 무한 루프를 탈출시킨다.
	int count = 0;				// 유저가 숫자를 입력한 횟수를 카운트 하는 변수를 선언하고 초기화 시킨다.
	int start = time(NULL);		// 게임 시작 시간
	while (true) {

//		스트라이크와 볼의 개수를 세는 변수를 선언하고 초기화시킨다.
//		유저가 숫자를 입력할 때 마다 스트라이크의 개수와 볼의 개수를 다시 계산해야 하기 때문에 매 반복마다
//		초기화를 시켜야 한다.
		int s = 0, b = 0;

//		컴퓨터가 발생시킨 숫자를 맞추기 위해서 숫자를 입력한다.
		int user;
		printf("user : ");
		scanf_s("%d", &user);
		count++;	// 유저가 숫자를 입력할 때 마다 1씩 증가시킨다.
		
//		레벨만큼 반복하며 스트라이크와 볼의 개수를 센다.
		for (int i = level - 1; i >= 0; i--) {

//			비교를 입력한 숫자의 뒤쪽(일자리) 부터 하기 위해서 10으로 나눈 나머지와 baseball 배열에 저장된 값을
//			비교한다.
			int nmg = user % 10;
//			baseball[i]의 값과 nmg가 같으면 스트라이크
			if (baseball[i] == nmg) {
				s++;
			}

//			baseball 배열에 nmg가 포함되어있느면 볼 => 같은 위치에 있는것도 포함에 해당된다.
			for (int j = 0; j < level; j++) {
				if (baseball[j] == nmg) {
					b++;
				}
			}

//			다음 자리의 숫자를 비교하기 위해서 user에 저장된 값을 10으로 나눈 몫으로 변경시킨다.
			user /= 10;

		}

//		맞췄으면 무한 루프를 탈출시킨다.
		if (level == s) {
			break;
		}
//		볼의 개수에서 스트라이크의 개수를 빼서 출력한다.
		printf("%d 스트라이크 %d 볼\n", s, b - s);

	}

	int end = time(NULL);		// 게임 종료 시간
	printf("%d초 걸려서 %d번 만에 맞췄다.\n", end - start, count);

}