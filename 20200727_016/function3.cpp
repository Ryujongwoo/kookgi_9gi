#include "config.h"
#include "func.h"

void main() {

	printf("1 ~ 100의 합계 : %d\n", total());
	printf("1 ~ 100의 합계 : %d\n", total());

	int n;
	cout << "n : ";
	cin >> n;
	cout << "1 ~ " << n << "의 합계 : " << total(n) << endl;
	printf("실인수 n : %d\n", n);

	int x, y;
	cout << "x, y : ";
	cin >> x >> y;
	cout << x << " ~ " << y << "의 합계 : " << total(x, y) << endl;

}

