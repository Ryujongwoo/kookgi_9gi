<%@page import="com.koreait.vo.FreeboardVO"%>
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
//	한글 깨짐을 방지하고 update.jsp에서 넘어오는 데이터를 받는다.
	request.setCharacterEncoding("UTF-8");
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
%>

<jsp:useBean id="vo" class="com.koreait.vo.FreeboardVO">
	<jsp:setProperty property="*" name="vo"/>
</jsp:useBean>

<%
	FreeboardService service = FreeboardService.getInstance();
//	수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교하기 위해 수정할 글을 얻어온다.
	FreeboardVO original = service.selectByIdx(vo.getIdx());

//	수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교해 같으면 글을 수정한 후 목록으로 돌아가고 같지 않으면 비밀번호가 일치하지 않다는
//	메시지를 보여준 후 목록으로 돌아간다.
	out.println("<script>");
	if (original.getPassword().trim().equals(vo.getPassword().trim())) {
		
//		공지글을 내용만 수정하고 전송 버튼을 클릭하면 체크 박스에 체크가 되어있을 경우 value 속성이 지정되지 않으면 "on"이 넘어오므로 그대로
//		상태를 유지하게 하기 위해서 notice 멤버 변수를 "notice"로 수정한다.
		if (vo.getNotice().equals("on")) {
			vo.setNotice("notice");
		}
		service.update(vo);
		
		out.println("alert('" + vo.getIdx() + "번 글 수정완로')");
	} else {
		out.println("alert('비밀번호가 올바르지 않습니다.')");
	}
	out.println("location.href='list.jsp?currentPage=" + currentPage + "'");
	out.println("</script>");
%>

</body>
</html>
















