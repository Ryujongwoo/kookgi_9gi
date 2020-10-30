<%@page import="com.koreait.service.DeleteService"%>
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

<%
	request.setCharacterEncoding("UTF-8");
//	delete.jsp에서 넘어오는 데이터를 받는다. => VO 클래스에 멤버로 존재하면 useBean으로 받고 나머지는 별도로 받는다.
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
%>

<jsp:useBean id="vo" class="com.koreait.vo.GuestbookVO">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>

<%
//	삭제할 글의 비밀번호와 삭제하기 위해 입력한 비밀번호를 비교하기 위해 삭제할 글을 테이블에서 얻어온다.
	GuestbookVO original = SelectService.getInstance().selectByIdx(vo.getIdx());

//	oracle은 필드를 char로 선언하면 필드의 자리수보다 입력된 글자수가 적을 때 남는 자리가 모두 공백으로 리턴된다.
//	필드를 선언할 때 char 대신 varchar2를 사용하면 남는 자리가 공백으로 처리되지 않는다. => 이미 char로 선언한 상태라면 trim() 메소드를 이용해서
//	불필요한 빈 칸을 제거하면 된다.
//	out.println("삭제하기 위해 입력한 비밀번호의 글자수 : " + vo.getPassword().length() + "<br/>");
//	out.println("삭제할 글의 비밀번호 글자수 : " + original.getPassword().length() + "<br/>");

//	삭제할 글의 비밀번호와 삭제하기 위해 입력한 비밀번호가 같으면 글을 삭제한다.
	out.println("<script>");
	if (original.getPassword().trim().equals(vo.getPassword())) {
//		비밀번호가 일치하므로 글을 삭제한다.

		DeleteService.getInstance().delete(vo.getIdx());

		out.println("alert('" + vo.getIdx() + "번 글 삭제완료!!!')");
	} else {
//		비밀번호가 일치하지 않기 때문에 오류 메시지를 출력한다.
		out.println("alert('비밀번호가 일치하지 않습니다.')");
	}
	out.println("location.href='list.jsp?currentPage=" + currentPage + "'");
	out.println("</script>");
%>

</body>
</html>












