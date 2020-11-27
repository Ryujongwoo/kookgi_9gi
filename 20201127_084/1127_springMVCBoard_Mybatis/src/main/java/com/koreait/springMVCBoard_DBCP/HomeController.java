package com.koreait.springMVCBoard_DBCP;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.dao.MybatisDAO;
import com.koreait.service.ContentViewService;
import com.koreait.service.DeleteService;
import com.koreait.service.IncrementService;
import com.koreait.service.InsertService;
import com.koreait.service.MvcboardService;
import com.koreait.service.ReplyService;
import com.koreait.service.SelectService;
import com.koreait.service.UpdateService;

@Controller
public class HomeController {
	
//	servlet-context.xml 파일에서 생성한 mybatis bean을 사용하기 위해 SqlSession 인터페이스 타입의 객체를 선언한다.
//	servlet-context.xml 파일에서 생성한 mybatis bean을 자동으로 읽어와서 SqlSession 인터페이스 타입의 객체에 넣어주도록 하기 위해서
//	@Autowired 어노테이션을 붙여준다.
	@Autowired
	public SqlSession sqlSession;
		
//	=====================================================================================================================================
//	mybatis로 변환이 완료되면 DBCP Template에 사용한 코드는 주석으로 처리한다.
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		Constant.jdbcTemplate = jdbcTemplate;
	}
//	=====================================================================================================================================
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		System.out.println("프로젝트가 실행될 때 최초 요청을 받는 메소드");
		return "redirect:list";
	}

	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 insert() 메소드 실행");
		return "insert";
	}
	
	@RequestMapping("/insertOK")
	public String insertOK(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 insertOK() 메소드 실행 - Model 인터페이스 객체 사용");
		model.addAttribute("request", request);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("insert", InsertService.class);
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 list() 메소드 실행");
		
//		model.addAttribute("request", request);
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("select", SelectService.class);
//		service.execute(model);
		
//		mapper를 얻어온다.
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
//		브라우저 화면에 출력할 글의 개수를 정한다.
		int pageSize = 10;
//		HttpServletRequest 인터페이스 객체에 저장되서 넘어오는 화면에 표시할 페이지 번호를 받는다.
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) { }		
//		테이블에 저정된 전체 글의 개수를 얻어온다.
		int totalCount = mapper.selectCount();
//		System.out.println(totalCount);
		
		return "list";
	}
	
	@RequestMapping("/increment")
	public String increment(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 increment() 메소드 실행");
		model.addAttribute("request", request);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("increment", IncrementService.class);
		service.execute(model);
		int idx = Integer.parseInt(request.getParameter("idx"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		model.addAttribute("idx", idx);
		model.addAttribute("currentPage", currentPage);
		return "redirect:contentView";
	}
	
	@RequestMapping("/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 contentView() 메소드 실행");
		model.addAttribute("request", request);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
		service.execute(model);
		return "contentView";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 delete() 메소드 실행");
		model.addAttribute("request", request);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("delete", DeleteService.class);
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 update() 메소드 실행");
		model.addAttribute("request", request);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("update", UpdateService.class);
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 reply() 메소드 실행");
		model.addAttribute("request", request);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
		service.execute(model);
		return "reply";
	}
	
	@RequestMapping("/replyInsert")
	public String replyInsert(HttpServletRequest request, Model model) {
		System.out.println("컨트롤러의 replyInsert() 메소드 실행");
		model.addAttribute("request", request);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("reply", ReplyService.class);
		service.execute(model);
		return "redirect:list";
	}
	
}

















