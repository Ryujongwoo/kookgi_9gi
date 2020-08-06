import java.util.Scanner;

public class StringMethod {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = scanner.nextLine();
//		스캐너로 입력받을 때 아래와 같이 trim() 메소드를 실행하면 데이터를 입력받자마자 불필요한 빈 칸을 제거한 후 변수에 저장한다.
//		String str = scanner.nextLine().trim();
		
//		length() : 문자열의 개수를 센다.
		System.out.println("글자수 : " + str.length());
//		trim() : 문자열 앞, 뒤의 불필요한 빈 칸을 제거한다.
		System.out.println("문자열 앞, 뒤의 불필요한 빈 칸을 제거한 글자수 : " + str.trim().length());
//		toUpperCase()는 영문자를 무조건 대문자로 변환하고 toLowerCase()는 영문자를 무조건 소문자로 변환한다.
		System.out.println("무조건 대문자로 : " + str.toUpperCase());
		System.out.println("무조건 소문자로 : " + str.toLowerCase());
//		charAt(index) : 문자열에서 지정된 index 번째 위치의 문자를 얻어온다. => index는 0부터 시작한다.
		System.out.println("6번째 문자 : " + str.charAt(5));
		
//		키보드로 1문자만 입력받기
//		char ch = scanner.nextLine().charAt(0);
		
//		substring(a)    => 문자열의 a번째 문자부터 끝까지 얻어온다.
//		substring(a, b) => 문자열의 a번째 문자부터 b - 1 번째 문자까지 얻어온다.
		System.out.println(str.substring(3));
		System.out.println(str.substring(3, 6));
		
//		indexOf()     => 문자열의 왼쪽부터 검색해서 인수로 지정된 문자열이 최초로 나타나는 위치를 얻어온다.
//		lastIndexOf() => 문자열의 오른쪽부터 검색해서 인수로 지정된 문자열이 최초로 나타나는 위치를 얻어온다.
		System.out.println(str.indexOf("it"));
		System.out.println(str.lastIndexOf("it"));
//		indexOf(), lastIndexOf() 메소드는 인수로 지정된 문자열이 포함되지 않았으면 -1을 리턴한다. => 실행 결과가 -1이면 인수로 지정한 문자열이
//		포함되지 않았음을 의미한다.
		System.out.println(str.indexOf("It"));
		System.out.println(str.lastIndexOf("It"));
		
//		contains() : 문자열에 인수로 지정된 문자열이 포함되어 있으면 true, 없으면 false를 리턴한다.
		System.out.println(str.contains("it"));
		System.out.println(str.contains("It"));
		
//		matches() : 문자열이 인수로 지정된 문자열과 완전히 일치하면 true, 일치하지 않으면 false를 리턴한다.
		System.out.println(str.matches("itkoreait"));
		System.out.println(str.matches("koreait"));
		
	}
	
}
















