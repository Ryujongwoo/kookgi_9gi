
public class ArrayTest {

	public static void main(String[] args) {
		
//		자바는 변수를 선언만 하고 초기화 시키지 않으면 자동 초기화가 된다.
//		숫자는 0, 문자는 공백, boolean은 false로 자동 초기화되고 클래스로 선언한 객체는 null로 초기화 된다.
//		자료형[] 배열이름 = new 자료형[첨자];		// 배열만 선언한다.
//		자료형 배열이름[] = new 자료형[첨자];
	
		String[] data = new String[5];
		
//		배열이름.length => 배열의 크기를 얻어온다.
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "] = " + data[i]);
		}
		System.out.println("====================================================================");
		
//		자료형[] 배열이름 = { 초기치 };			// 배열이 초기치의 개수 만큼 선언되고 초기치로 초기화 된다.
		int[] score = {100, 85, 74, 96, 51};
		for (int i = 0; i < score.length; i++) {
			System.out.println("score[" + i + "] = " + score[i]);
		}
		
		
		
	}
	
}
