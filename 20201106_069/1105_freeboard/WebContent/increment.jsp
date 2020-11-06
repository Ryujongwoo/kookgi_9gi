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
//	listView.jsp에서 넘어오는 조회수를 증가시킬 글번호와 메인글 내용 확인 후 돌아갈 페이지 번호를 받는다.
	int idx = Integer.parseInt(request.getParameter("idx"));
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	
//	조회수를 증가시키는 메소드를 호출한다.
	FreeboardService.getInstance().increment(idx);

//	조회수를 증가시킨 메인글 1건을 얻어오는 페이지(selectByIdx.jsp)로 넘겨준다.
	response.sendRedirect("selectByIdx.jsp?idx=" + idx + "&currentPage=" + currentPage + "&job=contentView");
//	pageContext.forward("selectByIdx.jsp?idx=" + idx + "&currentPage=" + currentPage + "&job=contentView");
%>

</body>
</html>