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
//	삭제한 카테고리 이름을 삭제 완료 메시지에 표시하기 위해 삭제할 카테고리 한 건을 테이블에서 얻어온다.
	CategoryVO original = service.selectByIdx(vo.getIdx());
//	out.println(original);

//	1. 삭제 버튼이 클릭되면 해당 카테고리를 테이블에서 삭제한다.
	service.delete(vo.getIdx());

	out.println("<script>");
	out.println("alert('" + original.getCategory() + " 카테고리 삭제완료!!')");
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>

</body>
</html>