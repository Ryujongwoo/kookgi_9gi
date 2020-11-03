<%@page import="java.util.ArrayList"%>
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
//	service.delete(vo.getIdx());

//	2. 삭제 버튼이 클릭되면 해당 카테고리 자체를 "삭제된 카테고리 입니다."로 수정한다.
//	service.deleteCategory(vo.getIdx());

//	3. 삭제 버튼이 클릭되면 deleteCheck 필드의 값을 "yes"로 수정한다.
//	service.deleteCheck(vo.getIdx());

//	4. 삭제 버튼이 클릭되면 삭제한 카테고리의 모든 서브 카테고리도 일괄적으로 삭제한다.
//	삭제할 카테고리와 삭제할 카테고리의 모든 서브 카테고리 목록을 얻어와서 ArrayList에 저장한다.
	ArrayList<CategoryVO> deleteList = service.deleteList(vo);
	for (int i = 0; i < deleteList.size(); i++) {
		out.println(deleteList.get(i) + "<br/>");
	}

	out.println("<script>");
//	out.println("alert('" + original.getIdx() + "번 카테고리 삭제완료!!')");
//	out.println("alert('" + original.getCategory() + " 카테고리 삭제완료!!')");
//	out.println("alert('" + original.getCategory() + " 카테고리와 모든 서브 카테고리 삭제완료!!')");
//	out.println("location.href='list.jsp'");
	out.println("</script>");
%>

</body>
</html>







