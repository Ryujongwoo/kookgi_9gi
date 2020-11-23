package com.koreait.springMVCSample2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//	@Controller 어노테이션이 붙여진 클래스가 컨트롤러로 사용된다.
//	@Controller 어노테이션이 붙어있다 하더라도 모든 클래스가 컨트롤러로 사용되는 것이 아니고 servlet-context.xml 파일에 프로젝트를 생성할 때
//	입력한 이름으로 자동으로 생성된 base-package로 지정된 패키지의 @Controller 어노테이션이 붙여진 클래스만 컨트롤러로 사용할 수 있다.
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@RequestMapping 어노테이션의 method 속성에 RequestMethod.GET을 지정하면 get 방식의 요청을 처리하고 RequestMethod.POST를 쓰면 post 방식의
//	요청을 처리한다. => RequestMethod.GET 일 때 post 방식의 요청이 들어오거나 RequestMethod.POST 일 때 get 방식의 요청이 들어오면 405 에러가
//	발생된다.
//	@RequestMapping(value = "/", method = RequestMethod.POST)
	
//	method 속성을 생략하면 get 방식과 post 방식을 구분하지 않고 모두 처리할 수 있다.
//	@RequestMapping(value = "/")
	
//	method 속성을 생략하면 value 속성만 남는다. 이럴 경우 value 속성도 생략할 수 있다.
//	home 메소드는 주소 창에 context 이름(base-package가 A.B.C 형태로 만들어 질 때 C에 해당되는 내용) 다음에 "/"가 요청되는 경우 자동으로
//	실행되는 메소드로 필요한 작업을 하고 view 페이지 이름을 리턴시킨다.
//	view 페이지 이름은 문자열이므로 메소드의 리턴 타입은 반드시 String으로 해야 하고 view 페이지의 앞, 뒤에 자동으로 붙여주는 내용은
//	servlet-context.xml 파일에서 InternalResourceViewResolver 클래스의 bean 에서 처리한다.
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/hello")
	public String hello(Locale locale, Model model) {
		return "hello";
	}
	
}






