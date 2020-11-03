<%@page import="com.koreait.category.CategoryVO"%>
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
	CategoryService service = CategoryService.getInstance();
//	신고할 카테고리 이름을 신고 완료 메시지에 표시하기 위해 신고할 카테고리 한 건을 테이블에서 얻어온다.
	CategoryVO original = service.selectByIdx(vo.getIdx());
//	out.println(original);

//	신고 버튼이 클릭되면 deleteReport 필드의 값을 1증가 시킨다.
	service.deleteReport(vo.getIdx());

	out.println("<script>");
	out.println("alert('" + original.getCategory() + " 카테고리 신고완료!!')");
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>

</body>
</html>







