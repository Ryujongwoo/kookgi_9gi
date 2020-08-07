import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
//		Math.random() => 0 이상이고 1 미만인 난수를 발생시킨다.
		for (int i = 0; i < 10; i++) {
			System.out.println((int) (Math.random() * 6) + 1);
		}
		System.out.println("====================================================================");
		
		Random random = new Random();
		
//		random.next자료형() => 지정된 자료형의 난수를 발생시킨다.
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(6) + 1);
		}
		
	}
	
}
