#include "config.h"

class Score {
private:
	int no;
	char name[11];
	int cpp, java, jsp, total;
	double average;
public:
	/*
	Score() {
		no = 0;
		strcpy_s(name, "무명씨");
		cpp = 0;
		java = 0;
		jsp = 0;
		total = cpp + java + jsp;
		average = (double)total / 3;
	}

	Score(int no, const char name[11], int cpp, int java, int jsp) {
		this->no = no;
		strcpy_s(this->name, name);
		this->cpp = cpp;
		this->java = java;
		this->jsp = jsp;
		total = cpp + java + jsp;
		average =(double)total / 3;
	}
	*/

//	디폴트 인수를 사용하면 위의 주석으로 처리한 생성자 2개를 1개로 만들어 사용할 수 있다.
//	디폴트 인수는 부분적으로 사용할 수 없다. => 사용하지 않거나 모든 인수에 대해서 사용해야 한다.
//	디폴트 인수란 함수가 호출될 때 가인수로 데이터가 넘어오면 넘어온 데이터를 가지고 함수를 실행하고 가인수로 데이터가 넘어오지 않으면
//	"=" 뒤에 지정한 데이터를 가지고 함수를 실행한다. => "=" 뒤의 데이터를 디폴트 인수라 부른다.
	Score(int no = 0, const char name[11] = "무명씨", int cpp = 0, int java = 0, int jsp = 0) {
		this->no = no;
		strcpy_s(this->name, name);
		this->cpp = cpp;
		this->java = java;
		this->jsp = jsp;
		total = cpp + java + jsp;
		average = (double)total / 3;
	}


	void toString() {
		cout << name << "님의 평균 점수는 " << average << "점 입니다." << endl;
	}
};

void main() {

	Score score1;
	score1.toString();
	Score* score2 = new Score();
	score2->toString();

	Score score3(1, "홍길동", 100, 100, 99);
	score3.toString();
	Score* score4 = new Score(2, "임꺽정", 54, 71, 68);
	score4->toString();

	delete score2;
	delete score4;

}