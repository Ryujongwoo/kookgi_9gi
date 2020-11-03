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
//	복구할 카테고리 이름을 복구 완료 메시지에 표시하기 위해 복구할 카테고리 한 건을 테이블에서 얻어온다.
	CategoryVO original = service.selectByIdx(vo.getIdx());
//	out.println(original);

//	복구 버튼이 클릭되면 deleteCheck 필드의 값을 "no"로 수정한다.
	service.deleteRestore(vo.getIdx());

	out.println("<script>");
	if (original.getDeleteReport() > 10) {
		out.println("alert('" + original.getCategory() + " 카테고리는 신고를 만땅 먹은 카테고리라 복구할 수 없어욧~~~~~')");
	} else {
		out.println("alert('" + original.getCategory() + " 카테고리 복구완료!!')");
	}
	out.println("location.href='list.jsp'");
	out.println("</script>");
%>

</body>
</html>







