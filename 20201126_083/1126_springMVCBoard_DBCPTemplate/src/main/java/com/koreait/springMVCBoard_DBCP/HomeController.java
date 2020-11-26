package com.koreait.springMVCBoard_DBCP;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.service.ContentViewService;
import com.koreait.service.DeleteService;
import com.koreait.service.IncrementService;
import com.koreait.service.InsertService;
import com.koreait.service.MvcboardService;
import com.koreait.service.ReplyService;
import com.koreait.service.SelectService;
import com.koreait.service.UpdateService;
import com.koreait.vo.MvcboardVO;

@Controller
public class HomeController {
	
//	JdbcTemplate을 사용하려면 setvlet-context.xml 파일에서 프로젝트가 시작될 때 DriverManagerDataSource 클래스의 bean을 이용해 생성한
//	데이터베이스 연결 정보(dataSource)를 참조해서 생성한 JdbcTemplate 클래스의 bean template을 JdbcTemplate 타입의 멤버 변수를 선언하고
//	넣어줘야 한다.
	private JdbcTemplate jdbcTemplate;
	
//	JdbcTemplate 클래스 타입의 객체를 선언한 후 getter, setter를 만든다. => 사실... getter는 안만들어도 상관없다.
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
//	프로젝트가 실행될 때 자동으로 JdbcTemplate 클래스 객체의 setter 메소드가 실행되게 하기 위해서 @Autowired 어노테이션을 붙여준다.
//	@Autowired 어노테이션이 붙어있는 메소드의 인수로 스프링이 setvlet-context.xml 파일에서 생성한 JdbcTemplate 클래스의 bean을 자동으로
//	받아서 setter 메소드의 인수로 전달하고 멤버로 선언된 JdbcTemplate 클래스 객체를 초기화 시킨다.
	@Autowired		// @Autowired 어노테이션을 붙여준 메소드는 프로젝트가 시작될 때 자동으로 실행된다.
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
//		System.out.println("꺄오~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		System.out.println(jdbcTemplate);
//		여기까지 실행되면 컨트롤러에서 DBCP Template을 사용할 수 있다.
//		데이터베이스와 연결은 주로 DAO 클래스에서 사용하므로 컨트롤러 이외의 클래스에서 DBCP Template을 사용할 수 있게 하기 위해서 적당한
//		이름의 패키지에 적당한 이름으로 클래스를 만들고 선언한 정적 변수에 setvlet-context.xml 파일에서 생성된 JdbcTemplate 클래스의 
//		bean을 넣어준다.
		Constant.jdbcTemplate = jdbcTemplate;
	}
	
//	=====================================================================================================================================
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		System.out.println("컨트롤러의 home() 메소드 실행");
		return "redirect:list";
	}

	//	글 입력폼(insert.jsp)을 호출하는 메소드
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 insert() 메소드 실행");
		return "insert";
	}
	
//	입력 폼에 입력된 데이터를 테이블에 저장하고 브라우저에 출력할 1페이지 분량의 글을 얻어오는 컨트롤러의 메소드를 호출한다.
	@RequestMapping("/insertOK")
	public String insertOK(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 insertOK() 메소드 실행 - Model 인터페이스 객체 사용");
	
//		insert.jsp에서 입력한 데이터가 저장된 request 객체를 Model 인터페이스 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("insert", InsertService.class);
		service.execute(model);
		
//		메인글을 저장했으므로 1페이지 분량의 글을 얻어오는 요청을 하기 위해 redirect 기능을 사용해 @RequestMapping("/list") 어노테이션이 
//		설정된 컨트롤러 내부의 메소드를 호출한다.
		return "redirect:list";
	}
	
//	브라우저에 출력할 1페이지 분량의 글을 얻어오고 1페이지 분량의 글을 브라우저에 출력하는 페이지를 호출하는 메소드
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 list() 메소드 실행");
		
//		컨트롤러에게 list로 요청하는 페이지에서 넘어오는 브라우저에 표시할 페이지 번호가 저장된 request 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("select", SelectService.class);
		service.execute(model);
		
		return "list";
	}
	
//	조회수를 증가시키는 메소드
	@RequestMapping("/increment")
	public String increment(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 increment() 메소드 실행");
	
//		조회수를 증가시킬 글번호가 저장된 request 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("increment", IncrementService.class);
		service.execute(model);
		
//		조회수를 증가시킨 글(브라우저에 표시할 글)번호와 작업 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 저장한다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		model.addAttribute("idx", idx);
		model.addAttribute("currentPage", currentPage);
		
		return "redirect:contentView";
	}
	
//	조회수를 증가시킨 1건을 브라우저에 출력하기 위해 테이블에서 얻어오는 메소드
	@RequestMapping("/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 contentView() 메소드 실행");

//		조회수를 증가시킨 글번호와 작업 후 돌아갈 페이지 번호가 저장된 request 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
		service.execute(model);

		return "contentView";
	}

//	글 1건을 삭제하는 메소드
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 delete() 메소드 실행");
		
//		삭제할 글번호와 삭제 후 돌아갈 페이지 번호가 저장된 request 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("delete", DeleteService.class);
		service.execute(model);

		return "redirect:list";
	}
	
//	글 1건을 수정하는 메소드
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 update() 메소드 실행");
	
//		수정할 글번호와 데이터, 수정 후 돌아갈 페이지 번호가 저장된 request 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("update", UpdateService.class);
		service.execute(model);
		
		return "redirect:list";
	}
	
//	답글을 입력하기 위해서 브라우저 화면에 출력할 메인글을 얻어오고 답글을 입력하는 페이지를 호출하는 메소드
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 reply() 메소드 실행");
		
//		답변을 입력할 원본 글의 글번호와 작업 후 돌아갈 페이지 번호가 저장된 request 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
		service.execute(model);

		return "reply";
	}
	
//	답글을 위치에 맞게 저장하는 메소드
	@RequestMapping("/replyInsert")
	public String replyInsert(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 replyInsert() 메소드 실행");
		
//		답변할 원본 글번호, 글그룹, 글레벨, 같은 글 그룹에서 글 출력 순서, 답글 작성자 이름, 답글 제목, 답글 내용, 답글을 저장하고 돌아갈
//		페이지 번호가 저장된 request 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("reply", ReplyService.class);
		service.execute(model);
		
		return "redirect:list";
	}
	
}

















