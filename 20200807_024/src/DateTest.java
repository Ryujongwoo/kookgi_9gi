import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
//		컴퓨터 시스템의 날짜와 시간을 얻어온다.
		Date date = new Date();
		System.out.println(date);
		
//		Calendar 클래스는 singleton 방식으로 제작된 클래스라 new를 사용할 수 없으므로 getInstance() 메소드로 날짜와 시간을 얻어온다.
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.getTime());
		
//		currentTimeMillis() : 1970년 1월 1일 자정부터 이 메소드가 실행되는 순간까지 지난 시간을 밀리초(1/1000) 단위로 얻어온다.
		System.out.println(System.currentTimeMillis());
//		int time = System.currentTimeMillis();		// 에러 발생
//		currentTimeMillis() 메소드로 얻어오는 시간은 13자리의 정수이기 때문에 int형 변수가 아닌 long형 변수에 저장시켜야 한다.
		long time = System.currentTimeMillis();
		System.out.println(time);
		System.out.println("====================================================================");
		
//		날짜 및 시간의 출력 서식 지정 방법 => 서식 문자를 제외한 나머지 문자는 입력한 그대로 출력된다.
//		SimpleDateFormat sdf = new SimpleDateFormat("날짜 및 시간 서식");
//		날짜 서식 적용 방법
//		sdf.format(날짜 데이터) => format() 실행 결과는 문자열로 변경된다.
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일(E) a hh시 mm분 ss초");
		System.out.println(sdf1.format(date));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E) HH:mm:ss.SSS");
		System.out.println(sdf2.format(calendar.getTime()));
		System.out.println(sdf2.format(time));
		
		
	}
	
}
















