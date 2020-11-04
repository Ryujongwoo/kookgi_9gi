<%@page import="com.koreait.service.CategoryService"%>
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
%>

<jsp:useBean id="vo" class="com.koreait.category.CategoryVO">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>

<%
//	categoryView.jsp에서 넘겨받은 메인 카테고리를 테이블에 저장하는 메소드를 호출한다.
	CategoryService.getInstance().insert(vo);
//	메인 카테고리를 저장했으므로 화면에 출력할 카테고리 목록을 얻어오는 페이지(list.jsp)로 넘겨준다.
	response.sendRedirect("list.jsp");
%>

</body>
</html>