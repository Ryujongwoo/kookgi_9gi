<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드 페이지</title>
</head>
<body>

<%
	String uploadDirectory = application.getRealPath("/upload/");
//	list() : 지정된 디렉토리(폴더)에 저장된 파일 이름 목록을 얻어온다.
	String[] files = new File(uploadDirectory).list();
	for (String file : files) {
//		out.println(file + "<br/>");
%>
		<a href="<%=request.getContextPath()%>/downloadAction?file=<%=URLEncoder.encode(file, "UTF-8")%>"><%=file%></a><br/>
<%
	}
%>

<a href="index.jsp">돌아가기</a>

</body>
</html>













