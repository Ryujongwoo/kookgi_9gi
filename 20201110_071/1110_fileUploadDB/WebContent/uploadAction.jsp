<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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

	String uploadDirectory = application.getRealPath("/upload/");
	MultipartRequest multipartRequest = new MultipartRequest(
		request,
		uploadDirectory,
		5 * 1024 * 1024,
		"UTF-8",
		new DefaultFileRenamePolicy()
	);
	
//	단일 파일 업로드
//	getOriginalFileName() : 사용자가 업로드 한 파일의 이름을 얻어온다.
	String fileName = multipartRequest.getOriginalFileName("file");
	out.println("fileName : " + fileName + "<br/>");
//	getFilesystemName() : 업로드 되서 실제 디스크에 저장된 파일 이름을 얻어온다.
	String fileRealName = multipartRequest.getFilesystemName("file");
	out.println("fileRealName : " + fileRealName + "<br/>");
%>

<a href="index.jsp">돌아가기</a>

</body>
</html>



















