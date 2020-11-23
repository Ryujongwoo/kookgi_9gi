package com.koreait.springMVCController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//	클라이언트로 부터 서비스 요청이 들어왔을 때 컨트롤러로 진입하게 되고 컨트롤러는 요청에 따른 작업을 실행한 후 뷰 페이지로 데이터를 전달한다.

//	컨트롤러 제작 순서
//	1. base-package로 지정된 패키지에 임의의 이름으로 클래스를 만들고 @Controller 어노테이션을 붙여서 컨트롤러로 사용할 클래스임을 스프링에게
//	   알려준다.
//	2. @RequestMapping 어노테이션의 인수로 클라이언트에서 넘어오는 처리할 요청을 지정한다.
//	3. 요청을 처리할 임의의 이름의 메소드를 만든다. => 뷰 페이지 이름은 문자열이므로 메소드의 리턴 타입은 String으로 지정한다.
//	4. 작성한 메소드에서 필요한 작업을 완료한 후 뷰 페이지(jsp 파일)의 이름을 리턴시킨다.

@Controller
public class MyController {

	@RequestMapping("/view")	// 클라이언트로 부터 넘어오는 서비스 요청
	public String view() {
		System.out.println("MyController의 view() 메소드 실행");
//		"/WEB-INF/views/" + "view" + ".jsp" => "/WEB-INF/views/view.jsp"
		return "view";			// 뷰 페이지 이름
	}
	
	@RequestMapping("/model")
//	@RequestMapping 어노테이션이 설정된 메소드는 Model 인터페이스 객체를 인수로 가질 수 있다.
//	Model 인터페이스 객체는 컨트롤러에서 뷰 페이지로 넘겨줄 데이터를 보관한다. => jsp의 response와 같은 역할을 한다.
	public String model(Model model) {
		System.out.println("MyController의 model() 메소드 실행");
		
//		addAttribute(key, value) : Model 인터페이스 객체에 key에 따른 value를 넣어준다.
		model.addAttribute("id", "asdfg");
		model.addAttribute("pw", "12345");
		model.addAttribute("name", "홍길동");
		
//		"/WEB-INF/views/" + "model/model" + ".jsp" => "/WEB-INF/views/model/model.jsp"
		return "model/model";
	}
	
	
	@RequestMapping("/modelAndView")
//	ModelAndView 클래스 객체는 컨트롤러에서 뷰 페이지 이름과 뷰 페이지로 넘겨줄 데이터를 저장한다.
//	뷰 페이지 이름과 뷰 페이지로 넘겨줄 데이터를 ModelAndView 클래스 객체에 저장해서 리턴시켜야 하므로 리턴 타입은 ModelAndView를 사용한다.
	public ModelAndView modelAndView(Model model) {
		System.out.println("MyController의 modelAndView() 메소드 실행");
//		뷰 페이지로 넘겨줄 데이터와 뷰 페이지 이름을 저장할 ModelAndView 클래스 객체를 선얺나다.
		ModelAndView modelAndView = new ModelAndView();
//		addObject(key, value) : ModelAndView 클래스 객체에 key에 따른 value를 넣어준다. => 뷰 페이지로 넘겨줄 데이터를 저장한다.
		modelAndView.addObject("id", "qwert");
		modelAndView.addObject("pw", "67890");
		modelAndView.addObject("name", "임꺽정");
//		setViewName() : ModelAndView 클래스 객체에 뷰 페이지 이름을 넣어준다.
		modelAndView.setViewName("modelAndView/modelAndView");
//		뷰 페이지로 넘겨줄 데이터와 뷰 페이지 이름이 저장된 modelAndView 클래스 객체를 리턴한다.
		return modelAndView;
	}
	
}
