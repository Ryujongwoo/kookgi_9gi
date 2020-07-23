#include "config.h"

void main() {

	int d[] = { 21, 1, 19, 10, 5, 39, 4, 74, 64, 99 };
//	left  => 왼쪽에서 오른쪽으로 비교할 때 정렬하기 위한 비교를 시작하는 위치
//	right => 오른쪽에서 왼쪽으로 비교할 때 정렬하기 위한 비교를 시작하는 위치
//	shift => 마지막으로 값 교환이 실행된 위치 => 중요....
	int left = 0, right = 9, shift, i;

	while (left < right) {

//		왼쪽에서 오른쪽으로 비교하며 정렬시킨다.
		i = left;
		while (i < right) {
			if (d[i] > d[i + 1]) {
				swap(d[i], d[i + 1]);
				shift = i;
			}
			i++;
		}
		right = shift;

//		오른쪽에서 왼쪽으로 비교하며 정렬한다.
		i = right;
		while (i > left) {
			if (d[i - 1] > d[i]) {
				swap(d[i - 1], d[i]);
				shift = i;
			}
			i--;
		}
		left = shift;

	}

	printf("정렬 결과 : ");
	for (int i = 0; i < 10; i++) {
		printf("%d ", d[i]);
	}
	printf("\n");

}