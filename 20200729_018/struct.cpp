#include "config.h"

//	프로그램에서 실제 초리할 데이터는 단일 자료형으로 구성되지 않는다.
//	구조체란 여러 자료형을 묶어서 프로그램에서 사용할 새로운 자료형을 만드는 것이다. => 사용자 정의 자료형 => 레코드
//	구조체에 저장된 데이터를 처리할 수 있는 함수가 추가되면 클래스가 된다.

//	typedef을 쓰면 반드시 구조체 별명을 정의해야 한다.
//	[typedef] struct 구조체이름 {
//		구조체를 구성하는 멤버 변수 선언;	// 필드
//		...;
//	} [별명];		// ";"을 빼먹으면 에러가 발생된다.

//	프로그램에서 Jumsu라고 코딩하면 컴파일러는 typedef에서 정의한 대로 struct Score로 컴파일한다.
typedef struct Score {
	int no;
	char name[11];
	int cpp, java, jsp, total;
	double average;
} Jumsu;

void main() {

//	구조체 변수 선언 방법
//	[struct] 구조체이름 구조체변수이름;
//	[struct] 구조체이름 구조체변수이름 = {초기치};
//	[struct] 구조체이름 구조체배열이름[인덱스];
//	[struct] 구조체이름* 구조체포인터변수이름;

	struct Score score1;

//	구조체 멤버 변수에 접근하는 방법
//	구조체 변수나 배열에서 구조체 멤버 변수에 접근하려면 구조체 변수이름 뒤에 "."을 찍어서 접근한다.
//	구조체 포인터 변수에서 구조체 멤버 변수에 접근하려면 구조체 변수이름 뒤에 "->"을 찍어서 접근한다.

	score1.no = 1;
	strcpy_s(score1.name, "홍길동");
	score1.cpp = 100;
	score1.java = 100;
	score1.jsp = 99;
	score1.total = score1.cpp + score1.java + score1.jsp;
	score1.average = (double)score1.total / 3;
	printf("%s님의 평균 점수는 %5.1f점 입니다.\n", score1.name, score1.average);

	Score score2 = { 2, "임꺽정", 55, 74, 69 };
	score2.total = score2.cpp + score2.java + score2.jsp;
	score2.average = (double)score2.total / 3;
	printf("%s님의 평균 점수는 %5.1f점 입니다.\n", score2.name, score2.average);

	Jumsu* pScore = &score1;
	printf("%s님의 평균 점수는 %5.1f점 입니다.\n", pScore->name, pScore->average);

}

//	비트 => 니블(4비트) => 바이트(8비트) => 워드(하프 => 2바이트, 풀 => 4바이트, 더블 => 8바이트) => 필드 => 레코드 => 블럭 => 파일