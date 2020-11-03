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
//	수정한 카테고리 이름을 수정 완료 메시지에 표시하기 위해 수정할 카테고리 한 건을 테이블에서 얻어온다.
	CategoryVO original = service.selectByIdx(vo.getIdx());
//	out.println("original : " + original + "<br/>");
//	out.println("vo : " + vo + "<br/>");

//	수정 버튼이 클릭되면 해당 카테고리를 수정한다.
	service.update(vo);

	out.println("<script>");
	out.println("alert('" + original.getCategory() + " 카테고리를 " + vo.getCategory() + " 카테고리로 수정완료!!')");
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>

</body>
</html>