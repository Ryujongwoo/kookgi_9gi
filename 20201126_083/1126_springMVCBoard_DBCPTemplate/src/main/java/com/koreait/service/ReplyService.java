package com.koreait.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.koreait.dao.MvcboardDAO;
import com.koreait.vo.MvcboardVO;

public class ReplyService implements MvcboardService {

	@Override
	public void execute(Model model) {
		System.out.println("ReplyService 클래스의 execute() 메소드 실행");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

//		request 객체에서 넘어온 답변할 원본 글번호, 글그룹, 글레벨, 같은 글 그룹에서 글 출력 순서, 답글 작성자 이름, 답글 제목, 답글 내용을
//		받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int lev = Integer.parseInt(request.getParameter("lev"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
//		답글 데이터를 MvcboardVO 클래스에 저장한다.
		MvcboardVO mvcboardVO = ctx.getBean("mvcboardVO", MvcboardVO.class);
		mvcboardVO.setIdx(idx);
		mvcboardVO.setName(name);
		mvcboardVO.setSubject(subject);
		mvcboardVO.setContent(content);
		mvcboardVO.setRef(ref);
//		답글은 질문글 바로 아래에 위치해야 하므로 lev와 seq는 1씩 증가시켜 저장한다.
		mvcboardVO.setLev(lev + 1);
		mvcboardVO.setSeq(seq + 1);
		
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);
//		답글이 삽입될 위치를 정하기 위해 조건에 만족하는 seq를 1씩 증가시키는 메소드를 실행한다.
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("ref", mvcboardVO.getRef());
		hmap.put("seq", mvcboardVO.getSeq());
		mvcboardDAO.replyIncrement(hmap);

//		답글을 저장하는 메소드를 실행한다.
		mvcboardDAO.replyInsert(mvcboardVO);
		
//		답글 입력 작업 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 저장한다.
		model.addAttribute("currentPage", Integer.parseInt(request.getParameter("currentPage")));
	}

}














