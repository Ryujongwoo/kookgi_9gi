<%@page import="com.koreait.vo.FreeboardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.koreait.vo.FreeboardList"%>
<%@page import="com.koreait.service.FreeboardService"%>
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
//	이전 페이지에서 넘어오는 화면에 표시할 페이지 번호를 받는다.
	int currentPage = 1;
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	} catch (NumberFormatException e) { }

	FreeboardService service = FreeboardService.getInstance();
	
//	공지글을 얻어온다.
	ArrayList<FreeboardVO> notice = service.selectNotice();

//	1페이지 분량의 메인글을 얻어온다.
	FreeboardList freeboardList = service.selectList(currentPage);

//	공지글과 메인글을 글 목록을 request 영역에 저장한 후 메인글을 화면에 표시하는 페이지로 넘겨준다.
	request.setAttribute("freeboardList", freeboardList);
	pageContext.forward("listView.jsp");
%>

</body>
</html>









