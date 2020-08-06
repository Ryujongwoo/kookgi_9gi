
public class PrintTest {

	public static void main(String[] args) {
		
//		서식 없는 출력
//		System.out.println() => 괄호 안의 내용을 출력하고 줄을 바꾼다.
//		System.out.print()   => 괄호 안의 내용을 출력하고 줄을 바꾸지 않는다.
		System.out.print("안녕 \n자바");
		System.out.println("안녕 자바");
		System.out.println("안녕 자바");
		
//		cout << "5 + 3 = " << 5 + 3 << endl;
//		"+" 연산자는 양쪽 데이터가 모두 숫자일 경우에만 덧셈을 하고 한쪽이라도 문자열이면 문자열끼리 연결하는 문자열 연결 연산자로 사용된다.		
		System.out.println("5 + 3 = " + (5 + 3));
		System.out.println("5 - 3 = " + (5 - 3));
		System.out.println("5 * 3 = " + 5 * 3);
		System.out.println("5 / 3 = " + 5 / 3);
		System.out.println("5 / 3 = " + 5 / 3.);
		System.out.println("5 / 3 = " + (double) 5 / 3);
		System.out.println("5 % 3 = " + 5 % 3);
		System.out.println("===================================");
		
//		서식 있는 출력 => 사용 방법은 c/c++과 같다. => JDK 1.5에서 추가
//		System.out.printf("서식 문자", 출력할 데이터);
		System.out.printf("%d + %d = %d\n", 5, 3, 5 + 3);
		System.out.printf("%d - %d = %d\n", 5, 3, 5 - 3);
		System.out.printf("%d * %d = %d\n", 5, 3, 5 * 3);
		System.out.printf("%d / %d = %d\n", 5, 3, 5 / 3);
		System.out.printf("%d / %d = %f\n", 5, 3, 5 / 3.);
		System.out.printf("%d / %d = %f\n", 5, 3, (double) 5 / 3);
		System.out.printf("%d %% %d = %d\n", 5, 3, 5 % 3);
		System.out.println("===================================");
		
//		자바가 printf() 메소드를 지원하지 않을 때 사용하는 서식있는 출력 => String.format("서식 문자", 출력할 데이터)
		System.out.println(String.format("%d + %d = %d\n", 5, 3, 5 + 3));
		
	}
	
}
















