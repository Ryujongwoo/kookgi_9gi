
public class VarArgsMethodTest {

//	[접근 권한 지정자] [static] 리턴타입 메소드이름([인수, ...]) {
//		메소드가 실행할 문장;
//		...;
//		[return 값;]
//	}
	
//	접근 권한 지정자 => 접근 권한 지정자를 생략하면 package 권한이 기본값으로 사용된다. => 예전에는 package 권한을 default라고 불렀었다.
//	private   : 클래스 외부에서 접근할 수 없다.
//	protected : 현재 클래스와 현재 클래스를 상속받은 자식 클래스에서만 접근할 수 있다.
//	package   : 같은 패키지에서는 public 처럼 사용되고 다른 패키지에서는 private 처럼 사용된다.
//	public    : 모든 클래스에서 자유롭게 접근할 수 있다.
	
//	정적(static) 메소드
//	static을 붙여서 선언한 메소드는 메소드를 선언한 클래스의 객체를 생성하지 않고 클래스 이름에 "."을 찍어서 바로 접근할 수 있다.
//	자주 사용하는 메소드는 static 메소드로 만들어 사용하면 편리하다.
//	static 메소드는 static 메소드 또는 static 멤버 변수에만 접근 할 수 있다.
	
	public static void main(String[] args) {
		
//		같은 기능을 실행하는 메소드 인수의 개수가 서로 다를 경우 많은 수의 메소드 오버로딩이 필요하다.
		System.out.println("sum(1, 2) = " + sum(1, 2));
		System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
		System.out.println("sum(1, 2, 3, 4) = " + sum(1, 2, 3, 4));
		System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));
		
//		메소드의 인수를 배열로 구현하면 많은 수의 오버로딩이 필요가 없지만 인수를 배열로 선언하고 선언한 배열에 초기치를 입력해서 메소드로
//		전달해야 하는 번거로움이 있다.
		System.out.println("sum(1, 2) = " + sum(new int[] {1, 2}));
		System.out.println("sum(1, 2, 3) = " + sum(new int[] {1, 2, 3}));
		System.out.println("sum(1, 2, 3, 4) = " + sum(new int[] {1, 2, 3, 4}));
		System.out.println("sum(1, 2, 3, 4, 5) = " + sum(new int[] {1, 2, 3, 4, 5}));
		
//		위 2가지 방법의 단점을 해결하는 가장 좋은 방법은 인수를 가변 인수로 만들어 사용하는 방법이다.
		System.out.println("total(1, 2, 3, 4, 5, 6, 7, 8, 9) = " + total(1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println("total(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15) = " + 
											total(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
		
	}

//	메소드 오버로딩 => 같은 이름의 메소드가 여러개 나올 수 있다.
//	메소드의 이름이 같으면 인수의 개수로 구별하고 인수의 개수도 같으면 인수의 데이터 타입으로 메소드를 구별한다.
	private static int sum(int i, int j) {
		return i + j;
	}
	private static int sum(int i, int j, int k) {
		return i + j + k;
	}
	private static int sum(int i, int j, int k, int l) {
		return i + j + k + l;
	}
	private static int sum(int i, int j, int k, int l, int m) {
		return i + j + k + l + m;
	}

//	위 4개의 메소드는 인수를 모두 변수로 받고있기 때문에 많은 수의 오버로딩이 필요했다.
//	인수를 배열로 받으면 많은 수의 오버로딩이 필요 없어진다.
	private static int sum(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
//	가변 인수를 사용하는 메소드 => 가변 인수는 자료형 뒤에 "..."을 쓰고 배열 이름을 입력하면 된다.
//	가변 인수는 인수 목록의 맨 마지막에 딱 한 번만 사용할 수 있다.
	private static int total(int ... data) {
		int sum = 0;
		for (int i : data) {
			sum += i;
		}
		return sum;
	}
	
}











