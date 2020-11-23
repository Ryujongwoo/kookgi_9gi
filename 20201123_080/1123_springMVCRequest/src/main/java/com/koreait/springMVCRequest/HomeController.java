package com.koreait.springMVCRequest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/memberView")
	public String memberView(HttpServletRequest request, Model model) {
		System.out.println("HomeController의 memberView() 메소드");
//		뷰 페이지에서 컨트롤러로 넘어와 HttpServletRequest 인테페이스 객체에 저장된 데이터를 받는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : " + id + ", pw : " + pw);
//		컨트롤러에서 뷰 페이지로 넘겨줄 데이터를 Model 인터페이스 객체에 저장한다.
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "memberView";
	}
	
	@RequestMapping("/memberLogin")
//	@RequestParam("뷰 페이지에서 컨트롤러로 넘어오는 변수명") 자료형 넘어온 데이터를 저장할 변수명
//	@RequestParam("id") String id => String id = request.getparameter("id")와 같은 기능이 실행된다.
//	HttpServletRequest 인터페이스 객체로 뷰 페이지에서 넘어오는 데이터를 받을 때는 데이터가 넘어오지 않아도 에러가 발생되지 않지만
//	@RequestParam 어노테이션을 이용해서 뷰 페이지에서 넘어오는 데이터를 받을 때는 뷰 페이지에서 데이터가 넘어오지 않으면 400 에러가 발생된다.
	public String memberLogin(/*HttpServletRequest request,*/ Model model, @RequestParam("id") String id, @RequestParam("pw") String pw) {
		System.out.println("HomeController의 memberLogin() 메소드");
		System.out.println("id : " + id + ", pw : " + pw);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "memberLogin";
	}
	
	@RequestMapping("/member")
	public String member(HttpServletRequest request, Model model) {
		System.out.println("HomeController의 member() 메소드");
		return "member";
	}
	
	/*
	@RequestMapping("/memberInsert")
	public String memberInsert(HttpServletRequest request, Model model) {
		System.out.println("HomeController의 memberInsert() 메소드");
		
//		뷰 페이지에서 컨트롤러로 넘어와 HttpServletRequest 인터페이스 객체에 저장된 데이터를 받는다.
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
//		VO 클래스의 객체를 만들고 setter 메소드로 데이터를 넣어준다.
//		MemberVO vo = new MemberVO();
		
//		VO 클래스의 bean을 얻어오고 setter 메소드로 데이터를 넣어준다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MemberVO vo = ctx.getBean("vo", MemberVO.class);
		vo.setName(name);
		vo.setId(id);
		vo.setPassword(password);
		vo.setEmail(email);
//		System.out.println(vo);
		
//		memberInsert.jsp로 VO 클래스 객체를 넘겨주기 위해 Model 인터페이스 객체에 저장한다.
		model.addAttribute("vo", vo);
		
		return "memberInsert";
	}
	*/
	
	/*
	@RequestMapping("/memberInsert")
//	커맨드(데이터) 객체 사용하기
//	뷰 페이지에서 컨트롤러로 넘어오는 데이터를 클래스 객체에 저장하려는 경우 커맨드 객체를 사용하면 편리하다.
//	커맨드 객체를 사용하면 HttpServletRequest 인터페이스 객체나 @RequestParam 어노테이션으로 넘겨받은 데이터를 받아서 클래스 객체에 setter
//	메소드로 저장한 다음 Model 인터페이스 객체에 넣어주는 동작이 일괄적으로 처리된다.
//	커맨드 객체의 이름은 반드시 커맨드 객체를 생성할 클래스 이름과 동일하게 작성해야 하고 첫 문자만 소문자로 바꿔 사용해야 한다.	
	public String memberInsert(HttpServletRequest request, Model model, MemberVO memberVO) {
		System.out.println("HomeController의 memberInsert() 메소드");
		return "memberInsert";
	}
	*/
	
	@RequestMapping("/memberInsert")
//	커맨드 객체의 이름이 너무 길어서 사용하기 불편하거나 뷰 페이지로 넘겨주는 커맨드 객체의 이름을 별도로 지정해서 사용하려면 @ModelAttribute
//	어노테이션을 이용해 뷰 페이지로 넘겨주는 커맨드 객체의 이름을 변경할 수 있다.
//	이 경우 기존 커맨드 객체 이름은 사용할 수 없고 @ModelAttribute 어노테이션으로 지정한 커맨드 객체 이름을 사용해야 한다.
	public String memberInsert(HttpServletRequest request, Model model, @ModelAttribute("vo") MemberVO memberVO) {
		System.out.println("HomeController의 memberInsert() 메소드");
		return "memberInsert";
	}
	
}






