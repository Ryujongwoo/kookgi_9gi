<%@page import="com.koreait.service.FreeboardService"%>
<%@page import="com.koreait.vo.FreeboardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
//	increment.jsp와 contentView.jsp에서 넘어오는 브라우저에 표시할 메인글의 글번호와 메인글 내용 확인 후 돌아갈 페이지 번호를 받는다.
	int idx = Integer.parseInt(request.getParameter("idx"));
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
//	메인글 1건을 얻어온 후 분기할 페이지 이름(job)을 받는다.
	String job = request.getParameter("job");

//	메인글 1건을 얻어오는 메소드를 호출한다.
	FreeboardVO vo = FreeboardService.getInstance().selectByIdx(idx);
//	out.println(vo);

//	브라우저에 출력할 메인글이 저장된 객체, 작업 후 돌아갈 페이지 번호, 줄바꿈에 사용할 이스케이프 시퀀스(\r\n)를 request 영역에 저장한다.
	request.setAttribute("vo", vo);
	request.setAttribute("currentPage", currentPage);
	request.setAttribute("enter", "\r\n");

//	댓글 목록을 얻어온다.
	

//	테이블에서 얻어온 글 1건을 request 영역에 저장한 후 아래의 작업이 실행된다.
//	increment.jsp에서 넘어온 경우 조회수를 증가시킨 메인글 1건을 브라우저에 보여주는 페이지(contentView.jsp)로 넘겨준다.
//	contentView.jsp에서 넘어온 경우 수정 또는 삭제할 글 1건을 브라우저에 보여주는 페이지(update.jsp, delete.jsp)로 넘겨준다.
	pageContext.forward(job + ".jsp");
%>

</body>
</html>





