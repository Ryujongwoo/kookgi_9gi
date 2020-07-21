#include "config.h"

void main() {

//	key에는 정수를 기억할 수 있는 변수(bool, char, short, int, long long int) 또는 연산 결과가 정수인 수식만 쓸
//	수 있다. => 문자열, 실수는 사용할 수 없다. => java 1.7 부터는 문자열도 사용할 수 있다.
//	switch (key) {
//		case value:		// case에 연산자를 사용할 수 없다. => 무조건 "=="로 처리된다.
//			key와 value가 같을 때 실행할 문장;
//			...;
//			[break;]	// 생략 가능, if를 제외한 제어문을 {} 블록을 탈출한다. <=> continue => 재실행
//		case ...
//		[default:
//			key와 일치하는 value가 없을 때 실행할 문장;
//			...;
//			break;]
//	}

	int cpp, java, jsp;

	cout << "3과목 점수를 입력하세요 : ";
	cin >> cpp >> java >> jsp;

	int total = cpp + java + jsp;
	double average = (double)total / 3;

	switch ((int)average / 10) {
		case 10:
			cout << "참잘했어요!!!" << endl;
//			break;
		case 9:
			cout << "A" << endl;
			break;
		case 8:
			cout << "B" << endl;
			break;
		case 7:
			cout << "C" << endl;
			break;
		case 6:
			cout << "D" << endl;
			break;
//		case 5: case 4: case 3: case 2: case 1: case 0:		// 기타 등등 케이스, 그렇치 않은 케이스
		default:
			cout << "F" << endl;
			break;
	}

}