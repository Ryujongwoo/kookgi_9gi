#include "config.h"
#include <stdlib.h>		// 순수한 c언어에서 rand(), srand() 함수를 사용할 수 있게 해주는 헤더 파일
#include <time.h>		// time() 함수를 사용할 수 있게 해주는 헤더 파일
#include <Windows.h>	// Sleep() 함수를 사용할 수 있게 해주는 헤더 파일

void main() {

	/*
//	time(NULL) : 1970년 1월 1일 자정부터 이 함수가 실행되는 순간까지 지난 시간을 초 단위로 얻어온다.
	printf("유닉스 타임 : %d\n", time(NULL));

//	srand(seed) : 인수로 지정된 seed 값을 이용해 내부 알고리즘으로 수열을 발생시킨다. => seed가 변경되야 난수가
//	변경된다.
//	매번 고정된 난수 배열을 얻으려면 seed 값을 같은 값으로 지정하면 되고 매번 변경되는 난수 배열을 얻으러면 
//	seed 값을 매번 다른 값으로 변경시키면 된다.
	srand(time(NULL));
	for (int i = 0; i < 10; i++) {
//		rand() : 0 이상인 난수를 정수로 발생시킨다.
//		난수를 발생시켜 보고 싶은 크기의 숫자로 나눈 나머지를 사용한다.
		printf("%d\n", rand() % 6);
	}
	*/

//	추첨기를 만든다.
	int lotto[45];

//	추첨기에 공을 넣는다.
	for (int i = 0; i < 45; i++) {
		lotto[i] = i + 1;
	}
	for (int i = 0; i < 45; i++) {
		printf("%2d ", lotto[i]);
		if ((i + 1) % 10 == 0) {
			printf("\n");
		}
	}
	printf("\n=========== 섞기전 ===========\n");

//	섞는다. => lotto[0]와 lotto[1] ~ lotto[44] 중에서 랜덤한 위치와 값을 교환한다.
	srand(time(NULL));
	for (int i = 0; i < 1000000; i++) {
		int r = rand() % 44 + 1;
//		int temp = lotto[0];
//		lotto[0] = lotto[r];
//		lotto[r] = temp;
		swap(lotto[0], lotto[r]);
	}
	for (int i = 0; i < 45; i++) {
		printf("%2d ", lotto[i]);
		if ((i + 1) % 10 == 0) {
			printf("\n");
		}
	}
	printf("\n=========== 섞은후 ===========\n");

//	앞의 6개가 1등 번호 배열의 7번째 숫자는 보너스
//	printf("1등 번호 : ");
	cout << "1등 번호 : ";
	for (int i = 0; i < 6; i++) {
//		printf("%d ", lotto[i]);
		cout << lotto[i] << " ";

//		Sleep(시간) : 인수로 지정된 시간 만큼 프로그램을 멈춘다. => 시간은 밀리(1/1000)초 단위로 지정한다.
		Sleep(1000);

	}
//	printf("보너스 : %d\n", lotto[6]);
	cout << "보너스 : " << lotto[6] << endl;

}