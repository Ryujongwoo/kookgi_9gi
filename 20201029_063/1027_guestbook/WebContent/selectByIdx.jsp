<%@page import="com.koreait.service.SelectService"%>
<%@page import="com.koreait.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 수정 또는 삭제할 글 1건을 얻어와서 request 영역에 저장한 후 수정 또는 삭제할 글을 브라우저에 표시하는 페이지로 넘겨준다. -->
<%
	request.setCharacterEncoding("UTF-8");
//	listView2.jsp에서 수정 또는 삭제 버튼이 클릭되면 넘어오는 데이터를 받는다.
	int idx = Integer.parseInt(request.getParameter("idx"));
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	String job = request.getParameter("job");
	
//	수정 또는 삭제할 글 1건을 얻어온다.
	GuestbookVO vo = SelectService.getInstance().selectByIdx(idx);
//	out.println(vo + "<br/>");

//	수정 또는 삭제할 글이 테이블에 존재하지 않으면 에러 메시지를 출력하고 list.jsp로 돌려보내고 글이 테이블에 존재하면 수정 버튼이 클릭된 경우
//	수정할 글을 브라우저에 표시하는 페이지(update.jsp)로 삭제 버튼이 클릭되면 삭제할 글을 브라우저에 표시하는 페이지(delete.jsp)로 넘겨준다.
	if (vo == null) {
//		수정 또는 삭제할 글이 테이블에 존재하지 않기 때문에 에러 메시지를 출력하고 목록으로 보낸다.
		out.println("<script>");
		out.println("alert('" + idx + "번 글은 테이블에 존재하지 않습니다.')");
		out.println("location.href='list.jsp'");
		out.println("</script>");
	} else {
//		수정 또는 삭제할 글이 테이블에 존재하므로 request 영역에 저장한 후 클릭된 버튼이 브라우저에 표시할 페이지로 넘겨준다.
		request.setAttribute("vo", vo);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("enter", "\r\n");
		pageContext.forward(job + ".jsp");
	}
%>

</body>
</html>