<%@page import="com.koreait.service.SelectService"%>
<%@page import="com.koreait.vo.GuestbookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--
	currentPage를 넘겨받아 currentPage에 해당되는 1페이지 분량의 글 목록을 테이블에서 얻어와서 request 영역에 저장한 후 1페이지 분량의
	글을 브라우저 화면에 표시하는 페이지(listView.jsp)로 넘겨준다.
-->

<%
	request.setCharacterEncoding("UTF-8");
//	이전 페이지에서 넘어오는 화면에 표시할 페이지 번호(currentPage)를 받는다.
//	게시판이 최초로 실행될 때, insertOK.jsp에서 list.jsp가 호출될 때는 currentPage가 넘어오지 않는다. => null 이다.
//	null은 parseInt() 메소드를 실행했을 때 NumberFormatException이 발생되므로 반드시 예외 처리를 해야한다.
//	이전 페이지에서 넘어오는 currentPage가 없으면 currentPage를 1로 초기화 시켜서 사용하고 넘어오는 currentPage가 있으면 넘어온 currentPage
//	값으로 초기화 시켜서 사용한다.
	int currentPage = 1;
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	} catch (NumberFormatException e) { }
	
//	1페이지 분량의 글 목록과 페이지 작업에 사용할 8개의 변수가 초기화된 객체를 request 영역에 저장한다.
	GuestbookList guestbookList = SelectService.getInstance().selectList(currentPage);
	request.setAttribute("guestbookList", guestbookList);

//	글을 입력할 때 엔터키를 눌러 줄을 바꿔서 입력한 경우 브라우저에 <br/> 태그로 바꿔 출력하기 위해 request 영역에 "\r\n"를 저장한다.
	request.setAttribute("enter", "\r\n");

//	request 영역에 저장된 데이터를 가지고 브라우저에 글을 출력하는 페이지(listView.jsp)로 넘겨준다.
	pageContext.forward("listView.jsp");
%>

</body>
</html>














